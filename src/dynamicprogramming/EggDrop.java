package dynamicprogramming;

public class EggDrop {

    /* Function to get minimum number of trials needed in worst
    case with n eggs and k floors */
    public static int eggDrop(int noOfEggs, int noOfFloors) {

        int n = noOfEggs;
        int k = noOfFloors;

        /*  A 2D table where entery eggFloor[i][j] will represent minimum
            number of trials needed for i eggs and j floors. 
         */
        int arr[][] = new int[noOfEggs + 1][noOfFloors + 1];

        // We need one trial for one floor and 0 trials for 0 floors
        for (int i = 0; i < n; i++) {
            arr[i][0] = 0;
            arr[i][1] = 1;
        }

        // We always need j trials for one egg and j floors.
        for (int j = 0; j < k; j++) {
            arr[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                arr[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x < j; x++) {
                    int res = 1 + Math.max(arr[i - 1][x - 1], arr[i][j - x]);
                    if (res < arr[i][j]) {
                        arr[i][j] = res;
                    }
                }
            }
        }

        return arr[n][k];
    }
}
