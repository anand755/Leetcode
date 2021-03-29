package cisco.challenges;

import java.io.*;
import java.util.List;

public class HowManyWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String inputStr = reader.readLine().trim();
            int wordCount = howMany(inputStr);
            writer.write(wordCount + "\n");
            writer.flush();
        }

    }

    private static int howMany(String sentence) {
        String[] wordArr = sentence.split(" ");
        int wordCount = 0;

        for (String word : wordArr) {

            String newWord = word.replaceAll("\\,", "").replaceAll("\\.", "").
                    replaceAll("\\!", "").replaceAll("\\?", "");
            if (!newWord.isEmpty() && isProperWord(newWord)) {
                wordCount++;
            }
        }

        return wordCount;
    }

    private static boolean isProperWord(String newWord) {
        for (char ch : newWord.toCharArray()) {
            int asciVal = (int) ch;
            if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch + "").equals("-"))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isaNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
