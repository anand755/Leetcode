package leetcode.aug.challange;

import java.io.*;
import java.util.Arrays;

public class D16BestTimeToBuyAndSellStock {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] stockPrices = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int maxProfit = getMaxProfit(stockPrices);
            writer.write(maxProfit + "\n");
            writer.flush();
        }
    }

    private static int getMaxProfit(int[] stockPrices) {
        if (stockPrices.length == 0 || stockPrices.length == 1) {
            return 0;
        }
        int length = stockPrices.length;
        int[] profitArr = new int[length];
        int j = 0, i = 1;
        int top = stockPrices[0];

        while (i < length) {
            if (stockPrices[i] < top) {
                top = stockPrices[i];
            } else if (stockPrices[i] > top) {
                int maxValue = stockPrices[i];
                while (i < length && stockPrices[i] >= maxValue) {
                    maxValue = stockPrices[i];
                    i++;
                }
                profitArr[j++] = maxValue - top;
                if (i < length) {
                    top = stockPrices[i];
                }
            }
            i++;
        }


        Arrays.sort(profitArr);
        int totalProfit = profitArr[profitArr.length - 1];
        if (profitArr.length >= 2) {
            totalProfit += profitArr[profitArr.length - 2];
        }

        return totalProfit;
    }
}
