package interview.bit.prblm;

import java.io.*;

public class CountTotalSetBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            int setBitCount = getTotalSetBitFrom1ToN(number);
            writer.write(setBitCount + "\n");
            writer.flush();
        }
    }

    private static int getTotalSetBitFrom1ToN(int number) {
        int M = (int) 1e9 + 7;
        if (number==0){
            return 0;
        }
        long p = getLargest2PowerLessN(number);
        long setBitCountUpto2PowP = p * (1 << p - 1);
        int msbCount = number - (1 << p) + 1;
        int remainingCount = getTotalSetBitFrom1ToN(number - (1 << p));
        return (int) ((setBitCountUpto2PowP + msbCount + remainingCount) % M);

    }

    private static long getLargest2PowerLessN(int number) {
        int x = 0;
        while ((1 << x) <= number) {
            x++;
        }
        return (long) x - 1;
    }
}
