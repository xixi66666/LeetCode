public class leetcode_74搜索二维矩阵 {
    public static void main(String[] args) {
        //初始化一个二维数组
        int[][] num = new int[][]{new int[]{1,3,5,7},new int[]{10,11,16,20},new int[]{23,30,34,60}};
        Solution74 solution1 = new Solution74();
        System.out.println(solution1.searchMatrix(num,13));
    }
}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int size = matrix.length-1;
        int len = matrix[0].length-1;
        int start = 0;
        int end = size;
        int mid1 = (start + end)/2;
        while (start <= end){
            if(matrix[mid1][0] == target){
                return true;
            }else if(matrix[mid1][0] > target){
                end = mid1-1;
            }else{
                start = mid1+1;
            }
            mid1 = (start + end)/2;
        }
        start = 0;
        end = len;
        int mid2 = (start + end)/2;
        while (start <= end){
            if(matrix[mid1][mid2] == target){
                return true;
            }else if(matrix[mid1][mid2] > target){
                end = mid2-1;
            }else{
                start = mid2+1;
            }
            mid2 = (start+end)/2;
        }
        return false;
    }
}
