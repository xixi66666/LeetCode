package 排序递归贪心;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_56合并区间 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[][] merge = solution13.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
class Solution13 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int[] t = new int[2];
        t[0] = intervals[0][0];
        t[1] = intervals[0][1];
        for(int[] n : intervals){
            if(n[0] < t[1]){
                t[1] = n[1];
            }else{
                t[0] = n[0];
                t[1] = n[1];
                int[] a = t;
                ans.add(a);
                System.out.println(Arrays.toString(a));
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}