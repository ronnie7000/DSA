package Searching2;
public class AllocateBooks {

    public static int solve(int[] A, int B) {
        if (A.length < B)
            return -1;
        int l = Integer.MIN_VALUE, r = 0, m = 0;

        for (int val : A) {
            r += val;
            l = val > l ? val : l;
        }
        int ans = 0;
        while (l <= r) {
            m = (l + r) / 2;
            int res = check(A, m, B);
            if (res <= B) {
                r = m - 1;
                ans = m;
            } else
                l = m + 1;
        }
        return ans;
    }

    public static int check(int[] A, int val, int num) {
        int studentCount = 1;
        int sum = 0;
        for (int pages : A) {
            sum += pages;
            if (sum > val) {
                sum = pages;
                studentCount++;
            }
        }
        return studentCount;
    }

    public static void main(String[] args) {
        int[] A = { 73, 58, 30, 72, 44, 78, 23, 9 };
        // int[] A = {12,34,67,90};
        System.out.println(solve(A, 5));
    }
}