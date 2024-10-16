/**
 * @program: LeetCode
 * @description:
 * @author: 杨晨曦
 * @create: 2023-02-01 17:26
 **/
/*
思路：
1.最小堆
2.动态规划 一个数x是丑数，那么2x，3x，5x也会是丑数
所以用 三个指针 p2 p3 p5 来代表2x，3x，5x中 x的位置，初始值都是dp[0] 的值，即是1
进入循环后，当第dp[i] 个选择的是 哪一个倍数，对应的指针加一即可，注意，指针代表的是dp中的位置，而不是1234
 */
public class leetcode_264丑数2 {
    public static void main(String[] args) {
        Solution264 solution6 = new Solution264();
        int i = solution6.nthUglyNumber(10);
        System.out.println(i);
    }
}


class Solution264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i = 1;i<n;i++){
            int num = Math.min(Math.min(dp[p2] *2,dp[p3] *3),dp[p5] *5);
            dp[i] = num;
            if(num == dp[p2] * 2){
                p2++;
            }
            if(num == dp[p3] * 3){
                p3++;
            }
            if(num == dp[p5] * 5){
                p5++;
            }

        }
        return dp[n-1];
    }
}