public class SingleNumber3 {
    public static int[] solve(int[] A) {

        int a = 0, b = 0;
        for (int i = 0; i < 31; i++) {
            int oddXOR = 0;
            int eveXOR = 0;

            for (int j = 0; j < A.length; j++) {
                int temp = A[j] >> i;
                if ((temp & 1) == 0) {
                    eveXOR ^= A[j];
                } else {
                    oddXOR ^= A[j];
                }

            }
            if (oddXOR == 0 || eveXOR == 0) {
                continue;
            } else {
                a = Math.min(oddXOR, eveXOR);
                b = Math.max(oddXOR, eveXOR);
                break;
            }
        }
        return new int[] { a, b };

    }

    public static void main(String[] args) {
        int[] A = { 186, 256, 102, 377, 186, 377 };
        int[] ans = solve(A);

        System.out.println(ans[0] + " " + ans[1]);
    }
}
