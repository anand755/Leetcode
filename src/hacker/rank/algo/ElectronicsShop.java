package hacker.rank.algo;

import java.io.*;
import java.util.Arrays;

public class ElectronicsShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] bnm = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int budget = bnm[0];
            int[] keyBoardArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int[] driveArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int maxPrice = getMaxPrice(budget, keyBoardArr, driveArr);
            writer.write(maxPrice + "\n");
            writer.flush();
        }
    }

    private static int getMaxPrice(int budget, int[] keyBoardArr, int[] driveArr) {

        int maxPrice = -1;

        for (int kb : keyBoardArr) {
            for (int dr : driveArr) {
                if (kb + dr <= budget) {
                    maxPrice = Math.max(maxPrice, kb + dr);
                }
            }
        }
        return maxPrice;
    }
}
