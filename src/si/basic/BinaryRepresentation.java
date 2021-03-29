package si.basic;

import java.util.Scanner;

public class BinaryRepresentation {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[] arr = {1, 2, 4, 8, 16, 32, 64, 128, 256};
        while (t >= 0) {
            int n = s.nextInt();
            int a = 0;
            int len = arr.length;
            int[] ans = new int[10];
            for (int i = len - 1; i > 0; i--) {
                if (arr[i] + a <= n) {
                    ans[len - 1 - i] = 1;
                    a = arr[i] + a;
                } else
                    ans[len - 1 - i] = 0;
            }
            int k = 0;
            for (int i = 0; i < len; i++) {
                if (ans[i] == 0) {
                    k = k + 1;
                    break;
                } else if (ans[i] == 1) {
                    for (int j = k; j < len; j++) {
                        System.out.print(ans[j]+"");
                    }
                }
            }
            t = t - 1;
            System.out.println("");

        }
    }
}
