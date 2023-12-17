package Searching1;
public class BinarySearch {
    public static int solve(int[] A, int B)
    {
        int mid =A.length/2;
        int top =0;
        int end = A.length-1;
        int loc =-1;

        while(top<=end)
        {
            //System.out.println("Searching...");
            if(A[mid] == B)
            {
                loc = mid;
                break;
            }

            else if (A[mid] < B)
            {
                top = mid+1;
                mid = (top+end)/2;
            }

            else
            {
                end = mid-1;
                mid = (top+end)/2;
            }
        }
        return loc;
    }

    public static void main(String[] args)
    {
        int[] A = {1,2,3,4,5};
        int ans = solve(A,1); //0
        System.out.println(ans);

         ans = solve(A,5); //4
        System.out.println(ans);

         ans = solve(A,3); //2
        System.out.println(ans);

         ans = solve(A,2); //1
        System.out.println(ans);

         ans = solve(A,7); //-1
        System.out.println(ans);

         ans = solve(A,0); //-1
        System.out.println(ans);

    }
}
