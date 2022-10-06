package other.其他类型;

/**
 * @author YangChenxi
 */
public class leetcode_1049最后一块石头的重量2 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        solution13.lastStoneWeightII(new int[1]);
    }



}
class Solution13{
    public int lastStoneWeightII(int[] stones) {
        int a = 3;
        int b = a++ + ++a;
        System.out.println(a);
        System.out.println(b);
        return b;
    }
}