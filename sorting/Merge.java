package sorting;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 1, 3, 0, 99};
        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    private static void divide(int[] arr, int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conqure(arr, si, mid, ei);
    }
    private static void conqure(int arr[], int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];
        int x = 0;
        int idx1 = si;
        int idx2 = mid + 1;
        
        while(idx1 <= mid && idx2 <= ei) {
            if(arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }
        
        while(idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while(idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        for(int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
}
