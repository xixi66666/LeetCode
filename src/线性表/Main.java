package 线性表;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 1 || n == 0){
            System.out.println(n);
        }
        int[] dp = new int[n+1];
        for(int i = 0;i<dp.length;i++){
            dp[i] = i;
        }
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=n;i++){
            for(int j = 2;j<i;j++){
                if(i % j == 0){
                    if(i / j == 1){
                        dp[i] = i;
                    }else{
                        dp[i] = Math.min(dp[i],dp[i/j] + dp[j]);
                    }
                }
            }
        }
        System.out.println(dp[n]);
    }
}

