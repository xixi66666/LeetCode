package 排序递归贪心;

public class leetcode_860柠檬水找零 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        boolean b = solution6.lemonadeChange(new int[]{5, 5, 10, 10, 20});
        System.out.println(b);
    }
}

class Solution6 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for(int i : bills){
            if(i == 5){
                five++;
            }else if (i == 10){
                if(five >= 1){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(five >= 1 && ten >= 1){
                    five--;
                    ten--;
                }else if (five >= 3){
                    five = five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
