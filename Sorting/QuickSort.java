package Sorting;

public class QuickSort {

    private static int[] A = { 10, 16, 8, 12, 15, 6, 3, 9, 5, 8 };

    public static void quickSort(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    public static int partition(int low, int high) {
        int pivot = A[low];
        int i = low, j = high + 1;
        while (i < j) {
            do {
                i++;
            } while (A[i] <= pivot);
            do {
                j--;
            } while (A[j] > pivot);

            if (i < j)
                swap(i, j);
        }
        swap(low, j);
        return j;
    }

    public static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
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
        int low = 0, high = getHigh();
        quickSort(low, high);
        displayArray();
    }
}
