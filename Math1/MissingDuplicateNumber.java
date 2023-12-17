package Math1;
public class MissingDuplicateNumber {
    
    public static int[] solve(int []A)
    {
        int[] a = new int[A.length+1];
        long n = A.length;
        long sum =0;
        long missing =0;
        long duplicate =-1;

        for(int i=0;i<n;i++)
        {
            sum += A[i];
            if(duplicate != -1)
            {
                continue;
            }
            else if(a[A[i]] == -1)
            {
                duplicate = A[i];
            }
            else{
                a[A[i]] = -1;
            }
        }

        missing = (n*(n+1)/2) - (sum - duplicate);

        return new int[]{(int)duplicate, (int)missing};
    }
    
    public static void main(String [] args)
    {
        int[] A = {3,1,2,5,3};
        int[] ans = solve(A);

        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
    }
}
