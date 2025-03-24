package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chuYun
 * @description: 146。LRU缓存
 * @date 2025/3/23 20:50
 */
public class Demo146 {


    class LRUCache{
        private final int capacity;
        private final Map<Integer, Integer> cache = new LinkedHashMap<>();


        // 初始化
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        // 根据key得到值
        // 将最近访问的放到最后，那么第一个节点就是
        public int get(int key) {
            Integer value = cache.remove(key);
            if(value != null){
                //key 在cache 中
                cache.put(key, value);
                return value;
            }
            //不在
            return -1;
        }
        // key 不在cache中，那么就把key插入cache，插入前判断cache是否满
        public void put(int key, int value) {

            // 删除key ，并利用key是否存在
            if(cache.remove(key) != null){
                cache.put(key, value);
                return;
            }

            // key不在cache，需要插入，判断是否满
            if(cache.size() == capacity){
                Integer  oldKey = cache.keySet().iterator().next();
                cache.remove(oldKey); //移除最久未使用
            }
            // 不存在且未满，直接插入
            cache.put(key, value);

        }
    }

}
