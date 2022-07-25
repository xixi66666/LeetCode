package Hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author YangChenxi
 */
public class leetcode_621任务调度器 {
}
/*
思路：桶排序
1.找到执行次数最多的那个任务，现在假设给每一个任务都分配一个桶。这时候注意，最后一个桶不一定会被填满的。
2.因为两个任务中间是有时长n的限制的，所以第一个到第n+1个之间都不能是相同的任务，又因为是最多的次数，所以其他的任务肯定可以被放进桶里。
3.如果出现其他任务太多，桶里放下了的情况：
此时考虑：当放不下的时候其实多的任务就超出了1~1+n这个范围了，也就是说所有任务其实都不需要等待了。时长就是tasks的长度
4.所以比较一下：
(maxNumber-1) * (n+1) + maxCount 即 桶的长度减去最后一个桶 * 一个桶最少的时间 + 最后一个桶 和 tasks的长度
5.看一下题解的图就会比较明白
 */
class Solution19{
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        //1.先找到最大的执行次数是多少次
        int maxNumber = 0;
        for(char c : tasks){
            int number = map.getOrDefault(c,0) +1;
            map.put(c,number);
            maxNumber = Math.max(maxNumber,number);
        }
        //2.再找到有多少个任务的数量是最大执行次数
        int maxCount = 0;
        Set<Map.Entry<Character,Integer>> entries = map.entrySet();
        for(Map.Entry<Character,Integer> e : entries){
            if(e.getValue() == maxNumber){
                maxCount++;
            }
        }
        return Math.max((maxNumber-1) * (n+1) + maxCount, tasks.length);
    }
}