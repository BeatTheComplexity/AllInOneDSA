package sorting;

public class QuickSort {

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }
    
    private static int[] quickSort(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[(left + (right - left)/2)];
        
        while (i < j) {            
            while (arr[i] < pivot) {                
                i++;
            }
            
            while (arr[j] > pivot) {                
                j--;
            }
            
            if (i < j) {
                arr = swap(arr,i,j);
                i++;
                j--;
            }
        }
        
        if (left < j) {
            return quickSort(arr, left, j);
        }
        if (i < right) {
            return quickSort(arr, i, right);
        }
        
        return arr;
    }
    
    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return arr;
    }

    //Quick sort for Template class array
    public static <T extends Comparable<T>> T[] quickSortForTClass(T[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> T[] quickSort(T[] arr, int left, int right) {
        if (left < right) {
            int pivot = partation(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
        return arr;
    }

    private static <T extends Comparable<T>> int partation(T[] arr, int left, int right) {
        T pivot = arr[right];
        int mid = left;
        for (int i = mid; i < right; i++) {
            if ((arr[i]).compareTo(pivot) <= 0) {
                swap(arr, i, mid++);
            }
        }
        swap(arr, right, mid);
        return mid;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        if (a != b) {
            T temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
