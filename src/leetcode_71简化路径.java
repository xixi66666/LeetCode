import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author YangChenxi
 *
 */
public class leetcode_71简化路径 {
    public static void main(String[] args) {
        Solution71 solution18 = new Solution71();
        System.out.println(solution18.simplifyPath("/home/"));
    }
}
class Solution71 {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String name : names){
            if("..".equals(name)){
                if(!stack.isEmpty()){
                    //因为进行了返回父级操作，弹出栈顶，表示切换到上级目录
                    stack.pollLast();
                }
            }else {
                if(!name.equals(".") && name.length() > 0){
                    stack.addLast(name);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        if(stack.isEmpty()){
            ans.append("/");
        }else {
            while (!stack.isEmpty()){
                ans.append("/");
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}
