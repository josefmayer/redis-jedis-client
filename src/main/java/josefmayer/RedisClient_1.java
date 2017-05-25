package josefmayer;

import redis.clients.jedis.Jedis;
//import redis.clients.jedis.*;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import java.util.ArrayList;


public class RedisClient_1{

    public static void main( String[] args )
    {
        Jedis jedis = new Jedis("localhost");

        storeString(jedis);
        storeList(jedis);

        printString(jedis);
        printListRange(jedis);
        printListKey(jedis);

    }

    static void storeString(Jedis jedis){
        jedis.set("tutorial-name", "Redis-Example");
    }

    static void storeList(Jedis jedis) {
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
    }

    static void printString(Jedis jedis){
        String value = jedis.get("tutorial-name");
        System.out.println( value );
    }

    static void printListRange(Jedis jedis){
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);

        for(int i = 0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
    }

    static void printListKey(Jedis jedis){
        Set <String> set = jedis.keys("*");

        for(String str : set) {
            System.out.println(str);
        }
    }

}