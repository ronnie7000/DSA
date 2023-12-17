package Math1;
public class MaxChunks {
    public static int solve(int[] A) {
        int count = 1;
        int size = A.length;
        int[] maxLeft = new int[size];
        int[] minRight = new int[size];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            if (A[i] > max) {
                maxLeft[i] = A[i];
            } else {
                maxLeft[i] = max;
            }
            max = maxLeft[i];
        }

        minRight[size - 1] = min;

        for (int i = size - 2; i >= 0; i--) {
            if (A[i + 1] < min) {
                minRight[i] = A[i + 1];
            } else {
                minRight[i] = min;
            }
            min = minRight[i];
        }

        for (int i = 0; i < size; i++) {
            if (maxLeft[i] < minRight[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = { 2, 0, 1, 2 };

        int ans = solve(A);
        System.out.println(ans);
    }
}
