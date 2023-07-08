# DataExtractor

Este script em Java é usado para extrair dados de uma API e salvá-los em um arquivo CSV.

## Uso

1. Compile e execute o script Java `DataExtractor.java`.
2. Será solicitado que você insira a URL da API.
3. Digite a URL completa da API desejada e pressione Enter.
4. O script fará uma solicitação à API e extrairá os dados recebidos.
5. Os dados serão salvos em um arquivo chamado `data.csv`.
6. O resultado da extração será exibido no console.

## Pré-requisitos

- Java Development Kit (JDK) instalado.
- Conexão com a internet para acessar a API.

## Bibliotecas utilizadas

- `java.io.FileWriter`: Usada para escrever os dados extraídos em um arquivo CSV.
- `java.net.HttpURLConnection`: Usada para fazer uma solicitação à API.
- `java.net.URL`: Usada para representar a URL da API.
- `java.util.Scanner`: Usada para ler a entrada do usuário e o fluxo de entrada da API.
- `org.json.JSONArray` e `org.json.JSONObject`: Usadas para manipular dados JSON recebidos da API.

## Notas

- Certifique-se de fornecer uma URL válida da API.
- Os dados extraídos serão salvos em um arquivo chamado `data.csv` no mesmo diretório do script.
- Certifique-se de ter permissões de escrita no diretório onde o script está sendo executado.
