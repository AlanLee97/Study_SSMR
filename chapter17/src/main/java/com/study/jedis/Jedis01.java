package com.study.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 学习Jedis
 *
 */
public class Jedis01 {
    //连接jedis
    private Jedis jedis = new Jedis("localhost", 6379);

    /**
     * 使用连接池管理
     */
    public JedisPool testPool(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxIdle(50);
        poolConfig.setMaxWaitMillis(20000);

        JedisPool pool = new JedisPool(poolConfig, "localhost",6379);
        Jedis jedis = pool.getResource();
        return pool;
    }


    /**
     * 使用java操作jedis
     */
    @Test
    public void useJedisInJava(){
        String key1 = jedis.get("key1");
        System.out.println(key1);

        //设置值
        jedis.set("key2", "value2");
        //获取值
        String key2 = jedis.get("key2");
        System.out.println(key2);
    }

    /**
     * 在spring中使用jedis
     */
    @Test
    public void useJedisInSpring(){

    }




}
