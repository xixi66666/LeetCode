package 线性表;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class tes1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //字符串s记录文章
        StringBuilder s = new StringBuilder();
        while(scanner.hasNextLine()){
            s.append(scanner.nextLine());
            //防止两行之间读入的时候没有分割
            s.append(" ");
        }
        HashMap<String, Integer> hm1 = countString(s.toString());
        //遍历hashmap
        int ans = 0;
        String word = "";
        for (Map.Entry<String, Integer> entry : hm1.entrySet()) {
            //计算权重值： 单词长度 * 出现次数
            int weight = entry.getKey().length() * entry.getValue();
            if(weight > ans){
                word = entry.getKey();
                ans = weight;
            }
        }
        System.out.println(word + " " + hm1.get(word));
    }

    public static HashMap countString(String s) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        //进行字符串的分割
        String s1 = s.replace(",", " ").replace(".", " ").replace("'", " ");
        //将字符串以数组的形式存储
        String[] s2 = s1.split(" ");
        //遍历字符串，记录出现个数
        for(int i = 0; i < s2.length; i++) {
            if (!hm.containsKey(s2[i])) {
                hm.put(s2[i], 1);
            } else if (hm.containsKey(s2[i])) {
                int v = hm.get(s2[i]);
                hm.put(s2[i], v + 1);
            }
        }
        return hm;
    }

}
