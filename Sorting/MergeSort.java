package Sorting;

public class MergeSort {

    private static int[] A = { 10, 16, 8, 12, 15, 6, 3, 9, 5, 8 };
    // private static int[] A = { 6, 5, 4, 3, 2, 1 };

    public static void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {
        int m = mid - low + 1;
        int n = high - mid;
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = A[low + i];
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = A[mid + i + 1];
        }
        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            int val1 = i < m ? arr1[i] : Integer.MAX_VALUE;
            int val2 = j < n ? arr2[j] : Integer.MAX_VALUE;
            if (val1 < val2) {
                A[low + k] = val1;
                i++;
            } else {
                A[low + k] = val2;
                j++;
            }
            k++;
        }
    }

    public static int getHigh() {
        return A.length - 1;
    }

    public static void displayArray() {
        for (int i : A) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        mergeSort(0, getHigh());
        displayArray();
    }
}