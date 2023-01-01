package 企业笔试.猿辅导;

import java.util.*;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        for(int i = 0;i<loop;i++){
            int number = scanner.nextInt();
            String[] strings = new String[number];
            for(int j = 0;j<number;j++) {
                String s = scanner.next();
            }
            int word = scanner.nextInt();
            Set<String> set = new HashSet<>();
            for(int j = 0;j<word;j++){
                set.add(scanner.next().toLowerCase());
            }
            Map<String,Integer> map = new HashMap<>();
            int ans = 0;
            for(String s : strings){
                s = s.toLowerCase();
                if(!set.contains(s)){
                    map.put(s,map.getOrDefault(s,0)+1);
                    ans = Math.max(ans,map.get(s));
                }

            }
            System.out.println(ans);
        }
    }
}
