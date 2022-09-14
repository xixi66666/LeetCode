package other.博乐科技;

/**
 * @author YangChenxi
 */
public class _2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.shell_sort(new int[]{5, 6, 1, 4}, new int[]{2, 1});
        System.out.println(i);
    }
}
class Solution2 {
    public int shell_sort (int[] numlist, int[] gaplist) {
        // write code here
        int len = numlist.length;
        int ans = 0;
        for(int i : gaplist){
            int group = len/i;
            if(group != len){
                for(int j = 0;j<group;j++){
                    for(int k = j;k<len-i;k+=i){
                        if(numlist[k] > numlist[k+i]){
                            int temp = numlist[k];
                            numlist[k] = numlist[k+i];
                            numlist[k+i] = temp;
                            ans++;
                        }
                    }
                }
            }else{
                for(int j = 0;j<len-1;j++){
                    if(numlist[j] > numlist[j+1]){
                        int temp = numlist[j];
                        numlist[j] = numlist[j+1];
                        numlist[j+1] = temp;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}