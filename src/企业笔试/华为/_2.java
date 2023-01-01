package 企业笔试.华为;


import java.util.*;


/**
 * @author YangChenxi
 */
public class _2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(strings));
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        String[][] zuowei = new String[m][n];
        for(int i = 0;i<m;i++){
            zuowei[i] = scanner.nextLine().split(" ");
            System.out.println(Arrays.toString(zuowei[i]));
        }
        List<String> mijie1 = new ArrayList<>();
        List<String> mijie2 = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(zuowei[i][j])) {
                    if (i > 0 && i < m - 1) {
                        //对角线的情况
                        if(j-1 >= 0){
                            if(!set.contains(zuowei[i-1][j-1])){
                                mijie1.add(zuowei[i-1][j-1]);
                            }
                            if(!set.contains(zuowei[i+1][j-1])){
                                mijie1.add(zuowei[i+1][j-1]);
                            }
                        }
                        if(j+1 <= n-1){
                            if(!set.contains(zuowei[i-1][j+1])){
                                mijie1.add(zuowei[i-1][j+1]);
                            }
                            if(!set.contains(zuowei[i+1][j+1])){
                                mijie1.add(zuowei[i+1][j+1]);
                            }
                        }
                        if (!set.contains(zuowei[i - 1][j])) {
                            mijie1.add(zuowei[i - 1][j]);
                        }
                        if (!set.contains(zuowei[i + 1][j])) {
                            mijie1.add(zuowei[i + 1][j]);
                        }
                    } else if (i == 0) {
                        if (!set.contains(zuowei[i + 1][j])) {
                            mijie1.add(zuowei[i + 1][j]);
                        }
                    } else if (i == m - 1) {
                        if (!set.contains(zuowei[i - 1][j])) {
                            mijie1.add(zuowei[i - 1][j]);
                        }
                    }
                    //判断列
                    if (j > 0 && j < n - 1) {
                        if (!set.contains(zuowei[i][j - 1])) {
                            mijie1.add(zuowei[i][j - 1]);
                        }

                        if (!set.contains(zuowei[i][j + 1])) {
                            mijie1.add(zuowei[i][j + 1]);
                        }

                    } else if (j == 0) {
                        if (!set.contains(zuowei[i][j + 1])) {
                            mijie1.add(zuowei[i][j + 1]);
                        }
                    } else if (i == m - 1) {
                        if (!set.contains(zuowei[i][j - 1])) {
                            mijie1.add(zuowei[i][j - 1]);
                        }
                    }

                }
            }
        }
            Set<String> set1 = new TreeSet<>();
            set1.addAll(mijie1);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (set1.contains(zuowei[i][j])) {
                        //判断位置的合法性
                        //判断行
                        if (i > 0 && i < m - 1) {
                            //对角线的情况
                            if(j-1 >= 0){
                                if(!set1.contains(zuowei[i-1][j-1])){
                                    mijie2.add(zuowei[i-1][j-1]);
                                }
                                if(!set1.contains(zuowei[i+1][j-1])){
                                    mijie2.add(zuowei[i+1][j-1]);
                                }
                            }
                            if(j+1 <= n-1){
                                if(!set1.contains(zuowei[i-1][j+1])){
                                    mijie2.add(zuowei[i-1][j+1]);
                                }
                                if(!set1.contains(zuowei[i+1][j+1])){
                                    mijie2.add(zuowei[i+1][j+1]);
                                }
                            }
                            if (!set1.contains(zuowei[i - 1][j])) {
                                mijie2.add(zuowei[i - 1][j]);
                            }
                            if (!set1.contains(zuowei[i + 1][j])) {
                                mijie2.add(zuowei[i + 1][j]);
                            }
                        } else if (i == 0) {
                            if(j-1 >= 0){
                                if(!set1.contains(zuowei[i+1][j-1])){
                                    mijie2.add(zuowei[i+1][j-1]);
                                }
                            }
                            if(j+1 <= n-1){
                                if(!set1.contains(zuowei[i+1][j+1])){
                                    mijie2.add(zuowei[i+1][j+1]);
                                }
                            }
                            if (!set1.contains(zuowei[i + 1][j])) {
                                mijie2.add(zuowei[i + 1][j]);
                            }
                        } else if (i == m - 1) {
                            if (!set1.contains(zuowei[i - 1][j])) {
                                mijie2.add(zuowei[i - 1][j]);
                            }
                        }
                        //判断列
                        if (j > 0 && j < n - 1) {
                            if (!set1.contains(zuowei[i][j - 1])) {
                                mijie2.add(zuowei[i][j - 1]);
                            }

                            if (!set1.contains(zuowei[i][j + 1])) {
                                mijie2.add(zuowei[i][j + 1]);
                            }

                        } else if (j == 0) {
                            if (!set1.contains(zuowei[i][j + 1])) {
                                mijie2.add(zuowei[i][j + 1]);
                            }

                        } else if (i == m - 1) {
                            if (!set1.contains(zuowei[i][j - 1])) {
                                mijie2.add(zuowei[i][j - 1]);
                            }
                        }
                    }
                }
            }
            Collections.sort(mijie1);
            Set<String> set2 = new TreeSet<>(mijie2);
            for(String s : set1){
                System.out.print(s + " ");
            }
            for(String s : set2){
                if(!set.contains(s) && !set1.contains(s))
                System.out.print(s + " ");
            }

    }
}
