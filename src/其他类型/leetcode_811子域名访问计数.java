package 其他类型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YangChenxi
 * 哈希表 + 字符串定位
 */
public class leetcode_811子域名访问计数 {
    public static void main(String[] args) {
        //“.”和“|”都是转义字符，必须得加"\\";
        Solution15 solution15 = new Solution15();
        List<String> list = solution15.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(list.toString());
    }
}
class Solution15 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String cpdomain : cpdomains){
            int space = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0,space));
            String domain = cpdomain.substring(space+1);
            hashMap.put(domain,hashMap.getOrDefault(domain,0) + count);
            for(int i = 0;i<domain.length();i++){
                if(domain.charAt(i) == '.'){
                    String s = domain.substring(i+1);
                    hashMap.put(s,hashMap.getOrDefault(s,0)+ count);
                }
            }
        }
        for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
            String s = entry.getKey();
            int number = entry.getValue();
            ans.add(number + " " + s);
        }
        return ans;
    }
}