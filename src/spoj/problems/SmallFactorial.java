package spoj.problems;

import java.math.BigInteger;
import java.util.Scanner;

public class SmallFactorial {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long ni = sc.nextLong();
            BigInteger n = BigInteger.valueOf(ni);
            BigInteger a = BigInteger.valueOf(1);
            while (n.intValue() > 0) {
                a = a.multiply(n);
                n = n.subtract(BigInteger.valueOf(1));
            }
            System.out.println(a);
        }
    }
}
