package 计算机知识技巧.双指针;

public class leetcode_11盛最多水的容器 {
    public static void main(String[] args) {
        Solution11 solution2 = new Solution11();
        int[] dp = new int[]{1,8,6,2,5,4,8,3,7};
        int i = solution2.maxArea(dp);
        System.out.println(i);
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int sum = 0;
        while(start < end){
            sum = Math.max(Math.min(height[start],height[end]) * (end-start),sum);
            //System.out.println(sum);
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return sum;
    }
/*
再写一遍的时候还是不习惯写while，所以写了循环
方法：双指针
难点：在初始时，左右指针分别指向数组的左右两端
移动哪一个呢？直觉告诉我们，应该移动对应数字较小的那个指针（即此时的左指针）。这是因为，由于容纳的水量是由
两个指针指向的数字中较小值∗指针之间的距离
如果移动指针指向的较大的值，那么较小值肯定不会增加，但是距离变短了。
 */
    public int maxArea2(int[] height) {
        int start = 0;
        int end = height.length -1 ;
        int sum = 0;
        for(int i = 0;i<height.length;i++){
            if(start > end){
                return sum;
            }
            sum = Math.max(Math.min(height[start],height[end]) * (end - start), sum);
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return sum;
    }
}