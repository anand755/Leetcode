package ln.practice;

import java.io.*;
import java.util.Arrays;

public class DivisiblePairsSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());

        while (testCaseCount-- > 0) {
            int[] nk = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int n = nk[0];
            int k = nk[1];

            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int count = getDivSumPairCount(arrInput, n, k);
            writer.write(count + "\n");
            writer.flush();
        }
    }

    private static int getDivSumPairCount(int[] arrInput, int n, int k) {

        mergeSort(arrInput, 0, n - 1);
        return 0;
    }

    private static void mergeSort(int[] arrInput, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = (lo + hi) / 2;
        mergeSort(arrInput, lo, mid);
        mergeSort(arrInput, mid + 1, hi);
        merge(arrInput, lo, mid, hi);
    }

    private static void merge(int[] arrInput, int lo, int mid, int hi) {

        int p1 = lo, p2 = mid + 1;
        int[] tmpArr = new int[hi - lo + 1];
        int k = 0;
        while (p1 <= mid && p2 <= hi) {
            if (arrInput[p1] < arrInput[p2]) {
                tmpArr[k++] = arrInput[p1++];
            } else {
                tmpArr[k++] = arrInput[p2];
            }
        }
        while (p1 <= mid) {
            tmpArr[k++] = arrInput[p1++];
        }
        while (p2 <= hi) {
            tmpArr[k++] = arrInput[p2++];
        }


        for (int i = lo; i <= hi; i++) {
            arrInput[i] = tmpArr[i - lo];
        }


    }

}
