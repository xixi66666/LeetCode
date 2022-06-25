package 线性表;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int len = s.length();
        int[] number = new int[len];
        for(int i = 0;i<len;i++){
            number[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        for(int i = 1;i<n;i++){
            String s1 =scanner.nextLine();
            for(int j = 0;j<len;j++){
                number[j] = number[j]*10 +Integer.parseInt(String.valueOf(s1.charAt(j)));
            }
        }
        Arrays.sort(number);
        for(int i = 0;i<len;i++){
            System.out.print(number[i] + " ");
        }
    }
    public int getNumber (int[] a) {
        return 1;
    }
}

