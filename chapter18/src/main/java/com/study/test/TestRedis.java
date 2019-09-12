package com.study.test;

import com.study.pojo.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 测试redis
 */
public class TestRedis {
    //获取配置文件
    private ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    //获取bean
    RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

    /**
     * 测试配置是否成功
     */
    @Test
    public void testConnection(){
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取bean
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        //设置键、值
        redisTemplate.opsForValue().set("key1", "value1");

        //根据键获取值
        String key1 = (String) redisTemplate.opsForValue().get("key1");

        //打印结果
        System.out.println(key1);
    }

    /**
     * 测试对象序列化的方法
     */
    @Test
    public void testSerializer(){
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取bean
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        //创建对象
        final Role role = new Role();
        role.setId(1);
        role.setRoleName("AlanLee");

        //系统在redis数据库连接池中获取连接，每次连接都不是同一个连接对象
        //为保证能使用同一个连接对象，这里我采用SessionCallback方式
        SessionCallback sessionCallback = new SessionCallback() {
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //将对象保存到redis中
                redisOperations.boundValueOps("role").set(role);

                //取值并返回取得的值
                return redisOperations.boundValueOps("role").get();

            }
        };

        //执行SessionCallback,将取得的值保存到Role对象中
        Role savedRole = (Role) redisTemplate.execute(sessionCallback);

        //打印结果
        System.out.println(savedRole);
    }

    /**
     * 测试字符串
     */
    @Test
    public void testString(){
        //设值
        redisTemplate.opsForValue().set("key1","value1");
        redisTemplate.opsForValue().set("key2","value2");

        //通过key获取值
        String value1 = (String) redisTemplate.opsForValue().get("key1");
        System.out.println("value1 = " + value1);

        //通过key删除值
        //redisTemplate.delete("key1");

        //求长度
        Long length = redisTemplate.opsForValue().size("key2");
        System.out.println("length = " + length);

        //设置新值并返回旧值
        String oldValue2 = (String) redisTemplate.opsForValue().getAndSet("key2", "new_value2");
        String newValue2 = (String) redisTemplate.opsForValue().get("key2");
        System.out.println("newValue2 = " + newValue2);

        //求子串
        String rangeValue2 = (String) redisTemplate.opsForValue().get("key2", 0, 3);
        System.out.println("rangeValue2 = " + rangeValue2);

        //追加字符串到末尾，返回新字符串长度
        Integer newLen = redisTemplate.opsForValue().append("key2", "_app");
        System.out.println("newLen = " + newLen);
        String appendValue2 = (String) redisTemplate.opsForValue().get("key2");
        System.out.println("appendValue2 = " + appendValue2);

    }

    /**
     * 测试redis运算
     */
    @Test
    public void testCal(){
        //设置值
        redisTemplate.opsForValue().set("i", "20");
        System.out.println("set(\"i\", \"20\")");
        printCurrValue(redisTemplate, "i");

        //值减1
        redisTemplate.getConnectionFactory().getConnection().decr(
                redisTemplate.getKeySerializer().serialize("i")
        );
        System.out.println("decr -- serialize");
        printCurrValue(redisTemplate, "i");

        //值减6
        redisTemplate.getConnectionFactory().getConnection().decrBy(
                redisTemplate.getKeySerializer().serialize("i"), 6
        );
        System.out.println("decrBy -- serialize 6");
        printCurrValue(redisTemplate,"i");

        //值加浮点数2.3
        redisTemplate.opsForValue().increment("i", 2.3);
        System.out.println("increment(\"i\", 2.3)");
        printCurrValue(redisTemplate,"i");

//        redisTemplate.opsForValue().decrement("i",2);
//        System.out.println("decrement(\"i\",2)");
//        printCurrValue(redisTemplate,"i");
    }

    /**
     * 打印当前key的值
     * @param redisTemplate redisTemplate
     * @param key key值
     */
    private void printCurrValue(RedisTemplate redisTemplate, String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        System.err.println(value + "\n");
    }

    /**
     * 测试哈希
     */
    @Test
    public void testHash(){
        String key = "hash2";
        Map<String, String> map = new HashMap<String, String>();
        map.put("f1", "value1");
        map.put("f2", "value2");

        //相当于hmset命令
        redisTemplate.opsForHash().putAll(key, map);

        //相当于hset命令
        redisTemplate.opsForHash().put(key,"f3", "6");

        //相当于hgetall
        Map keyValueMap = redisTemplate.opsForHash().entries(key);

        //相当于hincrby
        redisTemplate.opsForHash().increment(key,"f3",0.88);

        //相当于hexists
        Boolean exists = redisTemplate.opsForHash().hasKey(key,"f3");
        System.out.println(exists);

        //相当于hvals
        List valueList = redisTemplate.opsForHash().values(key);

        //相当于hkeys
        Set keyList = redisTemplate.opsForHash().keys(key);
        List<String> fieldList = new ArrayList<String>();
        fieldList.add("f1");
        fieldList.add("f2");

        //相当于hmget
        List valueList2 = redisTemplate.opsForHash().multiGet(key,keyList);

        //相当于hsetnx
        boolean success = redisTemplate.opsForHash().putIfAbsent(key,"f4","val4");
        System.out.println(success);

        Long result = redisTemplate.opsForHash().delete(key,"f1","f2");
        System.out.println(result);


    }

    /**
     * 打印数据
     */
    public void printValueForHash(String key, String field){
        Object value = redisTemplate.opsForHash().get(key, field);
        System.out.println(value + "\n");
    }


    /**
     * 测试链表
     */
    public void testLinked(){
        try {
            String list = "list";

            //删除链表
            redisTemplate.delete(list);

            //把node3插入链表list
            redisTemplate.opsForList().leftPush(list, "node3");

            List<String> nodeList = new ArrayList<String>();
            for (int i = 2; i >= 1; i--) {
                nodeList.add("node" + i);
            }

            //相当于lpush把多个值从左插入链表
            redisTemplate.opsForList().leftPushAll(list,nodeList);

            //从右边插入一个节点
            redisTemplate.opsForList().rightPush(list,"node4");

            //获取下标为0的节点
            String node1 = (String) redisTemplate.opsForList().index(list, 0);

            //获取链表长度
            long size = redisTemplate.opsForList().size(list);

            //从左边弹出一个节点
            redisTemplate.opsForList().leftPop(list);

            //从右边弹出一个节点
            redisTemplate.opsForList().rightPop(list);

            //需要使用底层的命令才能操作linsert命令
            //使用linsert命令在node2前插入一个节点
            redisTemplate.getConnectionFactory().getConnection().lInsert(
                    list.getBytes("utf-8"),
                    RedisListCommands.Position.BEFORE,
                    "node2".getBytes("utf-8"),
                    "before_node2".getBytes("utf-8")
                    );

            //使用linsert命令在node2后插入一个节点
            redisTemplate.getConnectionFactory().getConnection().lInsert(
                    list.getBytes("utf-8"),
                    RedisListCommands.Position.AFTER,
                    "node2".getBytes("utf-8"),
                    "after_node2".getBytes("utf-8")
            );

            //判断list是否存在，存在就从左边插入head节点
            redisTemplate.opsForList().leftPushIfPresent(list, "head");

            //判断list是否存在，存在就从左边插入head节点
            redisTemplate.opsForList().rightPushIfPresent(list, "end");

            //从左到右显示节点
            redisTemplate.opsForList().range(list, 0, 10);

            List nodeList2 = new ArrayList();
            nodeList2.add("node");
            nodeList2.add("node");
            nodeList2.add("node");

            //在链表左边插入3个值为node的节点
            redisTemplate.opsForList().leftPushAll(list, nodeList2);

            //给链表下标为0的节点设置新值
            redisTemplate.opsForList().set(list,0,"new_head_value");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试集合
     */
    public void testSet(){
        String set5 = "set5";
        String set6 = "set6";
        redisTemplate.boundSetOps(set5).add("v1", "v2", "v3", "v4", "v5", "v6");
        redisTemplate.boundSetOps(set6).add("v0","v2","v4","v6","v8");
        redisTemplate.opsForSet().size(set5);
        redisTemplate.opsForSet().difference(set5,set6);
        redisTemplate.opsForSet().intersect(set5,set6);
        redisTemplate.opsForSet().isMember(set5,"v1");
        redisTemplate.opsForSet().members(set5);
        redisTemplate.opsForSet().pop(set5);
        redisTemplate.opsForSet().randomMember(set5);
        redisTemplate.opsForSet().randomMembers(set5,2L);
        redisTemplate.opsForSet().remove(set5,"v1");
        redisTemplate.opsForSet().union(set5,set6);
        redisTemplate.opsForSet().differenceAndStore(set5,set6,"diff_set2");
        redisTemplate.opsForSet().intersectAndStore(set5,set6,"inter_set2");
        redisTemplate.opsForSet().unionAndStore(set5,set6,"union_set2");



    }
}
