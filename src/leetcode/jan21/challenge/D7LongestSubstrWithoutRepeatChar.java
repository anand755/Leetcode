package leetcode.jan21.challenge;

import java.util.HashSet;
import java.util.Set;

public class D7LongestSubstrWithoutRepeatChar {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int maxLen = lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = s.length() > 0 ? 1 : 0;
        int length = s.length();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String currSubStr = s.substring(i, j);
                if (isDublicateExist(currSubStr)) {
                    break;
                } else {
                    maxLen = currSubStr.length();
                }
            }
        }
        return 0;
    }

    private static boolean isDublicateExist(String currSubStr) {
        HashSet<Character> strSet = new HashSet<Character>();
        for (Character ch:currSubStr.toCharArray()){
            if (strSet.contains(ch)){
                return true;
            }else {
                strSet.add(ch);
            }
        }
        return false;
    }
}
