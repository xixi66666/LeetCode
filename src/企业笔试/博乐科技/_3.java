package 企业笔试.博乐科技;

/**
 * @author YangChenxi
 */
public class _3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = solution3.CountNumber(20);
        System.out.println(s);
    }
}
class Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return string字符串
     */
    public String CountNumber (int n) {
        // write code here
        int[] ans = new int[10];
        for(int j = 1;j<=n;j++){
            int i = j;
            if(i < 10){
                ans[i]++;
            }else{
                while(i >= 10){
                        int num = i%10;
                        ans[num]++;
                        i /= 10;
                    }
                ans[i]++;
                }
            }
        String s1 = "";
        for(int i = 0;i < ans.length;i++){
            if(i == ans.length-1){
                s1 = s1 + ans[i];
            }else {
                s1 = s1 + ans[i] + " ";
            }

        }
        return s1;
    }
}