package other.美团;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] a = new int[line];
        int[] b = new int[line];
        for(int i = 0;i<line;i++){
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        for(int i = 0;i<line;i++){
            int min = Math.min(a[i],b[i]);
            int max = Math.max(a[i],b[i]);
            if(max >= 2*min){
                System.out.println(min);
            }else{
                System.out.println((min + max)/3);
            }
        }
    }
}
