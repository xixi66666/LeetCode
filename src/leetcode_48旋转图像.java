import java.util.Arrays;

/**
 * @author YangChenxi
 */
public class leetcode_48旋转图像 {
    public static void main(String[] args) {
        Solution48 solution7 = new Solution48();
        solution7.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
//对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。
class Solution48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] matrix_new = new int[len][len];
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                matrix_new[j][len-i-1] = matrix[i][j];
            }
        }
        for(int[] p : matrix_new){
            System.out.println(Arrays.toString(p));
        }
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}