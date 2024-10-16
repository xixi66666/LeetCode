/**
 * @author YangChenxi
 */
public class leetcode_84柱状图中最大的矩形 {
}
/*
思路：
1.进入循环，在遍历第i个数的时候，找到在它左边并且比它小的第一个数的位置start，同理找到右边的位置end，这样end-start+1 * 这个数的值
就是最终得到的值
2.碰到很多数的时候时间复杂太高了，通过了93/96个用例。
3.判断两个特殊值之后通过了95个。
 */
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int number = heights.length;
        int ans = 0;
        for(int i = 0;i<number;i++){
            int start = i, end = i;
            while(start-1 >= 0 && heights[start-1] >= heights[i]){
                start--;
            }
            while(end+1 < number && heights[end+1] >= heights[i]){
                end++;
            }
            System.out.println(start + "  " + end);
            ans = Math.max(ans,(end-start+1)*heights[i]);
        }
        return ans;
    }
}