import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode_347前K个高频元素 {
}
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int n = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],n);
        }
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}