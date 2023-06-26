package advance;

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
        int i = 0;
        while ( i < word.length){
            counter++;
            i++;
        }
        return counter;
    }
}
