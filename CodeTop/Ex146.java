package CodeTop;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chuYun
 * @description: 146.LRU缓存
 * @date 2025/6/1 16:01
 */
class LRUCache{
    // 容量
    private final int capacity;
    // 队列
    // 将最近访问的放到最后，那么第一个节点就是最近最少使用的
    private final Map<Integer, Integer> map = new LinkedHashMap<>();
    // 初始化
    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    // get
    // 找不到返回-1,找到了取得，将该key放在队列尾部
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        // 存在，返回
        int value = map.remove(key);
        map.put(key, value);
        return value;
    }

    // put
    // 若存在变更
    // 超过删除最久未使用
    public void put(int key, int value){
        if(map.containsKey(key)){
            // 存在
            map.remove(key);
            map.put(key, value);
            return;
        }
        // 队满
        if(map.size() == capacity){
            // 获取key的set集合，并迭代获取第一个元素
            int oldkey = map.keySet().iterator().next();
            map.remove(oldkey);
        }
        // 队不满
        map.put(key, value);
    }

}

public class Ex146 {

}
