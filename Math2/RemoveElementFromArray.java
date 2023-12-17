package Math2;
public class RemoveElementFromArray {
    
    public static int gcd(int A, int B) {
        if (A < B) {
            A = A + B;
            B = A - B;
            A = A - B;
        }

        while (B > 0) {
            A = A % B;
            A = A + B;
            B = A - B;
            A = A - B;
        }
        return A;
    }
    
    public static int solve(int[]A)
    {
        int gcdVal =A[0];
        for(int i=1;i<A.length;i++)
        {
            gcdVal = gcd(gcdVal, A[i]);
        }
        if(gcdVal != 1)
            return -1;
        return 0;
        
    }
    public static void main(String[] args)
    {
        int[] A = {2,4,6};

        System.out.println(solve(A));
    }
}
