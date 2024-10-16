import java.util.Arrays;
/*
我靠我靠我靠，我无敌
分析：
1.题目的要求是找出一个最小长度的数组，把这个子数组排序后，整个数组就是有序的了。
2.所以说，这个子数组左边的，我们叫做小数组，右边的叫做大数组，小数组和大数组都是有序的。
3.所以，子数组里面其实是没有顺序的，而这道题让我们找的是范围。
思路：
1.从头开始向后遍历，找到第一个小于前面的值的位置（也就是找到了小数组的范围）
2.从末尾开始向前遍历，找到第一个大于后面的值的位置（也就是大数组的范围）
3.现在，我们找到了从头升序的数组，和从尾部降序的数组，中间的子数组其实就是没有顺序的数组了。
4.但是现在有个问题，在子数组中，可能存在着比小数组最后一个值更小的数，举例： 12345 345406 56789
这时候12345 是小数组  56789 是大数组，中间的无序数组。
但是无序数组里面有0，如果这时候武断的返回无序数组的两个端点，那么就错了。
5.所以，遍历无序数组，找到最小值与最大值。并且在小数组中找到这个最小值的位置，在大数组中找到这个最大值的位置，这两个位置就是我们的结果


注意点：
1.数组长度为0和1 的情况下，返回-1-1
2.当start >= end的情况下，说明原数组有序了，不用再排序，返回-1-1
 */
public class leetcode_面试题16部分排序 {
    public static void main(String[] args) {
        SolutionM_1 solution2 = new SolutionM_1();
        int[] ints = solution2.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        //int[] ints = solution2.subSort(new int[]{1,3,9,7,5});
        System.out.println(Arrays.toString(ints));
    }
}
class SolutionM_1 {
    public int[] subSort(int[] array) {
        if(array.length == 0 || array.length == 1){
            return new int[]{-1,-1};
        }
        int[] n = new int[2];
        int start = 0;
        int end = array.length-1;
        while (start < end && array[start+1] >= array[start]){
            ++start;
        }
        System.out.println(start);
        while (end >= 1 && array[end-1] <= array[end]){
            --end;
        }
        System.out.println(end);
        if(start >= end){
            return new int[]{-1,-1};
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MIN_VALUE;
        for(int i = start;i<=end;i++){
            small = Math.min(small,array[i]);
            big = Math.max(big,array[i]);
        }
        for(int i = 0;i<array.length;i++){
            if(array[i] > small){
                n[0] = i;
                break;
            }
        }
        for(int i = array.length-1;i>=0;i--){
            if(array[i] < big){
                n[1] = i;
                break;
            }
        }
        return n;
    }
}