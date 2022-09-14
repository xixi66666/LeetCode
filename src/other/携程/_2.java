package other.携程;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        for(int i = 0;i<loop;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int ans = 0;
            int min = Math.min(Math.min(a,b),c);
            ans = min * 2;
            b -= min;
            if(b >= 2){
                ans += b-1;
            }
            System.out.println(ans);
        }
    }
}
