package advance;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class WorkingWithStrings {


    public static int wordCount(String sentence) {
        // first loop through the sentence
        // split the sentence by space ( )
        // store the split words in an array of string
        // count  each word in the array

        if (sentence.length() == 0) {
            return 0;
        }
        int counter = 0;
        String[] word = sentence.split(" ");
        for (int i = 0; i < word.length; i++) {
            counter++;
        }
        return counter;
    }

    public static boolean compare(String name1, String name2) {
        return name1.equals(name2);
    }

    public static void alphabet() {
        StringBuilder alp = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char chr = (char) ('a' + i);
            alp.append(chr).append(" ");
        }
        System.out.println(alp);
    }

    public static boolean isPalindrome(String word) {

        if (word == null || word.length() == 0)
            return false;

        word = word.toLowerCase();
        int half = word.length() / 2;

        for (int i = 0; i < half; i++) {
            int start = word.charAt(i);
            int end = word.charAt(word.length() - 1 - i);

            if (start == end)
                return true;
        }
        return false;
    }

    // The sentence is a pangram if it contains all the characters of the alphabet
    public static boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();

        for (char letter : sentence.toCharArray()) {
            letters.add(letter);
        }
        return letters.size() == 26;
    }


    public static StringBuffer playWithBuffer(String word) {
        StringBuffer buffer = new StringBuffer(30);
        StringBuffer buffer1 = new StringBuffer(word);
        StringBuffer buffer2 = new StringBuffer();
        buffer.append(word).append(" is   the     best");
        String n = String.valueOf(buffer);
        System.out.println(n.replaceAll("\\s", ""));
        return buffer;
    }

    public static void playWithFile() {
        File file = new File("advance/out.txt");
        System.out.println(file.getPath());
        System.out.println();
    }

    public static void main(String[] args) {

    }

    private static void randomStrings() {
        String s1 = "Mickey;Bolton;12345;121216";
        String s2 = " \"a|b|c\"";
        String regex = Pattern.quote("|");

        String str = "the lazy fox jumped over the brown fence";

        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
//        System.out.println(Arrays.toString(s2.split("\\|")));
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("foo");
        sj.add("Bar");
        sj.add("fooBar");
        System.out.println(sj);

        System.out.println("Hello".concat(" World"));
        System.out.println("Hello Work, Java".substring(12));
        String datestring = "2015年11月17日";
        System.out.println(
                datestring.substring(0, 4) +
                        "-"+datestring.substring(5, 7) + "-"+
                        datestring.substring(8, 10));

        String trimming = "      Peter is a workaholic  ";
        System.out.println(trimming.trim());
        long length = trimming.codePoints().count();
        int leng = trimming.length();
        System.out.println("Length: "+length + " leng: "+ leng);
    }

    public static void dateTimeType(){
        System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm.ss")
                .format(Calendar.getInstance().getTime()));
    }
}


