## (Mesma Questão 3 da Lista 02) Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:

  ### Arquivo config.properties
  - linha_inicial = 1
  - linha_final = 3
    
  Depois, escreva uma classe Java que recebe via linha de comando o nome de um arquivo texto, e exibe da linha_inicial até a linha_final, conforme definidas no arquivo de propriedades config.properties.


 ### Sobre a minha solução:
 - Tentei deixar a questão da maneira mais genérica possível, onde basta passar qualquer nome de arquivo (desde que esteja no diretório `resources`) e basta adicionar qualquer "valor_inicial" e "valor_final" no arquivo `config.properties`.

 - Por padrão a aplicação irá rodar adicionando automaticamente o `file.txt` via args, caso você queira testar com outro arquivo basta ir nas configurações do compilador em  `.vscode/launch.json` e altere o valor do array de "args" para o nome do seu arquivo, abaixo segue um exemplo:
    ```json
    {
      "version": "0.2.0",
      "configurations": [
        {
          "type": "java",
          "name": "Launch Current File",
          "request": "launch",
          "mainClass": "${file}"
        },
        {
          "type": "java",
          "name": "Launch App",
          "request": "launch",
          "mainClass": "App",
          "projectName": "01 - config_properties_d900f2bd",
          // ao invés de "file.txt" fica o nome do seu arquivo de testes :D
          "args": ["file.txt"] 
        }
      ]
    }
    ```

  - O projeto possui uma classe `GetScannerFile` onde é responsável por retornar uma instância de Scanner contendo a Stream de qualquer arquivo passado, no caso do arquivo que é enviado via args.

  - Também existe uma classe auxiliar chamada `ReadPropertiesFile` onde é responsável por pegar e carregar qualquer arquivo de propriedades.

  - A classe pricipal onde ocorre a lógica de leitura das linhas do arquivo via args é o `ReadProperties`

  - Para rodar o projeto basta ir na classe `App.java` e rodar!


