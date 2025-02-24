import java.util.HashMap;
import java.util.Map;

/*
* @Auther:xixixiaozi
* @Date:${DATE}
* @Description:${Description}
*/

/**
 * @Auther:xixixiaozi
 * @Date:2025/2/24
 * @Description:${Description}
 */
public class leetcode_12整数转罗马数字 {
}
class Solution12 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * @Description:  这个方法比较巧妙，主要是总结出来了规律：对于罗马数字从左到右的每一位，选择尽可能大的符号值。所以根据给定的num，我们去找不超过这个num的最大罗马数字，将num减去该值后循环
     *                罗马数字由 7 个不同的单字母符号组成，再根据减法规则又总结出来了额外的 6 个复合符号。
     * @Author:xixixiaozi
     * @date:2025/2/24 22:25
     * @param	num
     * @return:java.lang.String
    */
    public String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<values.length;i++){
            int value = values[i];
            if(num >= value){
                num -= value;
                stringBuffer.append(symbols[i]);
            }
            if(num == 0){
                break;
            }
        }
        return stringBuffer.toString();
    }


}