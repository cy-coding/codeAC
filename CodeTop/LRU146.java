//package CodeTop;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author chuYun
// * @description: TODO
// * @date 2025/5/13 9:58
// */
//
//class LRUCache {
//    // 容量
//    private final int capacity;
//    // 队列 --最久未使用的放在队首
//    private final Map<Integer, Integer> cache = new LinkedHashMap<>();
//    // 初始化
//    public LRUCache(int capacity){
//        // 设置缓存容量
//        this.capacity = capacity;
//    }
//    // 将最近访问的放到最后，那么第一个节点就是最近最少使用的
//    public int get(int key){
//        // 不存在，直接返回-1
//        if(!cache.containsKey(key)){
//            return -1;
//        }
//        // 删除添加
//        int value = cache.remove(key);
//        cache.put(key, value);
//        return value;
//    }
//    // key 不在cache中，那么就把key插入cache放到最后，插入前判断cache是否满
//    public void put(int key, int value){
//        // 若存在，则删除冲洗添加
//        if(cache.containsKey(key)){
//            // 若存在
//            cache.remove(key);
//            cache.put(key, value);
//            return;
//        }
//        // 队列满，则删除最久未使用
//        if(cache.size() == capacity){
//            // 获取key的set集合，并迭代获取第一个元素
//            int oldkey = cache.keySet().iterator().next();
//            cache.remove(oldkey);
//        }
//        // 队列不满，直接插入
//        cache.put(key, value);
//    }
//}
//public class LRU146 {
//    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 3); // 缓存是 {1=1,2=2}
//        System.out.println(lRUCache.get(1));
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2));
//    }
//
//}
