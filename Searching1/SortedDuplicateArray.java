package Searching1;
public class SortedDuplicateArray {
    public static int solve(int[] A) {
        int n =A.length;
        if(n==1)
            return A[0];
        int top =0, end =n-1, mid =0;
        int ans =0;
        while(top<=end){
            mid = (top+end)/2;
            if(mid ==(n-1))
                return A[n-1];
            if(A[mid] == A[mid+1])
                mid++;
            if(mid%2==1)
                end = mid+1;
            else {
                top =mid-1;
                ans =mid;
            } 
        }
        return A[ans];

        // int ans = 0, n = A.length;
        // int low = 0, high = n-1;
        // while(low <= high){
        //     int mid = (high - low)/2 + low;
        //     if(mid == n - 1) 
        //         return A[n-1];
        //     if(A[mid] == A[mid+1]) 
        //         mid++;
        //     // if all elements with index < mid are occuring twice then mid should be odd
        //     if(mid%2 == 1)
        //         low = mid + 1;
        //     else{
        //         ans = mid;
        //         high = mid - 1;
        //     }
        // }
        // return A[ans];
    }

    public static void main(String[] args) {
        // int[] A = { 2, 2, 7, 7, 5, 5, 8, 9, 9, 11, 11 };
        int[] A = {1,1,2,2,3};
        System.out.println(solve(A));
    }
}
