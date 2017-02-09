package arrayoperations;

import java.util.ArrayList;

public class FirstMissingInteger {

    /*
        Given an unsorted integer array, find the first missing positive integer.

        Example:

        Given   [1,2,0] return 3,
                [3,4,-1,1] return 2,
                [-8, -7, -6] returns 1

        Your algorithm should run in O(n) time and use constant space.
     */
    public static int firstMissingPositive(ArrayList<Integer> a) {
        //Integer[] arr =(int[]) a.toArray();

        int n = a.size();

        for (int i = 0; i < n; i++) {
            while (a.get(i) != i + 1) {
                if (a.get(i) <= 0 || a.get(i) >= n) {
                    break;
                }

                if (a.get(i) == a.get(a.get(i))) {
                    break;
                }

                int temp = a.get(i);
                a.set(i, a.get(temp - 1));
                a.set(temp - 1, temp);
            }
        }

        for (int i = 0; i < n; i++) {
            if (a.get(i) != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
