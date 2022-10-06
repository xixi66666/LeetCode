package other.其他类型;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author YangChenxi
 */
public class leetcode_169多数元素 {
}
class Solution3 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                int num = map.get(nums[i])+1;
                map.put(nums[i],num);
            }
        }
        Set<Integer> keys = map.keySet();
        Iterator iterator = keys.iterator();
        while(iterator.hasNext()){
            int key = (int) iterator.next();
            int value = map.get(key);
            if(value > nums.length/2){
                return key;
            }
        }
        return -1;
    }
}