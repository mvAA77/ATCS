import java.util.Arrays;
import java.util.Random;

public class ArrayPerformanceAnalysis {
    
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }
    
    public static int[] copyArray(int[] original) {
        return Arrays.copyOf(original, original.length);
    }
    
    public static void main(String[] args) {
        int[] sizes = new int[10];
        for (int i = 0; i < 10; i++) {
            sizes[i] = (i + 1) * 10000;
        }
        
        long[] bubbleSortTimes = new long[10];
        long[] quickSortTimes = new long[10];
        
        System.out.println("Array Size\tBubble Sort (ns)\tQuick Sort (ns)");
        System.out.println("---------------------------------------------------");
        
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            
            int[] originalArray = generateRandomArray(size);
            
            int[] bubbleArray = copyArray(originalArray);
            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long endTime = System.nanoTime();
            bubbleSortTimes[i] = endTime - startTime;
            
            int[] quickArray = copyArray(originalArray);
            startTime = System.nanoTime();
            quickSort(quickArray);
            endTime = System.nanoTime();
            quickSortTimes[i] = endTime - startTime;
            
            System.out.printf("%,d\t\t%,d\t\t%,d\n", 
                            size, bubbleSortTimes[i], quickSortTimes[i]);
        }
        
    }
}