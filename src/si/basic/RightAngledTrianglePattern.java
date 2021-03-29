package si.basic;

import java.io.*;

public class RightAngledTrianglePattern {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            printRightAngeTriangle(number, writer);
            writer.flush();
        }
    }

    private static void printRightAngeTriangle(int number, BufferedWriter writer) throws IOException {
        int nextNum = 1;
        for (int i = 1; i <= number; i++) {
            int[] tempArr = new int[i];
            for (int j = 0; j < i; j++) {
                tempArr[j] = nextNum;
                nextNum = nextNum + (number - j - 1);
            }
            nextNum = tempArr[0] + 1;
            for (int n : tempArr) {
                writer.write(n + " ");
            }
            writer.write("\n");
        }
    }
}
