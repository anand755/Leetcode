package codechef;

import java.io.*;
import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] nums = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int output = getSecondLargestNum(nums);
            writer.write(output + "\n");
            writer.flush();
        }
    }

    private static int getSecondLargestNum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if ((a >= b & a <= c) || (a >= c && a <= b)) {
            ans = a;
        }
        if ((b >= c & b <= a) || (b >= a && b <= c)) {
            ans = b;
        }
        if ((c >= a & c <= b) || (c >= b && c <= a)) {
            ans = c;
        }
        return ans;
    }
}
