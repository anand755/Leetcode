package hacker.rank.algo;

import java.io.*;

public class FlippingBit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCount = Integer.parseInt(reader.readLine());

        while (testCount-- > 0) {
            long n = Long.parseLong(reader.readLine());

            long result = flippingBits(n);

            bufferedWriter.write(result + "\n");
            bufferedWriter.flush();
        }
    }

    static long flippingBits(long n) {
        long var = 0;
        long one = 1;
        long zero = 0;
        for (int i = 0; i < 32; i++) {
            /*if ((((n >> i)) & one) == one) {
                var = var & (zero << i);
            } else {
                var = var ^ (one << i);
            }*/
            if (((n >> i) & one) == zero) {
                var = var ^ (one << i);
            }
        }
        return var;
    }
}
