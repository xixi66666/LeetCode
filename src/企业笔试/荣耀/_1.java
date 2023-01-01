package 企业笔试.荣耀;

import java.util.*;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] before = scanner.nextLine().split(",");
        String[] after = scanner.nextLine().split(",");
        int money = scanner.nextInt();
        for(int i = 0;i<before.length;i++){
            if(money >= Integer.parseInt(before[i]) && Integer.parseInt(before[i]) < Integer.parseInt(after[i])){
                money += (Integer.parseInt(after[i]) - Integer.parseInt(before[i]));
            }
        }
        System.out.println(money);


    }
}
