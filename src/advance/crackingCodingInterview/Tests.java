package advance.crackingCodingInterview;

import advance.crackingCodingInterview.linkedList.general.DeleteDuplicates;
import advance.crackingCodingInterview.linkedList.general.DeleteMiddle;
import advance.crackingCodingInterview.linkedList.general.KthToLast;
import advance.crackingCodingInterview.linkedList.general.PartitionAroundX;
import advance.crackingCodingInterview.linkedList.palindromes.PalindromeStack;
import advance.crackingCodingInterview.oops.Hasher;

public class Tests {


    public static void main(String[] args) {
        Hasher<Integer, String> hash=new Hasher<>(3);
        hash.put(1, "Deleted");
        System.out.println(hash.get(1));
    }
}
