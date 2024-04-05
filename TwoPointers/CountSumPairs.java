package TwoPointers;

public class CountSumPairs {
    public static int solve(int[] A, int B) {
        long ans = 0;
        int l = 0, r = A.length - 1;
        while (l < r) {
            int sum = A[l] + A[r];
            if (sum < B)
                l++;
            else if (sum > B)
                r--;
            else {
                if (A[l] == A[r]) {
                    long count = r - l + 1;
                    ans += (count * (count - 1)) / 2;
                    return (int) ans;
                } else {
                    long leftCount = 0, rightCount = 0;
                    int left = A[l], right = A[r];
                    while (A[l] == left) {
                        leftCount++;
                        l++;
                    }
                    while (A[r] == right) {
                        rightCount++;
                        r--;
                    }
                    ans += leftCount * rightCount;
                }
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 8 };
        System.out.println(solve(A, 10));
    }
}
