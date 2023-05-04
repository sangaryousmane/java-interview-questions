import intro.FirstTasks;

public class Main {

    public static void main(String[] args) {
        int year = 2020;
        if(FirstTasks.isLeapYear(year)){
            System.out.println(year + " Is leap year");
        }
        else {
            System.out.println(year + " It is not a leap");
        }
    }
}
