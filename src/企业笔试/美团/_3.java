package 企业笔试.美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] a = new int[line];
        int[] b = new int[line];
        for(int i = 0;i<line;i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0;i<line;i++){
            b[i] = scanner.nextInt();
        }
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0;i<line;i++){
            map1.put(a[i],map1.getOrDefault(a[i],0)+1);
            if(map1.get(a[i]) >= Math.round(line/2)){
                System.out.println(0);
                break;
            }
            map2.put(b[i],map1.getOrDefault(b[i],0)+1);
            if(map2.get(b[i]) >= Math.round(line/2)){
                System.out.println(0);
                break;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<line;i++){
            if(!map2.containsKey(a[i])){
                continue;
            }
            if(map1.get(a[i]) + map2.get(a[i]) < Math.round(line/2)){
                continue;
            }
            else{
                int count = map1.get(a[i]) + map2.get(a[i]);
                for(int j = i;j<line;j++){
                    if(a[j] != a[i] && b[j] == a[i]){
                        count++;
                        if(count == line/2){
                            ans = Math.min(ans,line/2 - (map1.get(a[i]) + map2.get(a[i])));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
