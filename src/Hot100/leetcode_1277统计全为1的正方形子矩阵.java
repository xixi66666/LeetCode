package Hot100;

/**
 * @author YangChenxi
 */
public class leetcode_1277统计全为1的正方形子矩阵 {
}
/*
数组：
0  1  1  1
1  1  1  1
0  1  1  1
dp:
0  1  1  1
1  1  2  2
0  1  2  3
思路与221题思路相同
1.二维数组的越界问题，有时候可能超出范围。需要考虑边界条件：遍历整个数组的时候，
当i == 0 || j == 0 说明在第一行或者第一列，直接赋值对应的值就行
解决：使用动态规划数组dp[i][j]表示以 第i行 第j列 为右下角且只包含1的正方形的边长的最大值。这样就不产生越界的问题，因为表示的是右下角的位置
如果该位置是0的话，dp[i][j] = 0 因为当前位置不可能出现在全是1的正方形当中
如果该位置是1的话，dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) +1;
解释：dp值由其上方、左方和左上方的三个相邻位置的值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1

2.当一个位置为1的时候他就是一个正方形了，就纳入统计，现在就是要判断这个位置是不是能表示长度大于1的正方形。（即这个位置有几个正方形

3.怎么表示有几个正方形呢，dp数组存储的就是这个位置共有几个正方形
比如
1  1
1  1
这时候i = 2 j = 2 的位置的dp值就为2，表示长度为1和长度为2 的两个正方形。
 */
class Solution15 {
    public int countSquares(int[][] matrix) {
        int count = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) + 1;
                    }
                }
                count += dp[i][j];

            }
        }
        return count;
    }
}
