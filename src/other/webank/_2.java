package other.webank;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        for(int i = 0;i<loop;i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            if (n1 < n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            int ans = 0;
            int res = n1 / n2;
            if(res % 2 != 0){
                System.out.println(-1);
            }else{
                while (res != 1){
                    if(res / 8 >= 1){
                        res /= 8;
                        ans++;
                        continue;
                    }
                    if(res / 4 >= 1){
                        res /= 4;
                        ans++;
                        continue;
                    }
                    if(res / 2 >= 1){
                        res /= 2;
                        ans++;
                        continue;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
