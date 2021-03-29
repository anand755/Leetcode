package walmart.preparation;

import java.io.*;
import java.util.Arrays;

public class SomeTestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            writer.write(args.length + "\n");
            writer.flush();
        }
    }
}
