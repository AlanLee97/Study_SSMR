package com.study.test;

import com.study.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class Test {
    @org.junit.Test
    public void testJedisSpring(){

        //加载配置
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取RedisTemplate的bean
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        //创建对象
        final Role role = new Role();
        role.setId(1);
        role.setRoleName("Alan");
        role.setNote("i am alan");

        //为保证每次使用同一个连接 使用SessionCallback
        SessionCallback sessionCallback = new SessionCallback() {
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.boundValueOps("role").set(role);
                return redisOperations.boundValueOps("role").get();
            }
        };

        //这个方式不能保证每次为同一个连接池的连接
        /*redisTemplate.opsForValue().set("role1", role);
        Role role1 = (Role) redisTemplate.opsForValue().get("role1");
        System.out.println(role1.getRoleName());*/

        //执行sessionCallback
        Role savedRole = (Role) redisTemplate.execute(sessionCallback);

        //打印结果
        System.out.println("roleName = " + savedRole.getRoleName());

    }
}
