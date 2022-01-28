package com.dspersist.config;

import redis.clients.jedis.Jedis;

public class RedisFactory {
  
  public static Jedis getConnection() {
    return new Jedis();
  }
  
}
