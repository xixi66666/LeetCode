package 企业笔试.携程;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int[] gap = new int[n];
        gap[0] = 0;
        for(int i = 0;i<n;i++){
            numbers[i] = scanner.nextInt();
            if(i >= 1){
                gap[i] = numbers[i] - numbers[i-1];
            }
        }
        int index = 0;
        for(int i = 0;i<gap.length;i++){
            if(gap[i] > gap[index]){
                index = i;
            }
        }
        if(index == 1){
            gap[1] = 0;
        }else{
            int n1 = numbers[index] - numbers[index-1];
            int n2 = numbers[index-1] - numbers[index-2];
            if(n1 > n2+1){
                System.out.println((n1 + n2) / 2);
            }else{
                System.out.println(gap[index]);
            }
        }

    }
}
