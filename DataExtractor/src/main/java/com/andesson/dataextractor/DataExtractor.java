/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.andesson.dataextractor;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * author andesson
 */
public class DataExtractor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the API URL: ");
        String url = scanner.nextLine();

        //--  Extract the data --//
        String result = extractorDataToCSV(url);
        System.out.println(result);
    }

    public static String extractorDataToCSV(String urlString) {
        try {
            //-- Make API request --//
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                Scanner scanner = new Scanner(conn.getInputStream());
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();

                JSONArray dataArray = new JSONArray(response);
                int length = dataArray.length();

                if (length > 0) {
                    String csvFile = "data.csv";

                    //-- Open CSV file for writing --//
                    FileWriter writer = new FileWriter(csvFile);

                    //-- Extract headers from the first JSON object --//
                    JSONObject firstObject = dataArray.getJSONObject(0);
                    String[] headers = firstObject.keySet().toArray(new String[0]);

                    //-- Write headers to the CSV --//
                    for (int i = 0; i < headers.length; i++) {
                        writer.append(headers[i]);
                        if (i < headers.length - 1) {
                            writer.append(',');
                        }
                    }
                    writer.append('\n');

                    //-- Write data rows to the CSV --//
                    for (int i = 0; i < length; i++) {
                        JSONObject object = dataArray.getJSONObject(i);
                        System.out.println(response);
                        for (int j = 0; j < headers.length; j++) {
                            String value = object.optString(headers[j], "");
                            writer.append(value);
                            if (j < headers.length - 1) {
                                writer.append(',');
                            }
                        }
                        writer.append('\n');
                    }

                    writer.close();
                    return "Data extracted successfully and saved in " + csvFile + ".";
                } else {
                    return "No data available for extraction.";
                }
            } else {
                return "Failed to call the API.";
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}
