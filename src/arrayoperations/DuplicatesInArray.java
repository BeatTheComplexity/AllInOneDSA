package arrayoperations;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {

    /*
        Given a read only array of n + 1 integers between 1 and n, 
        find one number that repeats in linear time using less than O(n) space 
        and traversing the stream sequentially O(1) times.
     */
    public static int findDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                return arr[i];
            }
        }

        return -1;
    }
}
