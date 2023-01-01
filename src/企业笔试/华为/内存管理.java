package 企业笔试.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class 内存管理 {
    public static void main(String[] args) {
        boolean[] memory = new boolean[4096];
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int len = scanner.nextInt();
            for (int j = start; j < start + len; j++) {
                memory[j] = true;
            }
        }
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            int n = scanner.nextInt();
            if (n < 0) {
                if (-n - 1 >= 0) {
                    memory[-n - 1] = false;
                }
                if (-n - 2 >= 0) {
                    memory[-n - 2] = false;
                }
                if( -n >= 0){
                    memory[-n] = false;
                }
                if (-n + 1 < 4096) {
                    memory[-n + 1] = false;
                }
            } else {
                if (n - 2 >= 0) {
                    memory[n - 2] = true;
                }
                if (n - 1 >= 0) {
                    memory[n - 1] = true;
                }
                if(n < 4096){
                    memory[n] = true;
                }
                if (n + 1 < 4096) {
                    memory[n + 1] = true;
                }
            }
        }
        List<Integer> index = new ArrayList<>();
        List<Integer> length = new ArrayList<>();
        boolean flag = false;
        for(int i = 0;i<4096;i++){
            if(memory[i]){
                //System.out.println("-----" + i);
            }
            if(memory[i] && !flag){
                index.add(i);
                flag = true;
            }
            if(!memory[i] && flag){
                length.add(i - index.get(index.size()-1));
                flag = false;
            }
        }
        System.out.println(index.toString());
        System.out.println(length.toString());
    }
}
