package sorting;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 1, 3, 0, 99};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }   
    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int smallest = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
}
