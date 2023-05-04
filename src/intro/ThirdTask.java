package intro;

public class ThirdTask {

    // Area Of Circle Java Program
    // Formula: area = π * r2
    public static double areaOfCircle(int radius) {
        return Math.PI * (radius * radius);
    }

    // Area Of Triangle and  Isosceles Triangle
    // Formula: area = (1/2) · b · h
    public static double areaOfTriangle(int base, int height) {
        return 0.5 * (base * height);
    }

    // 3. Area Of Rectangle Program
    // Area = l * w
    public static double areaOfRectangle(int length, int width) {
        return width * length;
    }

    // Area Of Parallelogram
    // Area = b * h
    public static double areaOfParallelogram(int base, int length) {
        return base * length;
    }

    // Area Of Rhombus
    // area = 1/2 * p * q
    public static double areaOfRhombus(int diagonal1, int diagonal2) {
        return (double) (diagonal1 * diagonal2) / 2;
    }

    // Area Of Equilateral Triangle
    // area = (1/4) · sqrt(3) · s2
    public static double areaOfRhombus(int sizes) {
        double temp = Math.sqrt(3) * (sizes * sizes);
        return temp / 0.25;
    }

    // 8. Perimeter Of Circle
    // perimeter = 2 · π · r
    public static double perimeterOfCircle(int radius) {
        return 2 * Math.PI * radius;
    }

    // Perimeter Of Equilateral Triangle
    // perimeter = 3 · s
    public static double perimeterOfEquilateral(int sizes) {
        return 3 * sizes;
    }

    // 10. Perimeter Of Parallelogram
    // perimeter = 2 · (s + b)
    public static double perimeterOfParallelogram(double sizes, int base) {
        return 2 * (sizes + base);
    }

    // Perimeter Of Rectangle
    // perimeter = 2 (w + h)
    public static double perimeterOfRectangle(double w, double h) {
        return 2 * (w + h);
    }

    // 22. Subtract the Product and Sum of Digits of an Integer
    // n % 25 => gets the last digit of the number
    public static int productSum(int n) {
        int product = 1, sum = 0;

//        int multi = 1, sum = 0;
//        while (n != 0) {
//            int rem = n % 10; //take last digit of n
//            sum += rem;
//            multi *= rem;
//            n = n / 10; // dropping last digit of n
//        }
//        return multi - sum;
        if (n <= 0) {
            return -1;
        }
        for (; n != 0; n /= 10) {
            sum = sum + (n % 10);
            product = product * (n % 10);
        }
        return product - sum;
    }

    // Input a number and print all the factors of that number (use loops).
    public static void printFactors(int n) {

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i + " ");
            }
        }
    }

    // Factorial Program In Java
    public static int factorial(int n) {
//        int result = 1, i = 1;
//        while ( i <= n){
//            result *= i;
//            i++;
//        }
//        return result;

        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Power In Java
    public static int power(int base, int exponent) {
//        int result = 1;
//        for (int i = 1; i<=exponent; i++){
//            result *=base;
//        }
//        return result;

        int i = 1, result = 1;
        while (i <= exponent) {
            result *= base;
            i++;
        }
        return result;
    }

    // Java Program Vowel Or Consonant
    public static int vowelOrConsonant(char letter) {
        if (isVowel(letter)){
            System.out.println(letter + " is a vowel letter.");
        }
        else {
            System.out.println(letter + " is a consonant letter");
        }
        return 0;
    }

    static boolean isVowel(char letter) {
        return switch (letter) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

    // Sum Of A Digits Of Number
    public static int sumOfDigits(int n){
        int sum = 0;
        while (n !=0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    // Perfect Number In Java
    // A perfect number is a positive integer that is equal to the sum of its proper divisors (excluding itself)
    public static boolean perfectNumber(int number){
        int i =  1, sum = 0;

        while (i < number){
            if (number % i == 0){
                sum += i;
            }
            i++;
        }
        return sum == number;
    }
}

