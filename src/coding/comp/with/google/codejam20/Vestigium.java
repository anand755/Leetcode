package coding.comp.with.google.codejam20;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        for (int testNo = 1; testNo <= testCaseCount; testNo++) {
            int matSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matSize][matSize];
            for (int i = 0; i < matSize; i++) {
                matrix[i] = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            }
            String krc = getKrc(matrix, matSize);
            writer.write("Case #" + testNo + ": " + krc + "\n");
            writer.flush();
        }
    }

    private static String getKrc(int[][] matrix, int matSize) {

        int kSum = 0;
        for (int k = 0; k < matSize; k++) {
            kSum += matrix[k][k];
        }

        int rCount = 0, cCount = 0;

        for (int r = 0; r < matSize; r++) {
            Set<Integer> tempSet = new HashSet<>();
            for (int c = 0; c < matSize; c++) {
                tempSet.add(matrix[r][c]);
            }
            if (tempSet.size() < matSize) {
                rCount++;
            }
        }
        for (int c = 0; c < matSize; c++) {
            Set<Integer> tempSet = new HashSet<>();
            for (int r = 0; r < matSize; r++) {
                tempSet.add(matrix[r][c]);
            }
            if (tempSet.size() < matSize) {
                cCount++;
            }
        }
        return (kSum + " " + rCount + " " + cCount);
    }
}