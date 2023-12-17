package Searching1;
public class Median {
    public static float solve(int[] A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
        }
        int top = min, end = max, mid = 0;
        float ans = 0;
        int n = A.length;

        if (n % 2 == 1) {
            while (top <= end) {
                mid = (top + end) / 2;
                int count = smallElementCount(mid, A);
                if (count == n / 2) {
                    ans = mid;
                    top = mid + 1;
                } else if (count > n / 2)
                    end = mid - 1;
                else
                    top = mid + 1;
            }
        } else {
            int smalMed = 0, largeMed = 0;

            while (top <= end) {
                mid = (top + end) / 2;
                int count = smallElementCount(mid, A);
                if (count == (n / 2) - 1) {
                    smalMed = mid;
                    top = mid + 1;
                } else if (count > (n / 2) - 1)
                    end = mid - 1;
                else
                    top = mid + 1;
            }

            top = min; end = max; mid = 0;

            while (top <= end) {
                mid = (top + end) / 2;
                int count = smallElementCount(mid, A);
                if (count == (n / 2)) {
                    largeMed = mid;
                    top = mid + 1;
                } else if (count > (n / 2))
                    end = mid - 1;
                else
                    top = mid + 1;
            }

            ans =(float)(smalMed+largeMed)/2;
        }

        return ans;
    }

    public static int smallElementCount(int num, int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < num)
                count++;
        }
        return count;
    }

    public static int largeElementCount(int num, int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > num)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = { 1, 5, 3, 11, 10, 8 };
        System.out.println(solve(A));
    }
}
