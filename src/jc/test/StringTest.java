package jc.test;

public class StringTest {
    public static void main(String[] args) {
        String str = "  This is a good    day  ";

        int wordCount = 0;
        //boolean isWord = false;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (!(ch + "" == "\\s")) {

                while (i<str.length() && str.charAt(i) + "" != "\\s") {
                    i++;
                }
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }
}
