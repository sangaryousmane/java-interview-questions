package advance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
       String word = "The quick brown fox jumps over a lazy dog";
        System.out.println(checkIfPangram(word));
    }
}
