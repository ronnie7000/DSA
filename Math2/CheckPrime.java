package Math2;

import java.util.ArrayList;

public class CheckPrime {
    private static ArrayList<Integer> factors = new ArrayList<>();

    public static void solve(int num) {
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    factors.add(i);
                } else {
                    factors.add(i);
                    factors.add(num / i);
                }
            }
        }
    }

    public static void displayFactors() {
        factors.sort((a, b) -> a - b);
        for (int x : factors) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        solve(20);
        displayFactors();
    }
}
