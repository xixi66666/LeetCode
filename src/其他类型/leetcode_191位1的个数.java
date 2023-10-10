package 其他类型;

/**
 * @program: LeetCode
 * @description:
 * @author: 杨晨曦
 * @create: 2023-02-01 18:30
 **/
public class leetcode_191位1的个数 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(5 << 2);
        System.out.println(solution20.hammingWeight(
                00000000000000000000000000001011));
    }

}

class Solution20 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}