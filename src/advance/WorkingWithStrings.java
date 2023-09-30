package advance;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WorkingWithStrings {


    public static int wordCount(String sentence){
        // first loop through the sentence
        // split the sentence by space ( )
        // store the split words in an array of string
        // count  each word in the array

        if (sentence.length() == 0){
            return 0;
        }
        int counter = 0;
        String[] word = sentence.split(" ");
        for (int i = 0; i < word.length; i++){
            counter++;
        }
        return counter;
    }

    public static boolean compare(String name1, String name2){
        return name1.equals(name2);
    }

    public static void alphabet(){
        StringBuilder alp = new StringBuilder();
        for (int i = 0; i < 26; i++){
            char chr = (char) ('a' + i);
            alp.append(chr).append(" ");
        }
        System.out.println(alp);
    }

    public static boolean isPalindrome(String word){

        if (word == null || word.length() == 0)
            return false;

        word = word.toLowerCase();
        int half = word.length() / 2;

        for (int i = 0; i < half; i++){
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


    public static StringBuffer playWithBuffer(String word){
        StringBuffer buffer=new StringBuffer(30);
        StringBuffer buffer1=new StringBuffer(word);
        StringBuffer buffer2=new StringBuffer();
        buffer.append(word).append(" is   the     best");
        String n = String.valueOf(buffer);
        System.out.println(n.replaceAll("\\s", ""));
        return buffer;
    }
    public static void playWithFile(){
        File file=new File("advance/out.txt");
        System.out.println(file.getPath());
        System.out.println();
    }
    public static void main(String[] args) {
//       String word = "The quick brown fox jumps over a lazy dog";
//        System.out.txt.println(playWithBuffer("Python "));
//        Random rand = new Random();
////        float[] nums =new float[5];
//       for (int i = 0; i < 5; i++){
//           System.out.txt.println(rand.nextInt(100) * 20);

        playWithFile();
       }
    }


