import java.util.*;

/**
 * @author YangChenxi
 * @CreateTime 2025-06-11
 */
public class leetcode_20有效的括号 {
    public static void main(String[] args) {
        Solution_20 solution20 = new Solution_20();
        solution20.isValid("([])");
    }
}
/*
还是得多熟练一下栈和队列的api啊
 */
class Solution_20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
