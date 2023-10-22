package intermediate;

public class StringManipulation {


    public static void manipulation(String name) {

        System.out.println(name.charAt(5));
    }

    public static void pattern1(int n) {

        for (int row = 1; row <= n; row++) {

            for (int column = 1; column <= row; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {

        for (int row = 1; row <= n; row++) {

            for (int column = 1; column <= n; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n) {

//        for (int row = n; row > 0; row--){
//            for (int column = 1; column <= row; column++){
//                System.out.txt.print("* ");
//            }
//            System.out.txt.println();
//        }

        // second way
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n - row + 1; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        for (int row = 1; row <= n; row++) {

            for (int column = 1; column <= row; column++) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {

        for (int row = 0; row <= 2 * n; row++) {
            int totalColsRows = row > n ? 2 * n - row : row;

            for (int column = 1; column <= totalColsRows; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Triangle
    public static void pattern7(int n, String direction) {

        boolean isAsc = direction.equals("asc");

        if (isAsc) {
            for (int row = 1; row <= n; row++) {
                direction(n, row);
            }
        } else {
            for (int row = n; row > 0; row--) {
                direction(n, row);
            }
        }

    }

    private static void direction(int n, int row) {
        for (int column = 1; column <= n - row; column++) {
            System.out.print(" ");
        }

        for (int count = 1; count <= 2 * row - 1; count++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // Triangle inverse
    public static void pattern8(int n) {
        for (int row = 1; row <= n; row++) {

            for (int column = 1; column <= 4; column++) {
                if (column == 1 || column == 4 || row == 1 || row == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
