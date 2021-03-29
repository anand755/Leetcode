package codeforce.prblm;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MaxAndMex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] nk = Arrays.stream(reader.readLine().trim().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int n = nk[0];
            int k = nk[1];
            int[] inputArr = Arrays.stream(reader.readLine().trim().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int size = getUniqueElementsSize(inputArr, n, k);
            writer.write(size + "\n");
            writer.flush();
        }
    }

    private static int getUniqueElementsSize(int[] inputArr, int n, int k) {
        List<Integer> arrList = new ArrayList<>();
        for (int a : inputArr) {
            arrList.add(a);
        }

        while (k-- > 0) {
            int a = mexOfList(arrList);
            int b = 1;//maxOfList(arrList);
            int c = (a + b) / 2;
            arrList.add(c);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer a : arrList) {
            set.add(a);
        }
        return set.size();
    }

    private static int mexOfList(List<Integer> arrList) {
        Collections.sort(arrList);



        return 0;
    }


}
