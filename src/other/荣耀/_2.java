package other.荣耀;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        for(int i = 0;i<loop;i++){
            int number = scanner.nextInt();
            if(number == 1){
                System.out.println(0 + " " + 0);
                break;
            }
            int[] score = new int[number];
            for(int k = 0;k<number;k++){
                score[k] = scanner.nextInt();
            }
            int max = 0;
            int ans = 0;
            for(int k = 1;k<number;k++){
                int index = score[k];
                for(int l = 0;l<k;l++){
                    if(index < score[l]){
                        ans--;
                    }
                    if(index > score[l]){
                        ans++;
                    }
                }
                max = Math.max(max,ans);
            }
            System.out.println(max + " " + ans);
        }
    }
}
