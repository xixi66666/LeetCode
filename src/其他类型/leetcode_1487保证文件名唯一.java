package 其他类型;

import java.util.HashMap;

/**
 * @author YangChenxi
 */
public class leetcode_1487保证文件名唯一 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        String[] folderNames = solution19.getFolderNames(new String[]{"d(2)(4)", "n", "y", "q(3)", "q(3)", "p(2)", "o", "k(4)", "x(1)", "m(1)", "a(2)", "z", "p(2)(3)", "d", "g", "t", "n", "z(3)", "a", "d(2)", "b", "t", "m", "r(1)(2)", "k", "c", "p(2)(1)", "c", "l(1)", "l", "b", "u", "o", "h(2)", "p(3)(3)", "d", "o", "c", "c", "v", "a", "g", "j", "m", "g(4)", "h", "b(2)", "r(3)", "e", "b(1)", "f(4)", "i", "m", "r", "m", "w(3)(4)", "p", "a", "g", "b", "s", "r", "b(1)", "f", "k", "q", "p"});
        for(String s : folderNames){
            System.out.println(s);
        }
    }
}
class Solution19 {
    public String[] getFolderNames(String[] names) {
        HashMap<String,Integer> map = new HashMap();
        String[] strings = new String[names.length];
        for(int i = 0;i<names.length;i++){
            int number = 0;
            if(!map.containsKey(names[i])){
                if(names[i].contains("(")){
                    number = names[i].charAt(names[i].length()-2) - 48;
                }
                map.put(names[i],number);
                strings[i] = names[i];
            }else {
                if(!names[i].contains("(")){
                    int n = map.get(names[i]);
                    String a = names[i] + "(" + (n+1) + ")";
                    while (map.containsKey(a)){
                        n = map.get(a);
                        a = names[i] + "(" + (n+1) + ")";
                    }
                    strings[i] = a;
                    map.put(a,n+1);
                }else{
                    int n = 1;
                    String a = names[i] + "(" + (n) + ")";
                    while (map.containsKey(a)){
                        n++;
                        a = names[i] + "(" + (n) + ")";
                    }
                    strings[i] = a;
                    map.put(a,n+1);
                }
            }
        }
        return strings;
    }
}