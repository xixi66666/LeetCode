package 排序递归贪心;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_56合并区间 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[][] merge = solution13.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {1, 10}});
    }
}
class Solution13 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (point1, point2) -> point1[0]-point2[0]);
        for(int[] i : intervals){
            System.out.println(Arrays.toString(i));
        }

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] n : intervals){
            if(n[0] <= end){
                if(n[0] < start){
                    start = n[0];
                }
                if(n[1] > end){
                    end = n[1];
                }
            }else{
                ans.add(new int[]{start,end});
                start = n[0];
                end = n[1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}