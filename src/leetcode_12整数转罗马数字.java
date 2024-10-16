/**
 * @author YangChenxi
 */
public class leetcode_12整数转罗马数字 {
}
class Solution12 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
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