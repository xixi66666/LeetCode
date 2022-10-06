package other.其他类型;

import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode_851喧嚣和富有 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        solution9.loudAndRich(new int[1][1],new int[1]);
    }
}
class Solution9 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        //使用一个map来存储人和安静值的对应关系
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<quiet.length;i++){
            map.put(i,quiet[i]);
        }
        //使用list进行排序
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int[] n : richer){
            if(!set.contains(n[1])){
                set.add(n[1]);
                list.add(n[1]);
            }
            if(!set.contains(n[0])){
                set.add(n[0]);
                int index = list.indexOf(n[1]);
                list.add(index,n[0]);
            }
            if(set.contains(n[0]) && set.contains(n[1])){
                if(list.indexOf(n[0]) > list.indexOf(n[1])){
                    int index0 = n[0];
                    int index1 = n[1];
                    list.remove(index0);
                    list.add(index0,n[1]);
                    list.remove(index1);
                    list.add(index1,n[0]);
                }
            }


        }
        return new int[0];
    }
}