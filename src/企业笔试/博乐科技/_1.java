package 企业笔试.博乐科技;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {

    }
}
class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 划船次数
     * @param x float浮点型 每次前进距离
     * @param y float浮点型 每次休息倒退距离
     * @param m float浮点型 距离岸边距离
     * @return int整型
     */
    public int rowTheBoat (float x, float y, float m) {
        // write code here

        if(x > m){
            return 1;
        }
        int ans = 0;
        int len = 0;
        while(len < m){
            len += x;
            ans++;
            if(len > m){
                return ans;
            }
            x *= 0.8;
            if(x <= y){
                return -1;
            }
            len -= y;
        }
        return ans;
    }
}