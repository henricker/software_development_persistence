package com.developers.entity;
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

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name =  name;
  }

  public String getLevel() {
    return String.valueOf(this.level);
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public String getGithub() {
    return this.github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public String getFavoriteLanguage() {
    return this.favoriteLanguage;
  }

  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  }

  @Override
  public String toString() {
    return "{ name:  " + this.name + ", level: " + this.level + ", github: " + this.github + ", favoriteLanguage: " + this.favoriteLanguage + "}";
  }
}