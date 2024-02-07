package Math2;

public class SortedPermutationRank {
    private static int mod = 1000003;

    public static int solve(String A) {
        int ans = 0;
        for (int i = 0; i < A.length(); i++) {
            String str = A.substring(i, A.length());
            int count = getSmallCount(str);
            ans += (count * fact(str.length() - 1)) % mod;
        }
        return (ans + 1) % mod;
    }

    public static int fact(int num) {
        if (num == 0 || num == 1)
            return 1;
        return (num * fact(num - 1)) % mod;
    }

    public static int getSmallCount(String str) {
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < str.charAt(0))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String S = "DTNGJPURFHYEW";
        System.out.println(solve(S));
    }
}
