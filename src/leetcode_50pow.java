/**
 * @author YangChenxi
 */
public class leetcode_50pow {
    public static void main(String[] args) {
        Solution50 solution10 = new Solution50();
        double v = solution10.myPow(2.0000, -3);
        System.out.println(v);
        System.out.println(Integer.MIN_VALUE);
    }
}
/*
难点就在于：
1.当n很大的时候会超时
2.pow的数学定义，不是x *= x而是需要一个值赋值为x的初始值，然后每次都×d


第二种算法：递归


 */
class Solution50 {
    public double myPow(double x, int n) {
        if(n >= 0){
            return fun1(x,n);
        }else
            return 1.0/fun1(x,n);
    }
    public double fun1(double x, int n){
        if(n == 0){
            return 1.0;
        }
        double y = fun1(x,n/2);
        return n % 2 == 0 ? y * y:y * y * x;
    }
}