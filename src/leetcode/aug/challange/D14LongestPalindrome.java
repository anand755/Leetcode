package leetcode.aug.challange;

import java.io.*;

public class D14LongestPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {
            String inputStr = reader.readLine().trim();
            int maxPalinLength = getMaxPalinLength(inputStr);
            writer.write(maxPalinLength + "\n");
            writer.flush();
        }
        //writer.flush();
    }

    private static int getMaxPalinLength(String inputStr) {

        int totalAns = 0;
        int[] countArr = new int[58];

        for (char ch : inputStr.toCharArray()) {
            countArr[ch - 'A']++;
        }

        boolean flag = false;
        for (int i = 0; i < 58; i++) {

            if (countArr[i] % 2 == 0) {
                totalAns += countArr[i];
            } else {

                totalAns += countArr[i] - 1;
                flag = true;
            }
        }

        if (flag) {
            totalAns++;
        }
        return totalAns;
    }
}
