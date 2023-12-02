package searching;

public class Linear {
    public static void main(String[] args) {
        int[] arr = {9, 2, 4, 1, 3, 0, 99};
        System.out.println("Element found at index: "+ linearSearch(arr, 9));
    }
    public static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
