import java.util.HashSet;
import java.util.Set;

/**
 * @author YangChenxi
 * @CreateTime 2024-10-17
 */
public class leetcode_1647字符频次唯一的最小删除次数 {
    public static void main(String[] args) {
        Solution1647 solution1647 = new Solution1647();
        System.out.println(solution1647.minDeletions("aaabbbcc"));
    }

}



class Solution1647 {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        int ans = 0;
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            arr[charArr[i] - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            while (number > 0){
                if(set.contains(number)){
                    ans++;
                    number--;
                }else {
                    set.add(number);
                    break;
                }
            }

        }
        return ans;
    }
}