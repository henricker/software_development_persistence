## Escreva um arquivo de propriedades Java via editor de textos. Esse arquivo deve ter os dados de chave e valor. Exemplo:
  
  <br>
  
  ### Requisitos:
    
  - Criar um arquivo config.properties

      - linha_inicial = 1
      - linha_final = 3
  
  - Depois, escreva uma classe Java que recebe via linha de comando o nome de um arquivo texto, e exibe da linha_inicial até a linha_final, conforme definidas no arquivo de propriedades config.properties.

### Sobre o projeto

  - Basta rodar a classe App para executar o projeto.
  - Assim que rodado, abrirá o console e então digite o nome do arquivo a ser procurado.
    - Atenção!, o projeto irá procurar os arquivos dentro da pasta `static`.

    - Exemplo:
      ```
        config.properties
      ``` 
  - Assim que você adiciona o nome do arquivo pelo console o programa irá executar e mostrar todas as linhas do config.properties.

    - Exemplo: 
        ```
        ------ Start read ------

        linha_inicial: 1
        linha_final: 3

        ------ End read ------
        ```