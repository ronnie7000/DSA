package Sorting;

import java.util.ArrayList;

public class InversionCount {
    public static long mod = 1000000007;
    public static long count = 0;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static int solve(ArrayList<Integer> A) {
        for (int val : A) {
            list.add(val);
        }
        mergeSort(0, list.size() - 1);
        return (int) count;
    }

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
            arr1[i] = list.get(low + i);
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = list.get(mid + i + 1);
        }

        count += getInversionCount(arr1, arr2);
        count %= mod;

        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            int val1 = i < m ? arr1[i] : Integer.MAX_VALUE;
            int val2 = j < n ? arr2[j] : Integer.MAX_VALUE;
            if (val1 < val2) {
                list.set(low + k, val1);
                i++;
            } else {
                list.set(low + k, val2);
                j++;
            }
            k++;
        }
    }

    public static long getInversionCount(int[] A, int[] B) {
        long ans = 0;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                ans += A.length - i;
                ans %= mod;
                j++;
            } else
                i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inpList = new ArrayList<>();
        inpList.add(3);
        inpList.add(4);
        inpList.add(1);
        inpList.add(2);

        System.out.println(solve(inpList));
    }

}
