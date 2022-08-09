package other.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _5 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] n = new int[len];
        for(int i = 0;i<len;i++){
            n[i] = scanner.nextInt();
        }
        StringBuffer s = new StringBuffer("MeiTuan");
        for(int i = 0;i<10;i++){
            stringBuffer = new StringBuffer(s).append(s.reverse()).append("wow");
            s = stringBuffer;
        }
        System.out.println(s.charAt(1));
        for(int i : n){
            System.out.println(s.charAt(i-1));
        }
    }
}
