package searching;

public class BinarySearch {

    public static int binarySearch(int[] arr, int item) {
        int pos = -1;
        int left = 0, right = arr.length - 1, mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (arr[mid] == item) {
                return mid;
            } else if (item < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    public static int binarySearchUsingRecursion(int[] arr, int left, int right, int item) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == item) {
                return mid;
            } else if (item < arr[mid]) {
                return binarySearchUsingRecursion(arr, left, mid - 1, item);
            } else {
                return binarySearchUsingRecursion(arr, mid + 1, right, item);
            }
        } else {
            return -1;
        }
    }
}
