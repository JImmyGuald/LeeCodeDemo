package com.guald.demo;

import java.util.*;

/**
 * @author jayden.gan
 * @description
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * @create 2020/4/3 16:07
 */

    /*
    示例：
    LRUCache cache = new LRUCache( 2 *//* 缓存容量 *//* );
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4
    */

public class LC200403 {

    class LRUCache {
        private LinkedHashMap<Integer,Integer> cache;
        private int size;
        public LRUCache(int capacity) {
            this.cache = new LinkedHashMap<>();
            this.size = capacity;
        }

        public int get(int key) {
            if(cache.containsKey(key)){
                int result = cache.get(key);
                cache.remove(key);
                cache.put(key,result);
                return result;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(!cache.containsKey(key)){
                if(cache.size() == this.size){
                    Iterator<Integer> i = cache.keySet().iterator();
                    if(i.hasNext()){
                        int first = i.next();
                        cache.remove(first);
                        cache.put(key,value);
                    }
                }else{
                    cache.put(key,value);
                }
            }else{
                cache.remove(key);
                cache.put(key,value);
            }
        }
    }
}
