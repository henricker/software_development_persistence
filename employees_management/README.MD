# Developers

## Sobre a atividade

1 - Crie uma aplicação que use um banco relacional contendo uma tabela de funcionários, com suas respectivas classes Java.
Cada funcionário deve ter um id, cpf, matrícula, nome, email e telefone.

2 - Os campos id, cpf e matrícula devem não devem permitir duplicação, ou seja devem ser únicos.

3 - Crie uma implementação de DAO usando JDBC que representa uma interface única para persistência dos dados.

4 - Crie e use no DAO somente os métodos realmente necessários para a resolução desta lista. Crie-os sob demanda.

5 - Crie métodos no DAO para inserir, deletar, alterar e consultar funcionários.

5 - A aplicação deve ter um menu para realizar as funcionalidades previstas nas questões anteriores (consultas e atualizações).


## Como fiz ?

- Utilizei uns conceitos que aprendi no trabalho, no projeto estou utilizando uma arquitetura mais limpa voltada para o domínio e as regras de negócios do sisteminha. (DDD)

- Dentro da pasta src temos as seguintes:
   
   - data => A camada onde se encontram as implementações de banco de dados e é lá onde existe a implementação JDBC de um banco postgres;
   
   - domain => A camada core, onde estão armazenados os modelos, regras de negócio e as interfaces de serviço e repositórios.
   
   - main => É a única camada onde permitimos um acoplamento, é nela onde criamos as implementações das interfaces de serviços do domain e também é responsável pela camada de UI do sistema
   
   - shared => Possui algumas classes usuais em todas as camadas como erros e outros

- O bom de usarmos uma arquitetura assim é que possamos preservar e deixar intocável todas as nossas regras de negócio e modelos!


## Sobre as funcionalidades ?

  - Um CRUD simples de funcionários;
  - No sistema você pode:
    - Criar um funcionário;
    - Listar todos os funcionários (com paginação):
      - page => página atual (inicia em 1)
      - limit => limit de funcionários por página
    - Atualizar um funcionário com base no seu id
    - Deletar um funcionário com base em seu id

## Como rodar o projeto ?

 - Antes de rodar, deixei um arquivo docker-compose com as configurações de um banco postgres;

 - Caso tenha docker instalado em sua máquina rode:
  
    ```bash
      docker-compose up
    ```
    irá subir um container do postgres com o ambiente configurado para você testar

- Caso não tenha docker instalado na máquina você pode criar uma tabela "employees"
  
  - Código de criação da tabela está no diretório 
     - src/data/postgres/sql/table.sql 

  - Adicione o seu login, senha e url em:
    - src/main/resources/config.properties


- Após isso, basta rodar a classe App.java!