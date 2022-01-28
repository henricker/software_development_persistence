package com.dspersist.entities;

public class Tag {
  private String name;

  public Tag() {}

  public Tag(String name) {
    this.name = name;
  }

  public void setTag(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Tag{ name: " + name + " }";
  }
}
