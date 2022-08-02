package Hot100;

import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode_207课程表 {
}
/*
思路：拓扑结构，这就像有向无环图一样，使用入度和出度来表示一个课程的前置课程和后置课程。
因为课程的表示刚好是数字，我们用数组的下标刚好表示了对应的前置课。并且使用一个数组n记录每一个课程的前置课程的数量。
然后就是广度遍历的经典环节：队列
1.遍历数组n，如果对应的值为0 ，则说明没有前置课程，可以放入
2.使用一个数字，表示能够上的课。
3.使用广度来遍历一下，最后看visit和总数量是不是一致的
 */
class Solution13 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //lists的下标表示的是对应的课程（前置课程），里面的值就是前置课程对应的后置课程
        List<List<Integer>> lists = new ArrayList<>();
        //n代表的是对应课程的对应前置课程数量
        int[] n = new int[numCourses];
        //因为后面要对lists使用get，所以要先初始化
        for(int i = 0;i<numCourses;i++){
            lists.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            lists.get(i[1]).add(i[0]);
            n[i[0]]++;
        }
        Queue<Integer> queue = new LinkedList();
        //谁的前置课程的数量是0，说明可以直接上
        for(int i = 0;i<numCourses;i++){
            if(n[i] == 0){
                queue.offer(i);
            }
        }
        //使用一个数visit表示能够上的课程的数量
        int visit = 0;
        while(!queue.isEmpty()){
            visit++;
            int a = queue.poll();
            for(int i : lists.get(a)){
                n[i]--;
                if(n[i] == 0){
                    queue.offer(i);
                }
            }
        }
        return visit == numCourses;
    }
}
