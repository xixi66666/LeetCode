import java.util.Map;

/**
 * @author YangChenxi
 */
public class leetcode_221最大正方形 {
}
/*
这种题是得好好分析一下的，我做题的时候有几个问题
1.二维数组的越界问题，有时候可能超出范围。需要考虑边界条件：遍历整个数组的时候，这样就不产生越界的问题，因为表示的是右下角的位置
当i == 0 || j == 0 说明在第一行或者第一列，直接赋值对应的值就行
解决：使用动态规划数组dp[i][j]表示以 第i行 第j列 为右下角且只包含1的正方形的边长的最大值。
如果该位置是0的话，dp[i][j] = 0 因为当前位置不可能出现在全是1的正方形当中
如果该位置是1的话，dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
解释：dp值由其上方、左方和左上方的三个相邻位置的值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1
为什么是这样的？考虑一下：假设一个3×3的小正方形，i = j = 3表示正方形右下角的位置x
1  1  1
1  1  1
1  1  x
对应的dp数组为
1  1  1
1  2  2
1  2  3
为什么dp[i][j] = 3呢。因为只有其上方、左方和左上方的三个相邻位置的值都等于2的时候才说明整加上x整个正方形的变成才为3，如果其中一个2 变成了1 那么就不构成边长为3的正方形了，x的值为2
所以具体实现是当前位置的元素值等于三个相邻位置的元素中的最小值加 1
2.
 */
class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
                    }
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
}