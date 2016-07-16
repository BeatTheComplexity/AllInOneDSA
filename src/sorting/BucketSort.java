package sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    private final static int DEFAULT_BUCKET_SIZE = 5;
    
    public static Integer[] sort(Integer[] arr){
        return sort(arr, DEFAULT_BUCKET_SIZE);
    }

    private static Integer[] sort(Integer[] arr, int bucketSize) {
        if (arr.length == 0) {
            return arr;
        }
        
        //Determine min and max values
        int minValue = arr[0];
        int maxValue = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < minValue){
                minValue = arr[i];
            } else if (arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        
        //Initailise buckets
        int bucketCount = (maxValue - minValue)/bucketSize + 1;
        
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        
        //Distribute input array alues into bucket
        for (int i = 0; i < arr.length; i++) {
            buckets.get((arr[i] - minValue) / bucketSize).add(arr[i]);
        }
        
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            InsertionSort.insertionSortForTClass(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                arr[currentIndex++] = bucketArray[j];
            }
        }
        
        return arr;
    }
}
