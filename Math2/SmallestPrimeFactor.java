package Math2;

public class SmallestPrimeFactor {

    public static void seiveMethod(int A) {
        int[] seive = new int[A + 1];
        int size = seive.length;
        for (int i = 0; i < size; i++) {
            seive[i] = i;
        }
        seive[0] = 0;
        seive[1] = 0;
        for (int i = 2; i <= A; i++) {
            if (seive[i] == i) {
                for (int j = i * i; j < size; j += i) {
                    seive[j] = Math.min(i, seive[j]);
                }
            } else {
                continue;
            }
        }
        for (int i = 2; i <= A; i++) {
            System.out.print(seive[i] + " ");
        }
    }

    public static void main(String[] args) {
        seiveMethod(20);
    }
}
