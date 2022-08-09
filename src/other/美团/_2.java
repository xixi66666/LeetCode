package other.美团;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int[] num = new int[line];
        for(int i = 0;i<line;i++){
            num[i] = scanner.nextInt();
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<line;i++){
            int index = i;
            int left = 0;
            int right = line;
            int wrong = 0;
            while(left < index){
                if(num[left] >= 0){
                    wrong++;
                }
                left++;
            }
            while(index < right){
                if(num[index] <= 0){
                    wrong++;
                }
                index++;
            }
            ans = Math.min(ans,wrong);
        }
        int wrong = 0;
        for(int i = 0;i<line;i++){
            if(num[i] >= 0){
                wrong++;
            }
        }
        System.out.println(Math.min(wrong,ans));
    }
}
