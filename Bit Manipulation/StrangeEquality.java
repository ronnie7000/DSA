public class StrangeEquality {

    public static int solve(int n) {
        int x = 0, y = 0, pos = 0;
        while (n != 0) {
            if ((n & 1) != 1) {
                x |= 1 << pos;
            }
            n /= 2;
            pos++;
        }
        y = 1 << pos;
        return x ^ y;
    }

    public static void main(String[] args) {
        System.out.println(solve(5));
    }
}
