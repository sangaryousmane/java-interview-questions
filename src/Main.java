
import intermediate.FindInMountain;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 4, 2, 1};
        int target = 2;
        int result = FindInMountain.findInMountainArray(
                3, arr);
        System.out.println(result);
    }


}
