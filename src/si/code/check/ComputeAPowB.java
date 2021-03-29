package si.code.check;

import java.io.*;
import java.util.Arrays;

public class ComputeAPowB {
    public static int M = (int) 1e9 + 7;

    private static int apowerb(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            if (b % 2 == 0) {
                long x = (long) ((apowerb(a, b / 2)) % M);
                return (int) ((x * x) % M);
            } else {
                long x = (long) ((apowerb(a, b / 2)) % M);
                return (int) ((a * ((x * x) % M)) % M);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCount = Integer.parseInt(reader.readLine().trim());
        while (testCount-- > 0) {
            int[] ab = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int a = ab[0];
            int b = ab[1];
            writer.write(apowerb(a, b) + "\n");
            writer.flush();
        }
    }
}
