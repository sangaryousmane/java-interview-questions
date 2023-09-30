package intro;

import java.util.Scanner;

public class SecondTask {
    static Scanner scanner=new Scanner(System.in);


    // - Write a program to print whether a number is even or odd, also take input from the user.
    // Return true is even, false if not
    public static boolean evenOrOdd(){
        System.out.println("Please enter a number: ");
        int num = scanner.nextInt();
        return num % 2 == 0;
    }

    // - Take name as input and print a greeting message for that particular name.
    public static void greetings(){
        System.out.println("Enter a name and I will greet: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
    }

    // - Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.
    // Formula = (P * R * T) / 100
    public static double simpleInterest(){
        System.out.println("Enter Principle: ");
        double P = scanner.nextDouble();
        System.out.println("Enter Time: ");
        double T = scanner.nextDouble();
        System.out.println("Enter Rate: ");
        double R = scanner.nextDouble();

       return (P * R * T) / 100;
    }

    // - Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)
    public static int getCalculations(int num1, int num2) throws Exception {
        System.out.println("Enter an operator: ");
        String c=scanner.nextLine();
        char operator=c.charAt(0);
        int result;
        if (operator == '+'){
            result = num1 + num2;
        }
        else if (operator == '*'){
            result = num1 * num2;
        }
        else if (operator == '/'){
            if (num2 > 0) {
                result = num1 / num2;
            }
            else {
                throw new Exception("Not divisible by 0. ");
            }
        }
        else {
            result = num1 - num2;
        }
        return result;
    }

    //  Take 2 numbers as input and print the largest number.
    public static int largest(int a, int b){

        if (a != b) {
            if (a > b) {
                return a;
            }
            else {
                return b;
            }
        }
        return -1;
    }

    // - To calculate Fibonacci Series up to n numbers.
    public static int fibonacciRecur(int n){
        if (n <= 1){
            return n;
        }
        return fibonacciRecur(n - 1) + fibonacciRecur(n - 2);
    }

    public static void fibonacciIterate(int n){
        int a = 0, b = 1, i = 0;

        while (i < n){
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
            i++;
        }
    }

    // To find out.txt whether the given String is Palindrome or not.
    public static boolean isPalindrome(String input){

        int start = 0, end = input.length() - 1;

        while (start < end){
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++; // Keep going towards the end string
            end--;  // Keep going towards the start string
        }
        return true;
    }
}
