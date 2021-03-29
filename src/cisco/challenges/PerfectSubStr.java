package cisco.challenges;

import java.io.*;

public class PerfectSubStr {

    static int MAX_CHAR = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String inputStr = reader.readLine();
            int k = Integer.parseInt(reader.readLine());
            int subStrCount = getSubStrCount(inputStr, k);
            writer.write(subStrCount + "\n");
            writer.flush();
        }
    }

    private static int getSubStrCount(String inputStr, int k) {

        int subStrCount = 0;

        for (int i = 0; i < inputStr.length(); i++) {

            int[] freqArr = new int[10];

            for (int j = i; j < inputStr.length(); j++) {

                String indexStr = inputStr.charAt(j) + "";
                int index = Integer.parseInt(indexStr);
                freqArr[index]++;

                if (freqArr[index] > k)
                    break;

                else if (freqArr[index] == k && isValidSubString(freqArr, k))
                    subStrCount++;
            }
        }
        return subStrCount;
    }

    private static boolean isValidSubString(int[] freqArr, int k) {
        for (int i = 0; i < 10; i++) {
            if (freqArr[i] != 0 && freqArr[i] != k)
                return false;
        }
        return true;
    }
}
