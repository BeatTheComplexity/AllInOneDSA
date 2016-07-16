package sorting;

public class InsertionSort {
    
    public static int[] insertionsSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int item = arr[i];
            
            while (j > 0 && arr[j-1] > item) {                
                arr[j] = arr[j-1];
                j--;
            }
            
            arr[j] = item;
        }
        
        return arr;
    }
    
    //Insertion sort for Template class array
    public static <T extends Comparable<T>> T[] insertionSortForTClass(T[] arr){
        
        for (int i = 1; i < arr.length; i++) {
            T item = arr[i];
            int indexHole = i;
            
            while (indexHole > 0 && arr[indexHole -1].compareTo(item) > 0) {                
                arr[indexHole] = arr[--indexHole];
            }
            arr[indexHole] = item;
        }
        
        return arr;
    }
    
}
