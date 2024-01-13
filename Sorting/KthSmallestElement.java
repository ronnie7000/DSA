package Sorting;

public class KthSmallestElement {

    private static int[] A = {10, 16, 8, 12, 15, 6, 3, 9, 5, 8 };

    // SELECTION SORT
    public static int selectionSolve(int B) {
        for (int i = 0; i < B; i++) {

            int smallPos = i;
            for (int j = i; j < A.length; j++) {
                if (A[j] < A[smallPos])
                    smallPos = j;
            }
            int temp = A[i];
            A[i] = A[smallPos];
            A[smallPos] = temp;
        }
        return A[B - 1];
    }

    // QUICK SELECT
    public static int quickSelect(int low, int high, int k) {

        int pivot = partition(low, high);
        if (pivot == k - 1)
            return A[pivot];
        else if (pivot < k - 1)
            return quickSelect(pivot + 1, high, k);
        else
            return quickSelect(low, pivot - 1, k);
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
            if(i<j)
            swap(i, j);
        }
        swap(j, low);
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

    public static void main(String[] args) {

        int low =0, high = getHigh();
        System.out.println(quickSelect(low, high, 9));
    }
}
