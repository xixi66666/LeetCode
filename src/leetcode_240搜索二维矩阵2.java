import java.util.ArrayList;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_240搜索二维矩阵2 {
    public static void main(String[] args) {
        Solution240 solution28 = new Solution240();
        boolean b = solution28.searchMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}, 19);
        System.out.println(b);
    }
}
class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length-1;
        List<Integer> line = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][left] <= target && matrix[i][right] >= target){
                line.add(i);
            }
        }
        for(int i = 0;i<matrix[0].length;i++){
            if(matrix[0][i] <= target && matrix[matrix.length-1][i] >= target){
                row.add(i);
            }
        }
        for(int i : line){
            for(int j : row){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}