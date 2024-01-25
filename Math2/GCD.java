package Math2;

public class GCD {
    public static int solve(int a, int b){
        if( b == 0)
            return a;
        if( a == 0)
            return b;
        if( a > b )
            return solve( a%b, b );
        else
            return solve( b%a, a );
    }

    public static void main(String[] args) {
        System.out.println(solve(6816621,8157697));
    }
}
