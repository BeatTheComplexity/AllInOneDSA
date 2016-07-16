package searching;

public class FirstOccurance {

    public static int firstOccurance(int[] arr, int item) {
        int left = 0, right = arr.length - 1, mid;

        while (right - left > 1) {
            mid = left + (right - left) / 2;

            if (arr[mid] >= item) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }
}
