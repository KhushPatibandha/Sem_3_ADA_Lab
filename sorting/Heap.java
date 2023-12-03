package sorting;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        // int[] arr = {89, 91, 12, 71, 10, 8};
        int[] arr = {9, 2, 4, 1, 3, 0, 99};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        // max heap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) {

            // Swap the root (maximum element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int i) {
        int largest = i; // largest as root
        int leftChild = 2 * i; 
        int rightChild = 2 * i + 1; 

        // left child moto then root
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // left child moto then root
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // large root nathi
        if (largest != i) {
            // sawp
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }  
}
