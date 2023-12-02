package searching;

import java.util.Arrays;

public class IthOrderStatistic {
    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 1, 3, 0, 99};
        System.out.println(ithOrderStatistic(arr, 10));
    }
    private static int ithOrderStatistic(int[] arr, int target) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++) {
            if(i == target - 1) {
                return arr[i];
            }
        }
        return -1;
    }
    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivotIdx = partition(arr, low, high);
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }
}
