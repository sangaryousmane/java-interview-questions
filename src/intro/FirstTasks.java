package intro;

public class FirstTasks {

    /**
     * Input a year and find whether it is a leap year or not.
     * To determine whether a given year is a leap year or not, you can use the following rules:
     * If the year is evenly divisible by 4, it is a leap year.
     * If the year is also divisible by 100, it is not a leap year, unless...
     * The year is also divisible by 400, in which case it is a leap year.
     */
    public static boolean isLeapYear(int year){

        if (year % 4 == 0 || (year % 400 == 0 && year % 100 ==0)){
            return true;
        }
        else {
            return false;
        }
    }

    // Take two numbers and print the sum of both.
    public static int sumOfTwoNumbers(int a, int b){
        return a + b;
    }
}
