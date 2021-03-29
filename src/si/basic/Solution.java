package si.basic;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n, k;
            String[] inp = br.readLine().split(" ");
            n = Integer.parseInt(inp[0]);
            k = Integer.parseInt(inp[1]);
            inp = br.readLine().split(" ");
            int[] ar = new int[n];
            for (int j = 0; j < n; j++)
                ar[j] = Integer.parseInt(inp[j]);

            Arrays.sort(ar);
            int i = 0;
            int j = n - 1;
            int count = 0;
            while (i < j) {

                if ((ar[i] + ar[j]) > k) {
                    j--;
                } else if ((ar[i] + ar[j]) < k) {
                    i++;
                } else {

                    System.out.println("True");
                    break;
                }
            }
            System.out.println("False");
        }
        //w.write(ans+"\n");
    }
}
