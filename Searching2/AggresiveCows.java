package Searching2;
import java.util.Arrays;

public class AggresiveCows {
    public static int solve(int[] barns, int cows) {
        int ans = 0;
        Arrays.sort(barns);
        if (cows == 0 || barns.length == 0 || cows > barns.length)
            return 0;
        if (cows == 1)
            return 1;
        int top = 0, end = barns[barns.length-1], mid = 0;
        while (top <= end) {
            mid = (top + end) / 2;
            if (possibleDistance(mid, barns, cows)) {
                ans = mid;
                top = mid + 1;
            } else
                end = mid - 1;
        }
        return ans;
    }

    public static boolean possibleDistance(int dist, int[] barns, int cows) {
        int index = 1;
        int prev_pos = barns[0];
        cows--;
        while (cows > 0 && index < barns.length) {
            if (barns[index] < prev_pos + dist) {
                index++;
                continue;
            } else {
                prev_pos = barns[index];
                index++;
                cows--;
            }
        }
        if (cows == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] A = { 5,17,100,11};
        int B = 2;
        System.out.println(solve(A, B));
    }
}
