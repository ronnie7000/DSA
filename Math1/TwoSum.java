package Math1;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static int[] solve(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    public static int[] solve2(int[]A, int target)
    {
        Set<Integer> seenValues = new HashSet<Integer>();
        int[] ans = new int[2];
        seenValues.add(A[0]);

        for(int i=1;i<A.length;i++)
        {
            if(seenValues.contains(target-A[i]))
            {
                ans[0] = A[i];
                ans[1] = target-A[i];
                return ans;
            }
            seenValues.add(A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 2, 7, 11, 15 };
        int[] ans = solve2(a, 9);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
