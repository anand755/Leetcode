package leetcode.jan21.challenge;

import java.io.*;
import java.util.Arrays;

public class D11MergeSortedArr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] mn = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int m = mn[0];
            int n = mn[1];
            int[] arrM = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int[] arrN = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            mergeSortedArr(arrM, m, arrN, n);

        }
    }

    private static void mergeSortedArr(int[] arrM, int m, int[] arrN, int n) {
        int p = m - 1;
        int q = n - 1;
        int k = m + n - 1;

        while (p >= 0 && q >= 0) {
            if (arrM[p] > arrN[q]) {
                arrM[k] = arrM[p];
                p--;
            } else {
                arrM[k] = arrN[q];
                q--;
            }
            k--;
        }

        while (q >= 0) {
            arrM[k--] = arrN[q--];
        }

        for (int i : arrM) {
            System.out.print(i + " ");
            System.out.println();
        }
    }
}
