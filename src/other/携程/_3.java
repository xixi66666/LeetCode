package other.携程;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = scanner.nextInt();
        scanner.nextLine();
        String[] color = scanner.nextLine().split("");
        String arr = "";
        for(int i = 0;i<loop-1;i++){
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            arr += color[n1-1];
            if(i == loop-2){
                arr += color[n2-1];
            }
        }
        System.out.println(arr);
        int[] dpred = new int[loop];
        int[] dpgreen = new int[loop];
        int[] dpblue = new int[loop];
        for(int i = 0;i<loop;i++){
            if(arr.charAt(i) == 'r'){
                if(i >= 1){
                    dpred[i] = dpred[i-1] + 1;
                    dpblue[i] = dpblue[i-1];
                    dpgreen[i] = dpgreen[i-1];
                }else {
                    dpred[i] = 1;
                }
            }
            if(arr.charAt(i) == 'g'){
                if(i >= 1){
                    dpgreen[i] = dpgreen[i-1] + 1;
                    dpblue[i] = dpblue[i-1];
                    dpred[i] = dpred[i-1];
                }else {
                    dpgreen[i] = 1;
                }
            }
            if(arr.charAt(i) == 'b'){
                if(i >= 1){
                    dpblue[i] = dpblue[i-1] + 1;
                    dpred[i] = dpred[i-1];
                    dpgreen[i] = dpgreen[i-1];
                }else {
                    dpblue[i] = 1;
                }
            }
        }
        int min = Math.min(dpblue[loop-1],Math.min(dpgreen[loop-1],dpred[loop-1]));

        if(min <= 1){
            System.out.println(0);
        }else{
            int count = 0;
            int ans = 1;
            while(count < loop){
                if(dpblue[count] == ans && dpgreen[count] == ans && dpred[count] == ans && loop-count>=3){
                    //System.out.println(ans + "------" + count);
                    ans++;
                }
                count++;
            }
            System.out.println(ans-1);
        }

    }
}
