package ln.practice;

import java.io.*;
import java.util.Arrays;

public class BitwiseAnd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {
            int[] nk = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int n = nk[0];
            int k = nk[1];
            int max = getmaxBitWiseAnd(n, k);
            writer.write(max + "\n");
            writer.flush();
        }
    }

    private static int getmaxBitWiseAnd(int n, int k) {
        int max = Integer.MIN_VALUE;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= (i - 1); j++) {
                int currAnd = i & j;
                if (currAnd < k) {
                    max = Math.max(max, currAnd);
                }
            }
        }
        return max;
    }
}
