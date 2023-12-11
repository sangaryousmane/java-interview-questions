package advance;


import java.io.File;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class WorkingWithStrings {


    public static int wordCount(String sentence) {
        // first loop through the sentence
        // split the sentence by space ( )
        // store the split words in an array of string
        // count  each word in the array

        if (sentence.length() == 0) {
            return 0;
        }
        int counter = 0;
        String[] word = sentence.split(" ");
        for (int i = 0; i < word.length; i++) {
            counter++;
        }
        return counter;
    }

    public static boolean compare(String name1, String name2) {
        return name1.equals(name2);
    }

    public static void alphabet() {
        StringBuilder alp = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char chr = (char) ('a' + i);
            alp.append(chr).append(" ");
        }
        System.out.println(alp);
    }

    public static boolean isPalindrome(String word) {

        if (word == null || word.length() == 0)
            return false;

        word = word.toLowerCase();
        int half = word.length() / 2;

        for (int i = 0; i < half; i++) {
            int start = word.charAt(i);
            int end = word.charAt(word.length() - 1 - i);

            if (start == end)
                return true;
        }
        return false;
    }

    // The sentence is a pangram if it contains all the characters of the alphabet
    public static boolean checkIfPangram(String sentence) {
        Set<Character> letters = new HashSet<>();

        for (char letter : sentence.toCharArray()) {
            letters.add(letter);
        }
        return letters.size() == 26;
    }


    public static StringBuffer playWithBuffer(String word) {
        StringBuffer buffer = new StringBuffer(30);
        StringBuffer buffer1 = new StringBuffer(word);
        StringBuffer buffer2 = new StringBuffer();
        buffer.append(word).append(" is   the     best");
        String n = String.valueOf(buffer);
        System.out.println(n.replaceAll("\\s", ""));
        return buffer;
    }

    public static void playWithFile() {
        File file = new File("advance/out.txt");
        System.out.println(file.getParentFile());
        System.out.println();
    }


    private static void randomStrings() {
        String s1 = "Mickey;Bolton;12345;121216";
        String s2 = " \"a|b|c\"";
        String regex = Pattern.quote("|");

        String str = "the lazy fox jumped over the brown fence";

        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
//        System.out.println(Arrays.toString(s2.split("\\|")));
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add("foo");
        sj.add("Bar");
        sj.add("fooBar");
        System.out.println(sj);

        System.out.println("Hello".concat(" World"));
        System.out.println("Hello Work, Java".substring(12));
        String datestring = "2015年11月17日";
        System.out.println(
                datestring.substring(0, 4) +
                        "-" + datestring.substring(5, 7) + "-" +
                        datestring.substring(8, 10));

        String trimming = "      Peter is a workaholic  ";
        System.out.println(trimming.trim());
        long length = trimming.codePoints().count();
        int leng = trimming.length();
        System.out.println("Length: " + length + " leng: " + leng);
    }

    public static void dateTimeType() {
        System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm.ss")
                .format(Calendar.getInstance().getTime()));
    }

    // https://leetcode.com/problems/baseball-game/description/
    // O(N)
    public static int baseballGame(String[] operations) {
        Stack<Integer> ball = new Stack<>();

        for (String ops : operations) {
            switch (ops) {
                case "+" -> ball.push(ball.peek() + ball.elementAt(ball.size() - 2));
                case "D" -> ball.push(2 * ball.peek());
                case "C" -> ball.pop();
                default -> ball.push(Integer.parseInt(ops));
            }
        }
        // Sum all the stack's elements as long it is not empty
        int sum = 0;
        while (!ball.isEmpty()) {
            sum += ball.pop();
        }
        return sum;
    }

    // O(n)
    // https://leetcode.com/problems/valid-parentheses/description/
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char chr : s.toCharArray()) {
            if (chr == '{')
                stack.push('}');
            else if (chr == '(')
                stack.push(')');
            else if (chr == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != chr)
                return false;
        }
        return stack.isEmpty();
    }

    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char chr: s.toCharArray()){
            if (chr == ')')
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(chr);
            else
                stack.push(chr);
        }
        return stack.size();
    }

    // https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0, end = bits.length - 1;
        while (i < end) {
            if (bits[i] != 0)
                i++;
            i++;
        }
        return i == end;
    }

    // https://leetcode.com/problems/a-number-after-a-double-reversal/description/
    public static boolean isSameAfterReversals(int num) {
        return num <= 9 && num % 10 != 0;
    }

    // https://leetcode.com/problems/account-balance-after-rounded-purchase/
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        if (purchaseAmount % 10 >= 5)
            purchaseAmount += 10 - purchaseAmount % 10;
        else
            purchaseAmount -= purchaseAmount % 10;
        return 100 - purchaseAmount;
    }

    // https://leetcode.com/problems/integer-to-roman/description/
    public String intToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hrns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ths = {"", "M", "MM", "MMM"};
        return ths[num / 1000] +
                hrns[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                ones[num % 10];
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("4");
        BigInteger b = new BigInteger("5");


    }

    private static void moreCollections() {
        List<String> data = Arrays.asList("ab", "bc", "cd", "ab", "bc", "cd");
        Set<String> names = new HashSet<>(data);
        SortedSet<String> names1 = new TreeSet<>(data);
        Set<String> names2 = new LinkedHashSet<>(data);
        Map<String, Boolean> names3 = new TreeMap<>();
        Map<String, Boolean> names4 = new LinkedHashMap<>();
        Map<String, Boolean> names5 = new HashMap<>(10);

        names5.put("Java", true);
        names5.put("Python", true);
        names5.put("JS", true);
        names5.put("GO", false);

        HashMap<String, Boolean> names6 = new HashMap<>();

        List<String> unModify = Collections.unmodifiableList(data);
//        unModify.add("Hello"); // Can't be modify
        unModify.forEach(System.out::println);

        List<String> anEmptyList = Collections.emptyList();
        Map<Integer, Date> anEmptyMap = Collections.emptyMap();
        Set<Number> anEmptySet = Collections.emptySet();
//        anEmptyList.addAll(data); // Can't modify mutable collections
        System.out.println(anEmptyList);
        NavigableSet<Integer> desc = new TreeSet<>();
        desc.add(4);
        desc.add(10);
        desc.add(6);
        desc.add(7);
        System.out.println(desc);
        System.out.println("Floor:" + desc.floor(8));
        System.out.println("Ceiling:" + desc.ceiling(9));
        System.out.println("Lower:" + desc.lower(6));
        System.out.println("Higher:" + desc.higher(6));
    }

    private static void removeElementsInAList() {
        //        String[] arr = new String[] {"str1", "str2", "str3"};
//        Stream<String> stream = Arrays.stream(arr);
//        stream.forEach(System.out::println)

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");

//        System.out.println(fruits.stream().filter((f)->
//                !"Banana".equals(f)).toList());
        fruits.removeIf("Banana"::equals);
        fruits.forEach(System.out::println);
    }
}


