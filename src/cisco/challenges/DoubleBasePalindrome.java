package cisco.challenges;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DoubleBasePalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int maxVal = Integer.parseInt(reader.readLine());
            int wordCount = getSumOfDoubleBasePalindromes(maxVal);
            writer.write(wordCount + "\n");
            writer.flush();
        }
        */
        getSumOfDoubleBasePalindromes(Integer.MAX_VALUE - 1);

    }

    private static int getSumOfDoubleBasePalindromes(int maxVal) {

        int total = 0;
        List<Integer> palinList = new ArrayList<Integer>();

        for (int i = 1; i <= maxVal; i++) {
            if (isPalindrome(i)) {
                palinList.add(i);
            }
        }
        for (int num : palinList) {
            total += num;
        }
        return total;
    }

    private static boolean isPalindrome(int num) {
        String bStr = "";
        for (int i = 0; i < 31; i++) {

            if ((isSetBit(num, i))) {
                bStr = "1" + bStr;
            } else {
                bStr = "0" + bStr;
            }
        }

        while (bStr.length() > 0 && bStr.charAt(0) == '0') {
            bStr = bStr.substring(1);
        }
        String backStr = new StringBuilder(bStr).reverse().toString();
        return bStr.equals(backStr);
    }

    private static boolean isSetBit(int num, int i) {
        return (((1 << i) & num) == (1 << i));
    }
}
