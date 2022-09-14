package other.京东;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _1字符串大小写转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        s = s.toUpperCase();
        for(int i = 0;i<n;i++){
            System.out.print(s.charAt(i));
        }
        s = s.toLowerCase();
        for(int i = n;i<s.length();i++){
            System.out.print(s.charAt(i));
        }
    }
}
