package Math2;
public class EnumeratingGCD {
    public static String solve(String A, String B) {
        if(A.equals(B))
            return A;
        return "1";
    }

    public static void main(String[] args) {
        String A = "1";
        String B = "3";
        System.out.println(solve(A, B));
    }
}
