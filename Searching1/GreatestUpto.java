package Searching1;

public class GreatestUpto {
    public static int solve(int[] A, int B) {
        int mid = A.length / 2;
        int top = 0;
        int end = A.length - 1;
        int loc = -1;

        while (top <= end) {
            if (A[mid] == B) {
                loc = mid;
                break;
            }

            else if (A[mid] < B) {

                loc = mid;
                top = mid + 1;
                mid = (top + end) / 2;
            }

            else {
                end = mid - 1;
                mid = (top + end) / 2;
            }
        }
        return loc;
    }

    public static int solve2(int[] A, int B) {
        int res = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                res = A[i];
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = { 2, 4, 6, 8, 10 };
        int ans = solve2(A, 1); // 0
        System.out.println(ans);

        ans = solve2(A, 5); // 4
        System.out.println(ans);

        ans = solve2(A, 3); // 2
        System.out.println(ans);

        ans = solve2(A, 2); // 1
        System.out.println(ans);

        ans = solve2(A, 7); // 6
        System.out.println(ans);

        ans = solve2(A, 0); // -1
        System.out.println(ans);

        ans = solve2(A, 9); // 3
        System.out.println(ans);
    }
}
