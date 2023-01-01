package 其他类型;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 146
 * @author: 杨晨曦
 * @create: 2022-09-14 22:14
 * 通过了 20/22 个用例 在大数据下会超时
 **/
public class leetcode_146LRU缓存 {

}
class LRUCache {
    private int len;
    private Deque deque = new LinkedList();
    private Map<Integer,Integer> map = new HashMap<>();
    private Set<Integer> set = map.keySet();

    public LRUCache(int capacity) {
        len = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
                if(deque.contains(key)){
                    deque.remove(key);
                    deque.addFirst(key);
                }else{
                    deque.addFirst(key);
                }
                return map.get(key);

            }

        return -1;
    }

    public void put(int key, int value) {
        if(map.size() >= len){
            if(!map.containsKey(key)){
                int number = (int) deque.removeLast();
                System.out.println(deque.toString());
                map.remove(number);
                map.put(key,value);
                if(deque.contains(key)){
                    deque.remove(key);
                    deque.addFirst(key);
                }else{
                    deque.addFirst(key);
                }
            }else{
                map.put(key,value);
                if(deque.contains(key)){
                    deque.remove(key);
                    deque.addFirst(key);
                }else{
                    deque.addFirst(key);
                }
            }

        }else{
            map.put(key,value);
            if(deque.contains(key)){
                deque.remove(key);
                deque.addFirst(key);
            }else{
                deque.addFirst(key);
            }
        }
    }
}
