package 线性表;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int len = s.length();
        int[] number = new int[len];
        for(int i = 0;i<n;i++){
            number[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        int count = 0;
        int[] dp = new int[n];
        if(number[0] == 0){
            dp[0] = 1;
        }else{
            dp[0] = -1;
        }
        int a = dp[0];
        for(int i = 1;i<len;i++){
            if(number[i] == 0){
                dp[i] = dp[i-1]+ i+1;
            }else {
                dp[i] = Math.abs(dp[i-1] - i-1);
            }
            if(Math.min(a,dp[i]) == dp[i]){
                a = dp[i];
                count = i;
            }
        }
        System.out.println(count-1);

    }

}
