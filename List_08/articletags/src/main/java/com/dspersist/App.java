package com.dspersist;

import com.dspersist.entities.Article;
import com.dspersist.services.ArticleService;

import redis.clients.jedis.Jedis;

public class App 
{
    public static void main( String[] args )
    {
        //Check if your redis connection has host equal to "localhost" also port 6379
        Jedis jedis = new Jedis();
        ArticleService at = new ArticleService(jedis);

        //First -> create two articles!
        at.create(new Article("SQL for developers", "blablabla", "002", "29-08-2000")); //by default receive id = 1
        at.create(new Article("Any title", "kkkkkkkkk", "102", "29-08-2010")); //by default receive id = 2

        //Second -> associate to any tag
        at.addTagToArticle("Programming", 1);
        at.addTagToArticle("Love", 2);

        //Third -> List tags by article
        System.out.println("\n--- List tags by article ---");
        System.out.println(at.tagsByArticleId(2)); //Should be [Tag{ name: Love }]
        System.out.println(at.tagsByArticleId(1)); //Should be [Tag{ name: Programing }]

        //Fourth -> List article by tags
        System.out.println("\n--- List article by tags ---");
        System.out.println(at.articleByTags("Programming")); //Should be [Article{ name: Any title, description: kkkkkkkkk, file: 102, date: 29-08-2010 }]
        System.out.println(at.articleByTags("Love")); //Should be [Article{ name: Any title, description: kkkkkkkkk, file: 102, date: 29-08-2010 }]

        //Fifth -> List all articles
        System.out.println("\n --- List all articles ---");
        System.out.println(at.list()); //Should be [Article{ name: Any title, description: kkkkkkkkk, file: 102, date: 29-08-2010 }, Article{ name: SQL for developers, description: blablabla, file: 002, date: 29-08-2000 }]
        jedis.flushAll();
        jedis.close();
    }
    
}
