package 排序递归贪心;

/**
 * @author YangChenxi
 */
public class leetcode_134加油站 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int i = solution11.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(i);
    }

}
class Solution11 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0;i<gas.length;i++){
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if(totalCost > totalGas){
            return -1;
        }
        int cur = 0;
        int start = 0;
        for(int i = 0;i<gas.length;i++){
            cur = cur + gas[i] - cost[i];
            if(cur < 0){
                cur = 0;
                start = i + 1;
            }
        }
        return start;
    }
}