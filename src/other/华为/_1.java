package other.华为;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int size = scanner.nextInt();
            int len = scanner.nextInt();
            int[] score = new int[size];
            for(int i = 0;i<size;i++){
                score[i] = scanner.nextInt();
            }
            scanner.nextLine();
            for(int i = 0;i<len;i++){
                String[] c = scanner.nextLine().split(" ");
                if(c[0].equals("U")){
                    int index = Integer.parseInt(c[1]);
                    int number = Integer.parseInt(c[2]);
                    score[index-1] = number;
                }
                if(c[0].equals("Q")){
                    System.out.println("i ---> " + i);
                    int number1 = Integer.parseInt(c[1]);
                    int number2 = Integer.parseInt(c[2]);
                    if(number1 > number2){
                        int temp = number1;
                        number1 = number2;
                        number2 = temp;
                    }
                    int max = 0;
                    for(int j = number1-1;j<number2;j++){
                        max = Math.max(max,score[j]);
                    }
                    System.out.println(max);
                }
            }
        }
    }
}
