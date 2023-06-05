import intermediate.ArraysHub;
import intermediate.Searching;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        char[] arr = {'x','x','y', 'y'};
        char target = 'x';
        char result = Searching.nextGreatestLetter(arr, target);
        System.out.println(result);
    }


}
