package com.project.entity;
import java.io.Serializable;
import java.util.Map;

public class Developer implements Serializable {
  private String name;
  private String github;
  private String favoriteLanguage;
  private Level level;

  public Developer(Map<String, Object> data) {
    this.name = String.valueOf(data.get("name"));
    this.level = Level.valueOf(String.valueOf(data.get("level")));
    this.github = String.valueOf(data.get("github"));
    this.favoriteLanguage = String.valueOf(data.get("favoriteLanguage"));
  }
}