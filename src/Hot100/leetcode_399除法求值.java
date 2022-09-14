package Hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YangChenxi
 */
public class leetcode_399除法求值 {
    public static void main(String[] args) {

    }
}
class Solution24 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Double> map = new HashMap<>();
        int len = equations.size();
        for(int i = 0;i<len;i++){
            if(!map.containsKey(equations.get(i).get(0)) && !map.containsKey(equations.get(i).get(1))){
                map.put(equations.get(i).get(1),1.0);
                double val = values[i];
                map.put(equations.get(i).get(0),val * 1.0);
            }else if(map.containsKey(equations.get(i).get(1)) && map.containsKey(equations.get(i).get(0))){
                if(map.get(equations.get(i).get(0)) != 1.0 && map.get(equations.get(i).get(1)) == 1.0){
                    double val = values[i];
                    val = map.get(equations.get(i).get(0)) / val;
                    map.put(equations.get(i).get(1),val);
                }
                if(map.get(equations.get(i).get(0)) == 1.0 && map.get(equations.get(i).get(1)) != 1.0){
                    double val = values[i];
                    val = map.get(equations.get(i).get(1)) * val;
                    map.put(equations.get(i).get(0),val);
                }
            } else if(map.containsKey(equations.get(i).get(0)) && !map.containsKey(equations.get(i).get(1))){
                double val = values[i];
                val = map.get(equations.get(i).get(0)) / val;
                map.put(equations.get(i).get(1),val);
            } else if(!map.containsKey(equations.get(i).get(0)) && map.containsKey(equations.get(i).get(1))){
                double val = values[i];
                val = map.get(equations.get(i).get(1)) * val;
                map.put(equations.get(i).get(0),val);
            }
        }
        double[] ans = new double[queries.size()];
        for(int i = 0;i<queries.size();i++){
            if(map.containsKey(queries.get(i).get(0)) && map.containsKey(queries.get(i).get(1))){
                ans[i] = map.get(queries.get(i).get(0)) / map.get(queries.get(i).get(1));
            }else{
                ans[i] = -1.00000;
            }
        }
        for(int i = 0;i<map.size();i++){
            System.out.println(map.get(i));
        }
        return ans;
    }
}