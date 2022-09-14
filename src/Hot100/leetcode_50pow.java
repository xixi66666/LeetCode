package Hot100;

/**
 * @author YangChenxi
 */
public class leetcode_50pow {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        double v = solution10.myPow(2.0000, -3);
        System.out.println(v);
        System.out.println(Integer.MIN_VALUE);
    }
}
/*
难点就在于：
1.当n很大的时候会超时
2.pow的数学定义，不是x *= x而是需要一个值赋值为x的初始值，然后每次都×d

 */
class Solution10 {
    public double myPow(double x, int n) {
        // 特殊值判断： n == 0;x == 1.0||-1.0
        if(n == 0){
            return 1.0;
        }
        if(x == 1.0){
            return 1.0;
        }
        if(x == -1.0){
            if(n % 2 == 0){
                return 1.0;
            }else{
                return -1.0;
            }
        }
        if(n == -2147483648){
            return 0.0;
        }
        double d = x;
        if(n < 0){
            int num = -n;
            for(int i = 1;i<num;i++){
                x *= d;
            }
            x = 1/x;
        }else{
            for(int i = 1;i<n;i++){
                x *= d;
            }
        }
        return x;
    }
}