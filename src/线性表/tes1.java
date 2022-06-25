package 线性表;

public class tes1 {
    public static void main(String[] args) {
        int a = getNumber(new int[]{1,2,3,4});
        System.out.println(a);
    }
    public static int getNumber (int[] a) {
        int number = a.length;
        while (number != 1) {
            a[0] = -11111;
            for (int i = 2; i <= number; i++) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        a[i-1] = -11111;
                    }
                }
            }
            int j = 0;
            for (int i = 0; i < number; i++) {
                if (a[i] != -11111) {
                    a[j] = a[i];
                    j++;
                }
            }
            number = j;
        }
        return a[number];
    }
}
