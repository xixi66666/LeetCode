package 企业笔试.京东;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _3小红的漂亮串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        if(n < 6){
            System.out.println(0);
        }else{
            int end2 = 5;
            for(int i = 5;i<=n-1;i++){
                int start2 = i -2;
                int end1 = 2;
                while (end1 <= start2-1){
                    ans++;
                    end1++;
                }
            }
            System.out.println(ans % (10E9 + 7));
        }

    }
}
