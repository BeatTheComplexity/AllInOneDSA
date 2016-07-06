package dynamicprogramming;

import java.util.Arrays;

public class MinNumOfPlatformsRequired {

    /*
        Given arrival and departure times of all trains 
        that reach a railway station,
        find the minimum number of platforms required 
        for the railway station so that no train waits.
        We are given two arrays which represent 
        arrival and departure times of trains that stop
    
        Example:
        Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
                dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
    
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        Output: 3
        There are at-most three trains at a time (time between 11:00 to 11:20)
     */
    public static int findMinNumOfPlatformsRequired(int[] arr, int[] dep) {
        int platformRequired = 0;
        int currentTrain = 0;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                currentTrain++;
                if (platformRequired < currentTrain) {
                    platformRequired = currentTrain;
                }
                i++;
            } else {
                currentTrain--;
                j++;
            }
        }

        return platformRequired;
    }
}
