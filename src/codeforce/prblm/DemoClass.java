package codeforce.prblm;

import java.io.*;

public class DemoClass {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int b = Integer.parseInt(reader.readLine());
            int result = 1 << b;
            writer.write(result + "\n");
            writer.flush();
        }
        //writer.flush();

    }

    private static int getResult(int a) {
        return 0;
    }
}
