package intro;

public class FourthTasks {

    // 1. Define two methods to print the maximum and the minimum number respectively among three numbers entered by the user.
    public static int max(int a, int b, int c) {
//        int min, max;
//        if (a > b && b > c){
//            max = a;
//            min = c;
//        }
//        else if (b > a && a > c){
//            max = b;
//            min = c;
//        }
//        else {
//            max = c;
//            min = a;
//        }
//        System.out.println("Maximum is: " + max);
//        System.out.println("Minimum is: "+ min);
//    }
        int maximum = a;
        if (b >= maximum) {
            maximum = b;
        }
        if (c >= maximum) {
            maximum = c;
        }
        return maximum;
    }

    public static int min(int a, int b, int c) {
        int min = a;

        if (b <= min) {
            min = b;
        }
        if (c <= min) {
            min = c;
        }
        return min;
    }

    // 3. A person is eligible to vote if his/her age is greater than or equal to 18. Define a method to find out if he/she is eligible to vote.
    public static boolean eligibleToVote(int age){
        return age >= 18;
    }

    // 7. Define a method to find out if a number is prime or not.
    public static boolean isPrime(int n){
        int i = 1, primeCounter = 0;
        while (i <= n){
            if (n % i == 0){
                primeCounter++;
            }
            i++;
        }
        return primeCounter == 2;
    }
}
