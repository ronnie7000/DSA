package Math2;
public class MooreVoting {

    public static int solve(int[] A) {
        int size = A.length;
        int me = A[0];
        int count = 1;

        for (int i = 1; i < size; i++) {
            if (me == A[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    me = A[i];
                    count = 1;
                }
            }
        }
        int totalCount = 0;
        for (int i = 0; i < size; i++) {
            if (A[i] == me)
                totalCount++;
        }

        if (totalCount > size / 2)
            return me;
        return -1;
    }

    public static void main(String[] args) {
        int[] A = { 2, 2, 3, 3, 2, 3 };
        int ans = solve(A);
        System.out.println(ans);
    }
}
