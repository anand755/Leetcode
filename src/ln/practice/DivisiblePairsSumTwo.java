package ln.practice;

import java.io.*;
import java.util.Arrays;

public class DivisiblePairsSumTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] nk = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        int k = nk[1];

        int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int count = getDivSumPairCount(arrInput, n, k);
        writer.write(count + "\n");
        writer.flush();

    }

    private static int getDivSumPairCount(int[] arrInput, int n, int k) {
        int count = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= (i - 1); j++) {
                if (isValidpair(arrInput[j], arrInput[i], k)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValidpair(int num1, int num2, int k) {
        return (((num1 + num2) % k) == 0);
    }
}