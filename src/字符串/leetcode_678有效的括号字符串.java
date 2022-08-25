package 字符串;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YangChenxi
 */
public class leetcode_678有效的括号字符串 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        boolean b = solution4.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");

    }
}
class Solution4 {
    public boolean checkValidString(String s) {
        //实现两个栈，一个左括号的 一个星号的
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                left.push(i);
            }else if(s.charAt(i) == '*'){
                star.add(i);
            }else if(s.charAt(i) == ')'){
                if(!left.isEmpty()){
                    left.pop();
                }else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        System.out.println(left.toString());
        System.out.println(star.toString());
        while (!left.isEmpty() && !star.isEmpty()){
            int leftIndex = left.pop();
            int starIndex = star.pop();
            if(leftIndex > starIndex){
                return false;
            }
        }
        return left.isEmpty();

    }
}