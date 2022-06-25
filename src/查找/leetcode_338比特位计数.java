package 查找;

public class leetcode_338比特位计数 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.countBits(2));

    }

}
class Solution5 {
    public int[] countBits(int n) {
        int[] num = new int[n+1];
        for(int i = 0;i<n+1;i++){
            String bin = Integer.toBinaryString(i);
            //System.out.println(bin);
            int len = bin.length();
            int count = 0;
            while(len >= 1){
                if(bin.charAt(len-1) == '1'){
                    count++;
                    len--;
                }else{
                    len--;
                }
            }
            num[i] = count;
            System.out.println(count);
        }
        return num;
    }
}