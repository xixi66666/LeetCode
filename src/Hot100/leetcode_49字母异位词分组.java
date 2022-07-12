package Hot100;

import java.util.*;

/**
 * @author YangChenxi
 */
public class leetcode_49字母异位词分组 {
}
/*由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
这里的写法是很奇妙的，非常值得细看：
1.给字符串排序：先将字符串转化为字符数组，再使用Arrays.sort(chars);进行排序。
2.把字符数组再转成字符串得到了新的有序字符串：String s = new String(chars);
3.Map中存的键值对类型是String 和 List<String>> 为什么这样呢，因为最终的返回值是 List<List<String>>
    而每个相同的字符串对应了一个List。
4.getOrDefault() 方法 ：如果存在相应的key则返回其对应的value，否则返回给定的默认值。
这里默认值的value是new ArrayList<String>
5.如果map中有了相同的字符串，那么list里面添加的不能是排序后的，因为排序后的是用来判断是否相等的，不是添加的，添加的应该是遍历的时候的字符串，也就是没有排序过的。
6.给map把字符串和list都添加进去，再次说明每一个有着相同字符的字符串都有自己的list存储 ，比如 abc和bca有一个list  acn有自己的一个list。
 */
class Solution9 {
    Map<String,List<String>> map = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}