package leetcode.aug.challange;

import java.io.*;

public class D14LongestPalindromeWrong {
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

        int strLength = inputStr.length();

        int maxLength = 1;
        for (int i = 0; i < strLength; i++) {
            int oddAns = oddBS(inputStr, strLength, i);
            maxLength = Math.max(maxLength, oddAns);
            if ((i < strLength - 1) && (inputStr.charAt(i) == inputStr.charAt(i + 1))) {

                int evenAns = evenBS(inputStr, strLength, i);
                maxLength = Math.max(maxLength, evenAns);
            }
        }
        return maxLength;
    }

    private static int evenBS(String inputStr, int strLength, int center) {
        int lo = 0;
        int hi = Math.min(center, strLength - center - 2);
        int mid;

        int hlfAns = 0;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (isEvenPalindrome(inputStr, center, mid)) {
                hlfAns = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return 2 * hlfAns + 2;
    }

    private static int oddBS(String inputStr, int strLength, int center) {
        int lo = 0;
        int hi = Math.min(center, strLength - center - 1);
        int mid;

        int hlfAns = 0;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (isOddPalindrome(inputStr, center, mid)) {
                hlfAns = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }

        return 2 * hlfAns + 1;
    }

    private static boolean isOddPalindrome(String inputStr, int center, int mid) {

        String forwardStr = inputStr.substring(center - mid, center + mid + 1);
        String backwardStr = new StringBuilder(forwardStr).reverse().toString();

        return (forwardStr.equals(backwardStr));
    }

    private static boolean isEvenPalindrome(String inputStr, int center, int mid) {

        String forwardStr = inputStr.substring(center - mid, center + mid + 2);
        String backwardStr = new StringBuilder(forwardStr).reverse().toString();

        return (forwardStr.equals(backwardStr));
    }
}
