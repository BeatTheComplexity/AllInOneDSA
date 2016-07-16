package searching;

public class LastOccurance {

    public static int lastOccurance(int[] arr, int item) {
        int left = 0, right = arr.length, mid;

        while (right - left > 1) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= item) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
