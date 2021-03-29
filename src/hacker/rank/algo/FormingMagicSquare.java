package hacker.rank.algo;

import java.io.*;
import java.util.Arrays;

public class FormingMagicSquare {
    private static int minCost = Integer.MAX_VALUE;
    private static int[][] matrix = new int[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < 3; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        }

        int minCost = getMinCostToFormMagicSqaure(matrix);


        writer.write(minCost+"\n");
        writer.flush();

    }

    private static int getMinCostToFormMagicSqaure(int[][] matrix) {

        minCost = Integer.MAX_VALUE;
        int[] array = new int[10];
        boolean[] isVisited = new boolean[10];
        formMagicSquare(array, isVisited, 1);

        return minCost;
    }

    private static void formMagicSquare(int[] array, boolean[] isVisited, int index) {
        if (index == 10) {
            if (isMagicSquare(array)) {
                /*for (int i : array) {
                    System.out.print(i + " ");
                }
                System.out.println();*/
                minCost = Math.min(minCost, getCost(array));
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!isVisited[i]) {
                array[index] = i;
                isVisited[i] = true;
                formMagicSquare(array, isVisited, index + 1);
                isVisited[i] = false;
            }
        }
    }

    private static int getCost(int[] array) {
        int[] matArr = new int[10];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matArr[k++] = matrix[i][j];
            }
        }

        int cost = Math.abs(array[1] - matArr[1]) + Math.abs(array[2] - matArr[2]) + Math.abs(array[3] - matArr[3]) +
                Math.abs(array[4] - matArr[4]) + Math.abs(array[5] - matArr[5]) + Math.abs(array[6] - matArr[6]) +
                Math.abs(array[7] - matArr[7]) + Math.abs(array[8] - matArr[8]) + Math.abs(array[9] - matArr[9]);
        return cost;
    }

    private static boolean isMagicSquare(int[] array) {
        return ((array[1] + array[2] + array[3]) == 15 && (array[4] + array[5] + array[6]) == 15
                && (array[7] + array[8] + array[9]) == 15 && (array[1] + array[4] + array[7]) == 15
                && (array[2] + array[5] + array[8]) == 15 && (array[3] + array[6] + array[9]) == 15
                && (array[1] + array[5] + array[9]) == 15 && (array[3] + array[5] + array[7]) == 15);
    }
}
