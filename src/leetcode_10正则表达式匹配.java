/**
 * @program: LeetCode
 * @description: 10
 * @author: 杨晨曦
 * @create: 2022-11-03 09:23
 **/
public class leetcode_10正则表达式匹配 {
    public static void main(String[] args) {

    }

}

class Solution10 {
    public boolean isMatch(String s, String p) {

    if(s.isEmpty()){
        return true;
    }
    String reversedS = new StringBuilder(s).reverse().toString();
    String reversedP = new StringBuilder(p).reverse().toString();
    int index = 0;
    int length = reversedP.length();
    char[] charArray= reversedS.toCharArray();
    for(int i = 0;i < reversedS.length();){
        // 问题1 肯定会出现 c.* 这种情况  但是从后往前的话 所有的字符都会匹配到 比如ab，但实际上是不能匹配的
        if(reversedP.charAt(index) == '*' && index + 1 <= length){
            index++;
            char now = reversedP.charAt(index);
            if(now == '.'){
                if(reversedS.charAt(reversedS.length()-1) == reversedP.charAt(reversedP.length()-1) || reversedP.charAt(reversedP.length()-1) == '.'){
                    return true;
                }
                while (charArray[i] != now){
                    i++;
                }
            }

        }


    }


        return false;

    }
}