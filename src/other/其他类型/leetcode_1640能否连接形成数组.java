package other.其他类型;

import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode_1640能否连接形成数组 {
}
class Solution14 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        //map 记录pieces的首数字以及位置
        Map<Integer,Integer> map = new HashMap<>();
       for(int j = 0;j<pieces.length;j++){
           map.put(pieces[j][0],j);
       }
        for(int i = 0;i<arr.length;){
            if(!map.containsKey(arr[i])){
                return false;
            }else{
                int k = pieces[map.get(arr[i])].length;
                for(int j = 0;j<k;j++){
                    if(arr[i+j] != pieces[map.get(arr[i])][j]){
                        return false;
                    }
                }
                i = i + k;
            }

        }
        return true;

    }
}