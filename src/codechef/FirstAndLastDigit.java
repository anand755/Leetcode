package codechef;

import java.io.*;

public class FirstAndLastDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String inputNum = reader.readLine().trim();
            char[] arr = inputNum.toCharArray();

            int firstDigit = Integer.parseInt(inputNum.charAt(0)+"");
            int lastDigit = Integer.parseInt(inputNum.charAt(arr.length-1)+"");
            int sum = firstDigit+lastDigit;

            writer.write(sum + "\n");
        }
        writer.flush();
    }
}
