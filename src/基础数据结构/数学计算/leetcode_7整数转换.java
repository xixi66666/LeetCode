package 基础数据结构.数学计算;

/**
 * @author YangChenxi
 * @CreateTime 2025-02-10
 */
public class leetcode_7整数转换 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.reverseBetter(-2147483412));
    }
}

/**
 * 思路一：
 * 1.先找出这个x的长度是多少
 * 2.根据这个位数给每一个位置上的数字乘它对应的数字，也就是第一个数字乘1 第二个乘10 第三个乘100 则么实现：用Math.pow(10,i)
 * 3.用位运算来表示int的最大值太麻烦了，直接用Integer.MAX_VAULE 比较合适
 * 4.这个方法的问题就是时间空间复杂度都挺高
 *
 *
 * 思路二：
 * 很简单的数学计算 0.0
 * 1.因为x的值不会超过int的范围，所以超过范围的可能就只有在翻转的时候。
 * 2.那么怎么翻转呢？将原int对10进行取余，就能拿出来每一次的最后一位的数据。注意的点是每次也要对x进行变动 x = x/10
 * 3.只需要想到计算公式就行了：rev = rev * 10 + number(余数)
 * 4.这个方法的时间复杂度就是x的长度
 */
class Solution7{
    public int reverse(int x) {
        boolean flag = true;
        if(x < 0){
            x = -x;
            flag = false;
        }
        int sum = 0;
        int number = String.valueOf(x).length();
        String s = String.valueOf(x);
        for(int i =0; i<number;i++){
            //开始分解
            char c = s.charAt(i);
            int charToInteger = (int) c -48;
            //开始进行乘法运算
            int pow = (int) Math.pow(10, i) * charToInteger;
            if(i == 9 && charToInteger > 2){
                return 0;
            }
            if(i > 9){
                return 0;
            }
            System.out.println(pow + "---");

            if(Integer.MAX_VALUE - pow < sum){
                return 0;
            }
            sum += pow;
        }
        return flag?sum:-sum;
    }

    public int reverseBetter(int x){
        int rev = 0;
        while (x != 0){
            if(rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                return 0;
            }
            int number = x % 10;
            x /= 10;
            rev = rev * 10 + number;
        }
        return rev;
    }
}
