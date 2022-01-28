package com.dspersist.services;

import java.util.List;
import java.util.stream.Collectors;

import com.dspersist.entities.Article;
import com.dspersist.entities.Tag;

import redis.clients.jedis.Jedis;

public class ArticleService {
  private Jedis jedis;

  public ArticleService(Jedis jedis) {
    this.jedis = jedis;
  }

  public void create(Article article) {
    List<Integer> ids = this.jedis.smembers("all:art").stream().map(Integer::valueOf).collect(Collectors.toList());
    Integer idArticle = ids.size() + 1;
    jedis.hset("art:" + idArticle, article.toMap());
    jedis.sadd("all:art", Integer.toString(idArticle));
  }

  public void addTagToArticle(String tagname, Integer articleId) {
    jedis.sadd("art:" + articleId + ":tags", tagname);
    jedis.sadd("tags:art:" + tagname, Integer.toString(articleId));
  }

  public List<Article> list() {
    return this.jedis.smembers("all:art").stream().map((String id) -> Article.toArticle(jedis.hgetAll("art:" + id))).collect(Collectors.toList());
  }

  public List<Tag> tagsByArticleId(Integer id) {
    return this.jedis.smembers("art:" + id + ":tags").stream().map((tagname) -> new Tag(tagname)).collect(Collectors.toList());
  }

  public List<Article> articleByTags(String tagname) {
    return this.jedis.smembers("tags:art:" + tagname).stream().map((String id) -> Article.toArticle(jedis.hgetAll("art:" + id))).collect(Collectors.toList());
  }
}
