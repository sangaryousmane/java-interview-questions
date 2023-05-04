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
}
