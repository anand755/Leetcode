package median.of.array;

import java.io.*;
import java.util.Arrays;

public class MedianOfArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] arrInput1 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int[] arrInput2 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int median = getMedian(arrInput1, arrInput2);
            writer.write(median + "\n");
            writer.flush();
        }
    }

    private static int getMedian(int[] arrInput1, int[] arrInput2) {

        int loA = Integer.MAX_VALUE;
        int loB = Integer.MAX_VALUE;

        if(arrInput1.length>0){
            loA = arrInput1[0];
        }
        if(arrInput2.length>0){
            loB = arrInput2[0];
        }
        int lo = Math.min(loA,loB);


        int hiA = Integer.MIN_VALUE;
        int hiB = Integer.MIN_VALUE;

        if(arrInput1.length>0){
            hiA = arrInput1[arrInput1.length-1];
        }
        if(arrInput2.length>0){
            hiB = arrInput2[arrInput2.length-1];
        }
        int hi = Math.min(hiA,hiB);


        //int lo = Math.min(arrInput1[0], arrInput2[0]);
        //int hi = Math.max(arrInput1[arrInput1.length - 1], arrInput2[arrInput2.length - 1]);
        int median = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int lowerCount = binarySearchToCountLowerVal(arrInput1, mid) + binarySearchToCountLowerVal(arrInput2, mid);
            int higherCount = binarySearchToCountHigherVal(arrInput1, mid) + binarySearchToCountHigherVal(arrInput2, mid);
            if (lowerCount == higherCount) {
                median = mid;
                break;
            } else if (lowerCount < higherCount) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return median;
    }

    private static int binarySearchToCountLowerVal(int[] arrInput, int searchVal) {
        int ans = 0;
        int loIdx = 0;
        int hiIdx = arrInput.length - 1;
        while (loIdx <= hiIdx) {
            int midIdx = (loIdx + hiIdx) / 2;
            if (arrInput[midIdx]==searchVal){
                return midIdx;
            }
            else if (arrInput[midIdx] < searchVal) {
                ans = midIdx;
                loIdx = midIdx + 1;
            } else {
                hiIdx = midIdx - 1;
            }
        }
        return ans + 1;
    }

    private static int binarySearchToCountHigherVal(int[] arrInput, int searchVal) {
        int ans = 0;
        int loIdx = 0;
        int hiIdx = arrInput.length - 1;
        while (loIdx <= hiIdx) {
            int midIdx = (loIdx + hiIdx) / 2;
            if (arrInput[midIdx] == searchVal) {
                return (arrInput.length - midIdx-1);
            } else if (arrInput[midIdx] < searchVal) {
                loIdx = midIdx + 1;
            } else {
                ans = midIdx;
                hiIdx = midIdx - 1;
            }
        }
        return arrInput.length - ans;
    }
}
