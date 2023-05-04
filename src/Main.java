import intro.SecondTask;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean isPal = SecondTask.isPalindrome("ypey");
        if (isPal) {
            System.out.println("It is palindrome");
        } else {
            System.out.println("It is not");
        }
    }

}
