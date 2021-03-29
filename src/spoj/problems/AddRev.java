package spoj.problems;

import java.io.*;
import java.util.Arrays;

public class AddRev {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] nums = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int num1 = nums[0];
            int num2 = nums[1];
            int outAns = revNum(revNum(num1) + revNum(num2));
            writer.write(outAns + "\n");
        }
        writer.flush();
    }

    private static int revNum(int num) {
        int revNum = 0;
        while (num != 0) {
            int r = num % 10;
            revNum = revNum * 10 + r;
            num = num / 10;
        }
        return revNum;
    }
}
