package Math1;

public class Flip {

    public static int[] solve(String A) {
        int[] ans = new int[2];
        int[] arr = new int[A.length()];
        boolean choose = false;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1')
                arr[i] = -1;
            else {
                arr[i] = 1;
                choose = true;
            }
        }
        if (!choose)
            return new int[] {};
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int start = 0;
        int l =0, r =0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                l = start;
                r = i;
            }
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        ans[0] = l+1;
        ans[1] = r+1;
        return ans;
    }

    public static void main(String[] args) {
        String A = "110000111001";
        int[] ans = solve(A);
        for (int val : ans) {
            System.out.println(" " + val);
        }
    }
}
