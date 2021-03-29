package leetcode.aug.challange;

import java.io.*;
import java.util.Arrays;

public class D17DistributeCandiesToPeople {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] candyPeopleArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int candies = candyPeopleArr[0];
            int peoples = candyPeopleArr[1];
            int[] distributionArr = distributeCandies(candies, peoples);
            Arrays.stream(distributionArr).forEach(i -> {
                try {
                    writer.write(i + " ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.write("\n");
            writer.flush();
        }
    }

    private static int[] distributeCandies(int candies, int peoples) {

        int n = (int) ((2 * Math.sqrt(2 * candies + 1)) - 1) / 2;
        int cycle = n / peoples;
        int ft = (int) (((long) cycle * (2 + (cycle - 1) * (long) peoples)) / 2);

        int[] resArr = new int[peoples];
        resArr[0] = ft;
        int total = ft;

        for (int i = 1; i < peoples; i++) {
            resArr[i] = resArr[i - 1] + cycle;
            total += resArr[i];
        }

        if (total < candies) {
            int d = 1;
            for (int i = 0; i < peoples; i++) {
                resArr[i] += Math.min((peoples * cycle + d), (candies - total));
                total += Math.min((peoples * cycle + d), (candies - total));
                d++;
            }
        }

        return resArr;
    }
}
