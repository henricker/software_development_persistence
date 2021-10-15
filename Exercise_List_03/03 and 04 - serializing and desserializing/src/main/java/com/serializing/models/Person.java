package com.serializing.models;
import java.io.Serializable;

public class Person implements Serializable {
  private String name;
  private String email;
  private String phone;
  private Integer age;

  public Person(){}
  public Person(String name, String email, String phone, Integer age) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.age = age;
  }

  public String getName() { return name; }
  public String getEmail() { return email; }
  public String getPhone() { return phone; }
  public Integer getAge() { return age; }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "{ name:" + this.name + ", email: " + this.email + ", phone: " + this.phone + ", age: " + this.age + " }";
  }
}