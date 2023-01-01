package 企业笔试.OPPO;

import java.util.Arrays;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        SolutionOppOO1  s= new SolutionOppOO1 ();
        int i = s.maxDigit(new int[] {3,4});
        System.out.println(i);

    }
}
class SolutionOppOO1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param digits int整型一维数组
     * @return int整型
     */
    public int maxDigit(int[] digits) {
        // write code here
        Arrays.sort(digits);
        int ans = 0;
        for(int i = digits.length-1;i>=0;i--){
            ans = (10*ans + digits[i]);
        }
        return ans;
    }
}