package 企业笔试.荣耀;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int week = scanner.nextInt();
        int day = scanner.nextInt();
        int[] m = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int[] m2 = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        for(int i = 2000;i<=year-1;i++){

            if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
                sum += 366;
            }else {
                sum += 365;
            }
        }
        int index = sum % 7;
        sum = 0;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            for(int i = 0;i<month-1;i++){
                sum += m2[i];
            }
        }else {
            for(int i = 0;i<month-1;i++){
                sum += m[i];
            }
        }
        sum += (week-1) *2 + day;
        
        for(int i = 0;i<sum;i++){
            if((index + i ) % 7 == 1){

            }
        }




    }
}
