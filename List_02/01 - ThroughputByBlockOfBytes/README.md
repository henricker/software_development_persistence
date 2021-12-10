## Escreva uma aplicação para ler um arquivo binário origem e gravá-lo em outro arquivo (arquivo destino).



  ### Requisitos: 


  - Os nomes dos arquivos (origem e destino) devem ser definidos na chamada da aplicação via argumento de linha de comando.
  - A leitura e gravação devem ser realizadas em blocos de bytes e   não byte a byte.
  - Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida.
  - Teste vários tamanhos de bloco e encontre um tamanho que ofereça um bom desempenho. Crie uma tabela para comparar os resultados encontrados.



  ### Sobre a aplicação:

    
   - Decidi deixar a aplicação mais genérica onde você passa o nome do arquivo de origem, destino e o tamanho de blocos de bytes a serem lidos.
   - Adicione um um arquivo na pasta static do projeto para testarmos a taxa de transferência e o tempo em ms durante a cópia dos dados.
   - Para rodar a aplicação basta dar "run" no arquivo App.java, ele abrirá o console e então digite os seguintes dados na mesma linha:
    
    ```
      arquivo-origem arquivo-destino tamanhoDosBlocosDeBytes

      Por exemplo:
        city.jpg city-copy.jpg 8152
    ```
  
   - Quando executado terá como output os seguintes dados:

   ```
      Transfer data to destiny file finish with success!
      total time: ${time} ms
      total size transferred: ${size} bytes
      throughput: ${size/time} bytes/ms
   ```


  ### Resultados
  
  - Realizei os testes com uma imagem com alta qualidade e resolução com um total de 17878139 bytes.

  - Foi constatado que quando aumentamos o valor do tamanho dos blocos de bytes o tempo de transferência tende a diminuir, ou seja o tamanho dos blocos é inversamente proporcional ao tempo gasto de leitura.

  - Foi criado uma tabela onde é feito uma cópia do arquivo que adicionei com diferentes tamanhos de bloco de bytes.

    <table>
      <thead>
        <tr>
          <th>Size of block bytes (bytes)</th>
          <th>Time (ms) </th>
          <th>Size of file (bytes)</th>
          <th>Throughput (bytes/ms)</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td style="text-align: center;">1</td>
          <td style="text-align: center;">215859</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">82</td>
        </tr>
        <tr>
          <td style="text-align: center;">100</td>
          <td style="text-align: center;">2596</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">6886</td>
        </tr>
        <tr>
          <td style="text-align: center;">1000</td>
          <td style="text-align: center;">504</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">35472</td>
        </tr>
        <tr>
          <td style="text-align: center;">8152</td>
          <td style="text-align: center;">92</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">194327</td>
        </tr>
        <tr>
          <td style="text-align: center;">10000</td>
          <td style="text-align: center;">146</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">122453</td>
        </tr>
        <tr>
          <td style="text-align: center;">100000</td>
          <td style="text-align: center;">59</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">303019</td>
        </tr>
        <tr>
          <td style="text-align: center;">1000000</td>
          <td style="text-align: center;">58</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">308243</td>
        </tr>        
        <tr>
          <td style="text-align: center;">10000000</td>
          <td style="text-align: center;">65</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">308243</td>
        </tr>
        <tr>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">66</td>
          <td style="text-align: center;">17878139</td>
          <td style="text-align: center;">270880</td>
        </tr>
      </tbody>
    </table>

 ### Conclusão

   
   - Como visto na tabela, a medida que aumentamos a quantidade de bytes a serem transferidos há uma diminuição considerável do tempo, já que a cada transferẽncia será "puxado" uma maior quantidade de bytes.

   - Acredito que dependendo da aplicação a ser desenvolvida e do host que irá executá-la poderá haver diferentes valores da quantidade de bytes a terem uma maior eficiência e compatibilidade.

   - No meu computador, acredito que o tamanho dos blocos de bytes sendo 8152 conseguiu dar um excelente resultado, sem comprometer toda a memória da máquina.

   - Ainda pela tabela perceba que a partir da linha 7 para as outras mais abaixo há um pequeno aumento no tempo de transferência isso se deve ao fato de quando a máquina tenta ler uma maior quantidade de bytes por vez os esforços para armazenar no array de bytes aumenta. Ou seja, nem sempre a melhor decisão seria um maior tamanho de bloco de bytes por transferência.