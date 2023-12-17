package Arrays;
import java.util.Stack;

public class AddOne {
    public static int[] solve(int[] A) {
        Stack<Integer> nums = new Stack<Integer>();
        boolean isCarry = false;

        for (int i = A.length - 1; i >= 0; i--) {
            nums.push(A[i]);
        }
        if (nums.get(0) < 9) {
            // System.out.println(true);
            nums.set(0, nums.get(0) + 1);
            isCarry = false;
        } else {
            nums.set(0, 0);
            isCarry = true;
        }
        for (int i = 1; i < nums.size(); i++) {
            if (isCarry) {
                if (nums.get(i) < 9) {
                    nums.set(i, nums.get(i) + 1);
                    isCarry = false;
                } else {
                    nums.set(i, 0);
                    isCarry = true;
                }
            } else
                break;
        }
        if (isCarry) {
            nums.push(1);
        }
        while (nums.peek() == 0) {
            nums.pop();
        }
        int[] ans = new int[nums.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = nums.get(nums.size() - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 0, 0, 0, 5, 9 };
        int[] ans = solve(A);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
