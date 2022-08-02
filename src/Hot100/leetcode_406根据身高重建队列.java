package Hot100;

import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode_406根据身高重建队列 {
}
/*
思路：
第一个数表示身高，第二个数表示前面比他高的
考虑：身高低的对身高高的人的第二个数字其实不产生任何影响
思路：那我们就先进行排序，把身高高的放前面，身高一样则数字小的放前面。
从第一个开始，因为后面的值不会对前面的产生任何影响，所以当我们放入第i个人的时候，只需要将其插入队列当中，不会对队列中前i-1个人产生影响的
只要满足它在第二个参数表示的位置就可以了。
 */
class Solution23 {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        for(int[] person : people){
            System.out.println(Arrays.toString(person));
            //add 第一个参数是插入位置
            ans.add(person[1],person);

        }
        return ans.toArray(new int[ans.size()][]);
    }
}