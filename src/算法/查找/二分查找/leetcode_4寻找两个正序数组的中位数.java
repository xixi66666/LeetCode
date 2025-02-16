package 算法.查找.二分查找;

public class leetcode_4寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        Solution4_归并 solution4 = new Solution4_归并();
        double medianSortedArrays = solution4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }
}

/*
1.最简单的办法就是归并排序，把两个数组的数据按照大小顺序排序，再找出中位数就行了。
2.但是题目要求的是O(log(m+n))的时间复杂度，归并的复杂度是O(m+n),不满足
3.由O(log(m+n))的时间复杂度要求，想到了二分查找
 */
class Solution4_归并 {

    /**
     * @Author xixixiaozi
     * @Description //TODO
     * @Date 19:08 2025/2/11
     * @Param [nums1, nums2]
     * @return double
     **/
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
class Solution4_二分查找 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
}