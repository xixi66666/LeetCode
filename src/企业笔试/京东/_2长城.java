package 企业笔试.京东;

import java.util.*;

/**
 * @author YangChenxi
 */
public class _2长城 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        int len = scanner.nextInt();
        int[] n = new int[len];
        int ans = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<len;i++){
            int k = scanner.nextInt();
            set.add(k);
            n[i] = k;
        }
        List<Integer> num = new ArrayList<>(set);
        for(int i : num){
            for(int j : num){
                int count = 0;
                if(i != j){
                    boolean flag = true;
                    for(int x : n){
                        if(flag){
                            if(x != i){
                                count++;
                            }
                            flag = false;
                        }else{
                            if(x != j){
                                count++;
                            }
                            flag = true;
                        }
                    }
                    ans = Math.min(ans,count);
                }

            }
        }
        System.out.println(ans);

    }
}
