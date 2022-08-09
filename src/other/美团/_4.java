package other.美团;

import java.util.*;

/**
 * @author YangChenxi
 */
public class _4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int len = scanner.nextInt();
        int[] number = new int[size];
        int[] jilu = new int[len+1];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<size;i++){
            number[i] = scanner.nextInt();
            map.put(number[i],map.getOrDefault(number[i],0) + 1);

        }
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        for(int i = 0;i<size;i++){
            int n = number[i];
            jilu[n]++;
            int k = 0;
            if(map.get(n)%2 == 0){
                k = map.get(n)/2;
            }else{
                k = map.get(n)/2+1;
            }
            if(jilu[n] <= k){
                System.out.println(Math.round(map.get(n)/2));
                n1.add(i+1);
            }else{
                n2.add(i+1);
            }
        }
        for(int i : n1){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : n2){
            System.out.print(i + " ");
        }


    }
}
