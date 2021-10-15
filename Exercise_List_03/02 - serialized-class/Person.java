import java.io.Serializable;

public class Person implements Serializable {
  public String name, email, phone;
  public Integer age;

  public Person() {}
  public Person(String name, Integer age, String email, String phone) {
    this.name = name;
    this.age = age;
    this.email = email;
    this.phone = phone;
  }
}