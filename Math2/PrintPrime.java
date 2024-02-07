package Math2;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintPrime {
    private static ArrayList<Integer> prime = new ArrayList<>();

    public static void bruteForce(int A) {
        for (int num = 2; num <= A; num++) {
            int count = 2;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    count++;
                    break;
                }
            }
            if (count == 2)
                prime.add(num);
        }
    }

    public static void seiveMethod(int A) {
        prime.clear();
        int[] seive = new int[A + 1];
        Arrays.fill(seive, 1);
        seive[0] = 0;
        seive[1] = 0;
        int size = seive.length;

        for (int i = 2; i * i <= A; i++) {
            if (seive[i] == 1) {
                for (int j = i * i; j < size; j += i) {
                    seive[j]++;
                }
            } else {
                continue;
            }
        }

        for (int i = 0; i < size; i++) {
            if (seive[i] == 1) {
                prime.add(i);
            }
        }
    }

    public static void displayPrimeNumbers() {
        prime.sort((a, b) -> a - b);
        for (int x : prime) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        bruteForce(10);
        displayPrimeNumbers();
        System.out.println();
        seiveMethod(10);
        displayPrimeNumbers();
    }
}
