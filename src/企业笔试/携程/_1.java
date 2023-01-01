package 企业笔试.携程;

import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class _1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0;i<q;i++){
            String number = scanner.nextLine();
            if((number.charAt(number.length()-1) - '0') % 2 == 0){
                System.out.println(number);
                continue;
            }else {
                boolean flag = false;
                String s = String.valueOf(number);
                for(int j = 0;j<s.length();j++){
                    if((s.charAt(j) - '0') % 2 == 0 || s.charAt(j) == '0'){
                        char c = s.charAt(j);
                        String s1 = "";
                        s1 += s.substring(0,j);
                        s1 += s.substring(j+1);
                        s1 += c;
                        System.out.println(Integer.valueOf(s1));
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    System.out.println(-1);
                }
            }
        }
    }
}
