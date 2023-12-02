package sorting;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 1, 3, 0, 99};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }   
    private static void bubbleSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
