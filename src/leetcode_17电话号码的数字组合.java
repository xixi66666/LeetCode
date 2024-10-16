import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_17电话号码的数字组合 {
    public static void main(String[] args) {
        Solution17 solution5 = new Solution17();
        List<String> list = solution5.letterCombinations(new String(""));
        System.out.println(list.toString());
    }
}

class Solution17{
    List<String> ans = new ArrayList<>();
    StringBuffer string = new StringBuffer();
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            ans.add(string.toString());
            return ans;
        }
        backtrack(digits,0);
        return ans;
    }


    public void backtrack(String digits,int index){
        if(index == digits.length()){
            ans.add(string.toString());
            return;
        }
        char digit = digits.charAt(index);
        String s = phoneMap.get(digit);
        int count = s.length();
        for(int i = 0;i<count;i++){
            string.append(s.charAt(i));
            backtrack(digits,index+1);
            string.deleteCharAt(index);
        }

    }
}