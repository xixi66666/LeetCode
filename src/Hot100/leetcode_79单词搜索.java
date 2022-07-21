package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangChenxi
 */
public class leetcode_79单词搜索 {
}
/*
思路：
1.回溯：设函数 check(i, j, k)示判断以网格的(i,j) 位置出发，能否搜索到单词 word[k。。]其中 word[k..]
表示字符串word 从第 k 个字符开始的后缀子串。如果能搜索到，则返回true，反之返回false。

2.同时需要建立一个和board相同大的数组，存储对应的元素有没有被访问过。我他妈终于明白了，checkLetter函数中
boolean b = checkLetter(board, word, newI, newJ, cur + 1, visit);
if(b){
    return true;
这里注意是dfs的思想：checkLetter一直在回溯调用，所以b不是一次的布尔值，而是最终多次的结果值
并且只要b不是true，那么visit[][]数组其实是都被设置为false了，之前的true也就被消除了，不是继续存在在数组中的。

3.怎么表示其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
使用一个二维数组{-1,0},{1,0},{0,-1},{0,1} 让ij加上他们表示新的坐标值

4.注意边界值的判断：(newI >=0 && newI < board.length && newJ >= 0 && newJ < board[0].length)
*/
class Solution11 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] visit = new boolean[row][column];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                boolean b = checkLetter(board, word, i, j, 0, visit);
                for(boolean[] n: visit){
                    System.out.println(Arrays.toString(n));
                }
                if(b){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean checkLetter(char[][] board,String word,int i, int j,int cur,boolean[][] visit){
        if(board[i][j] != word.charAt(cur)){
            return false;
        }
        if(cur == word.length()-1){
            return true;
        }
        visit[i][j] = true;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int a[] : directions){
            int newI = i + a[0];
            int newJ = j + a[1];
            if(newI >=0 && newI < board.length && newJ >= 0 && newJ < board[0].length){
                if(!visit[newI][newJ]){
                    boolean b = checkLetter(board, word, newI, newJ, cur + 1, visit);
                    if(b){
                        return true;
                    }
                }
            }
        }
        visit[i][j] = false;
        return false;
    }
}