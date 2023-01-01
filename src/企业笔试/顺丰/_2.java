package 企业笔试.顺丰;

import java.util.*;

/**
 * @author YangChenxi
 */
public class _2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Map<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0;i<number-1;i++){
            map.put(i+2,scanner.nextInt());
        }
        int[] score = new int[number];
        for(int i = 0;i<number;i++){
            score[i] = scanner.nextInt();
        }
        int ans = 0;
        Set<Integer> set = map.keySet();
        for(int i : set){
            int sc = score[i-1];
            int index = map.get(i);
            score[index - 1] -= sc;
            ans += Math.abs(sc);
        }
        ans += Math.abs(score[0]);
        System.out.println(ans);

    }
}
