package Searching1;
public class StaircaseHeight {
    public static int solve(int A){
        int top =1, end =A, mid =0, ans =0;
        while(top<=end){
            mid = (end+top)/2;

            long temp =(long)mid * (mid + 1) / 2;

            if(temp<=A)
            {
                ans =mid;
                top =mid+1;
            }
            else
                end =mid-1;
        }
        return ans;
    }

    public static void main(String[]a){
        System.out.println(solve(92761));
    }
}
