package 企业笔试.webank;

import java.util.*;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int n = scanner.nextInt();
            list.add(n);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        String ans = "";
        for(int i = 0;i<number-2;i++){
            for(int j = i+1;j<number-1;j++){
                for(int k = j+1;k<number;k++){
                    String s = "";
                    s += list.get(i);
                    s += list.get(j);
                    s += list.get(k);
                    if(s.compareTo(ans) > 0 || s.length()>= ans.length());
                    ans = s;
                }
            }
        }
        System.out.println(ans);
    }
}
