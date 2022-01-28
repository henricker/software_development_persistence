package com.dspersist.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Article {
  private String name;
  private String description;
  private String file;
  private String date;

  public Article() {}

  public Article(String name, String description, String file, String date) {
    this.name = name;
    this.description = description;
    this.file = file;
    this.date = date;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public String getFile() {
    return this.file;
  }

  public String getDate() {
    return this.date;
  }

  @Override
  public String toString() {
    return "Article{ name: " + name + ", description: " + description + ", file: " + file + ", date: " + date + " }";
  }

  public Map<String, String> toMap() {
    Map<String, String> articleMap = new HashMap<>();
    articleMap.put("desc", getDescription());
    articleMap.put("file", getFile());
    articleMap.put("name", getName());
    articleMap.put("data", getDate());

    return articleMap;
  }

  public static Article toArticle(Map<String, String> articleMap) {
    return new Article(articleMap.get("name"), articleMap.get("desc"), articleMap.get("file"), articleMap.get("data"));
  }
}
