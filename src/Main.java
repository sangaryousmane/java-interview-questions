
import intermediate.FindInMountain;
import maharishi.CodingTests;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        char[] arr = {'a', 'b', 'c'};
        int target = 2;
        char[] result = CodingTests.startToLength(arr, 1, 3);
        System.out.println(Arrays.toString(result));
    }


}
