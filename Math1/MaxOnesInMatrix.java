package Math1;

public class MaxOnesInMatrix {
    public static int solve(int[][] A) {
        int ans = 0;
        int r = 0, c = A[0].length - 1;
        while (r < A.length && c > -1) {
            if (A[r][c] == 0) {
                r++;
            } else {
                c--;
                ans = r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = { 
                        { 0, 0, 0, 0, 1, 1 },
                        { 0, 0, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1, 1 },
                        { 0, 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 1, 1, 1 }    };
        System.out.println(solve(A));
    }
}
