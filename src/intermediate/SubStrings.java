package intermediate;

import java.util.ArrayList;

/*
Author: Ousmane Sangary
 */
public class SubStrings {

    public static void main(String[] args) {
//        skipChar("", "baccdah", 'c');
//        System.out.println(skipSubsStringIfNot("ahahousmanepw",
//                "ousmane", "gfbv"));
//        System.out.println("abc");
        System.out.println(permutationsCounts("", "abcde"));
    }

    // Skip a given character in a string
    public static void skipChar(String temp, String main, char skipChar) {
        if (main.isEmpty()) {
            System.out.println(temp);
            return;
        }
        char ch = main.charAt(0);
        if (ch == skipChar)
            skipChar(temp, main.substring(1), skipChar);
        else
            skipChar(temp + ch, main.substring(1), skipChar);
    }

    // Skip a substring in a string
    public static String skipString(String main, String skp) {
        if (main.isEmpty()) {
            return "";
        }
        int len = skp.length();
        if (main.startsWith(skp))
            return skipString(main.substring(len), skp); // skip that length
        else
            return main.charAt(0) + skipString(main.substring(1), skp);
    }

    // Skip a substring only if it doesn't start with a given substring
    // Eg: skip apple only if it doesn't start with apple. but don't skip app
    static String skipSubsStringIfNot(String main, String skp, String target) {
        if (main.isEmpty())
            return "";

        int len = skp.length();
        if (main.startsWith(skp) && !main.startsWith(target))
            return skipSubsStringIfNot(main.substring(len), skp, target);
        else
            return main.charAt(0)
                    + skipSubsStringIfNot(main.substring(1), skp, target);
    }

    static void subSequence(String skp, String main) {
        if (main.isEmpty()) {
            System.out.print(skp + " ");
            return;
        }
        char ch = main.charAt(0);
        subSequence(skp, main.substring(1)); // skip
        subSequence(skp + ch, main.substring(1)); // Don't skip
        subSequence(skp + (ch + 0), main.substring(1)); // Don't skip

    }

    static ArrayList<String> subSeqList(String skp, String main) {
        if (main.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(skp);
            return list;
        }
        ArrayList<String> left = subSeqList(skp + main.charAt(0), main.substring(1));
        ArrayList<String> right = subSeqList(skp, main.substring(1));
        left.addAll(right);
        return left;
    }

    static boolean isPrime(int num) {
        boolean prime = true;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }


    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            permutations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationsList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    static int permutationsCounts(String p, String up) {
        if (up.isEmpty())
            return 1;
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            count += permutationsCounts(f + ch + s, up.substring(1));

        }
        return count;
    }
}
