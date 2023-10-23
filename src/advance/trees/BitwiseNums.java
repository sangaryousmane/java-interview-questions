package advance.trees;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BitwiseNums {

    public static void main(String[] args) {
        // You can have constants, strings, and large nums
        // Create a new object when working with strings
        BigInteger b; // -2^Integer.max to 2^Integer.max
        b = BigInteger.valueOf(239382000);
        BigInteger c = BigInteger.valueOf(400);
        System.out.println(b.abs());

        System.out.println(fact(6));

        BigDecimal num = new BigDecimal("30");
        System.out.println(num.negate());
    }

    public static BigInteger fact(int num){
        BigInteger ans = new BigInteger("1");
        for (int i = 2; i < num; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
}
