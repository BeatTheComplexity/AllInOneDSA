package arrayoperations;

public class PrintPairsWithSumN {

    /*
        The below method is only good if range is known
        the time complexity will be O(n)
        but will use an extra space of O(1000)
     */
    private static final int MAX = 1000;

    public static void printPairsIfRangeKnown(int[] arr, int sum) {
        boolean[] binmap = new boolean[MAX];

        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];

            if (diff > 0 && binmap[diff]) {
                System.out.println("Pair with given sum "
                        + sum + " is (" + arr[i]
                        + ", " + diff + ")");
            }

            binmap[arr[i]] = true;
        }
    }

    /*
        To run the above method, paste below code in void main
    
        PrintPairsWithSumN.printPairsIfRangeKnown(new int[]{1, 3, 5, 7, 9}, 10);
     */
}
