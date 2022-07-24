package 线性表;

public class leetcode42接雨水 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] n ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(n));
    }


}
class Solution {
    public int trap(int[] height) {
        int rain = 0;
        int[] left_max = new int[height.length];
        int[] right_max = new int[height.length];
        left_max[0] = height[0];
        right_max[height.length-1] = height[height.length-1];
        for(int i = 1;i<height.length;i++){
            left_max[i] = Math.max(left_max[i-1],height[i]);
            System.out.print(left_max[i] + " ");
        }
        System.out.println();
        for(int i = height.length-2;i>=0;i--){
            right_max[i] = Math.max(right_max[i+1],height[i]);
            System.out.print(right_max[i] + " ");
        }
        for(int i = 0;i<height.length;i++){
            int min = Math.min(left_max[i],right_max[i]);
            if(height[i] >= min){
                rain = rain;
            }else{
                rain += min-height[i];
            }
        }
        return rain;
    }
}