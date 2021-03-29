package jc.test;

import java.io.*;
import java.util.Arrays;

public class ZishanOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] inputArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int output = getumberForEqualSum(inputArr);
            writer.write(output + "\n");
        }
        writer.flush();
    }

    private static int getumberForEqualSum(int[] inputArr) {
        int arrLength = inputArr.length;
        // Initializing if no proper ans found
        int outPut = -404;
        int[] prefixSumArr = new int[arrLength];
        int[] suffixSumArr = new int[arrLength];
        //Populating prefix sum array
        prefixSumArr[0] = inputArr[0];
        for (int i = 1; i < arrLength; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + inputArr[i];
        }

        //Populating suffix sum array
        suffixSumArr[arrLength - 1] = inputArr[arrLength - 1];
        for (int i = arrLength - 2; i >= 0; i--) {
            suffixSumArr[i] = suffixSumArr[i + 1] + inputArr[i];
        }

        for (int i = 0; i < arrLength; i++) {
            if (prefixSumArr[i] == suffixSumArr[i]) {
                outPut = inputArr[i];
                break;
            }
        }
        //In case Not found
        return outPut;
    }
}
