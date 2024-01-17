package Sorting;

public class ReversePair {

    private static int[] A = {2000000000,2000000000,-2000000000};

    public static int mergeSort(int low, int high) {
        int ans = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            ans = mergeSort(low, mid) + mergeSort(mid + 1, high);

            int i = low, j = mid + 1;
            while (i <= mid && j <= high) {
                long val1 = A[i];
                long val2 = A[j];
                if (val1 > val2*2) {
                    ans += mid + 1 - i;
                    j++;
                } else
                    i++;
            }
            merge(low, mid, high);
        }
        return ans;
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
        int i = 0, j = 0, k = low;
        while (k <= high) {
            int a = i < m ? arr1[i] : Integer.MAX_VALUE;
            int b = j < n ? arr2[j] : Integer.MAX_VALUE;
            if (a < b) {
                A[k] = a;
                i++;
            } else {
                A[k] = b;
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
        System.out.println("Count : " + mergeSort(0, getHigh()));
        displayArray();
    }
}
