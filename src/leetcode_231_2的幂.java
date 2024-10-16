public class leetcode_231_2的幂 {
    public static void main(String[] args) {
        System.out.println(1 << 2);
    }
}
class Solution231 {
    public boolean isPowerOfTwo(int n) {
        for(int i = 0;i<=31;i++){
            if( 1 << i == n){
                return true;
            }
            if( 1 << i > n){
                return false;
            }
        }
        return false;

    }
}