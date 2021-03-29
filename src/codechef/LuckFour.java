package codechef;

import java.io.*;
import java.util.Scanner;

public class LuckFour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int inputNum = Integer.parseInt(reader.readLine());
            int count = getFourCount(inputNum);
            writer.write(count + "\n");
        }
        writer.flush();
    }

    private static int getFourCount(int inputNum) {
        //int number = Integer.parseInt(inputNum);
        int count = 0;
        while (inputNum != 0) {
            int digit = inputNum % 10;
            count += (digit == 4) ? 1 : 0;
            inputNum = inputNum/10;
        }
        return count;
    }
}
