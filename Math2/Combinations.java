package Math2;

public class Combinations {
    
    public static int solve(int A, int B, int C){
        if( A==B || B==0 )
            return 1;
        else{
            long num = fact(A);
            long denom1 = fact(B) % C;
            long denom2 = fact(A-B) % C;
            long ans = ( num / ( denom1 * denom2) ) % C;
            
            return (int)ans;
        }
    }

    public static long fact( int n ){
        if( n == 0 )
            return 1;
        else
            return n * fact(n - 1);
    }

    public static void main(String[] args) {
        int ans = solve( 38, 5, 81 );
        System.out.println(ans);
    }
}
