## 2. Crie uma classe Java de entidade. Exemplo: Pessoa (id, nome, email, fone). A classe deve implementar a interface java.io.Serializable.

### Como fiz?
  - Basicamente só a criação de uma classe Person onde possui as seguintes propriedades:
  ```java
  import java.io.Serializable;

  public class Person implements Serializable {
    public String name, email, phone;
    public Integer age;

    public Person() {}
    public Person(
      String name, 
      Integer age, 
      String email, 
      String phone
      ) {
      this.name = name;
      this.age = age;
      this.email = email;
      this.phone = phone;
    }
  }
  ```