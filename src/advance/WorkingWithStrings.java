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
        for (int i = 0; i < word.length; i++){
            counter++;
        }
        return counter;
    }
}
