public class leetcode_4寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        double medianSortedArrays = solution4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        double[] big = new double[sum];
        int index1,index2,index3;
        index1 = index2 = index3 = 0;
        while (index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] < nums2[index2]){
                big[index3] = nums1[index1];
                index1++;
                index3++;
            }else{
                big[index3] = nums2[index2];
                index2++;
                index3++;
            }
        }
        while (index1 < nums1.length){
            big[index3] = nums1[index1];
            index1++;
            index3++;
        }
        while (index2 < nums2.length){
            big[index3] = nums2[index2];
            index2++;
            index3++;
        }
        if(sum%2 == 0){
            return (big[sum/2]+big[sum/2-1])/2;
        }else
            return big[sum/2];
    }
}