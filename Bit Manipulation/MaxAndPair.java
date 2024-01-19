public class MaxAndPair {

    // BRUTE FORCE
    public static int solve(int[] A) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int val = A[i] & A[j];
                ans = ans < val ? val : ans;
            }
        }
        return ans;
    }
    
    // OPTIMIZED SOLUTION
    public static int solve2(int[] A) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int count = countBits((ans | 1 << i), A);
            if (count > 1) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }

    public static int countBits(int pattern, int[] A) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((pattern & A[i]) == pattern)
                count++;
        }
        return count;
    }

    // OPTIMIZED SOLUTION 2
    public static int solve3(int[] A) {
        int ans = 0;

        for (int pos = 31; pos >= 0; pos--) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & (1 << pos)) != 0)
                    count++;
            }
            if (count > 1) {
                ans |= 1 << pos;
                for (int j = 0; j < A.length; j++) {
                    if ((A[j] & (1 << pos)) == 0)
                        A[j] = 0;
                }
            }
        }
        return ans;

        //RETURN THE COUNT OF PAIRS WITH MAXIMUM AND POSSIBLE

        // int pairCount = 0;
        // for(int i=0;i<A.length;i++){
        //     if(A[i]>0)  pairCount++;
        // }

        // return (pairCount * (pairCount-1))/2;
    }

    public static void main(String[] args) {
        int[] A = { 26, 13, 23, 28, 27, 7, 25 };
        System.out.println("Brute Force : " + solve(A));
        System.out.println("Optimized Solution 1 : " + solve2(A));
        System.out.println("Optimized Solution 2 : " + solve3(A));
    }
}
