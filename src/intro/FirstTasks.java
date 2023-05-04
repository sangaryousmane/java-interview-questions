package intro;

import java.util.Scanner;

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

    // Take a number as input and print the multiplication table for it
    public static void timesTable(int num){
        int i = 1;
        while (i <= 12){
            System.out.println(num +" x "+ i +" = " + num * i);
            i++;
        }
    }

    // - Take 2 numbers as inputs and find their HCF and LCM.
    // We use the EUCLIDEAN Algorithm for this
    public static int HCF(int num1, int num2){

//        if (num2 == 0)
//            return num1;
//        else
//            return HCF(num2, num1 % num2);

        while (num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static int LCM(int num1, int num2){
        int hcf = HCF(num1, num2);
        return (num1 * num2) / hcf;
    }

    //  Keep taking numbers as inputs till the user enters ‘x’, after that print sum of all.
    public static int sum(){
        int sum = 0;
        Scanner scanner=new Scanner(System.in);

        while (true){
            System.out.println("Enter a number or x to exit");
            String Input = scanner.nextLine();
            if (Input.equals("x")) {
                break;
            }
            sum += Integer.parseInt(Input);
        }
        return sum;
    }
}
