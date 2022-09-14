package other.顺丰;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        for(int i = 1;i<=n;i++){
            int left = 1;
            int right = n;
            int mid = (left + right) /2;
            while(left <= right){
                if(mid == i){
                    ans++;
                    break;
                }else if(mid < i){
                    left = mid+1;
                    ans++;
                }else{
                    right = mid-1;
                    ans++;
                }
                mid = (left + right) /2;
            }
        }
        System.out.println(ans);
    }
}
