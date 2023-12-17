package Math1;
public class SortedMatrixSearch {

    public static int solve(int[][] A, int B) {
        int r = 0;
        int c = A[0].length - 1;
        int loc = Integer.MAX_VALUE;
        boolean foundValue = false;
        while ((r < A.length) && (c >= 0)) {
            if (A[r][c] == B) {
                while (c > 0 && A[r][c - 1] == B) {
                    c--;
                }
                return (r + 1) * 1009 + c + 1;
            }
            else if (A[r][c] > B) {
                c--;
            } else {
                r++;
            }
        }
        if (foundValue) {
            return loc;
        }
        return -1;
    }

    public static int solve2(int[][]A, int B){
        int R =A.length, C =A[0].length;
         int top =0, end =(R*C)-1, mid =0;

        while(top<=end){
            mid =(top+end)/2;
            int r =mid/C, c=mid%C;
            if(A[r][c]==B)
                return 1;
            else if(A[r][c]<B)
                top =mid+1;
            else
                end =mid-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // int[][] A = { { 2, 8, 8, 8 }, { 2, 8, 8, 8 }, { 2, 8, 8, 8 } };
        int[][] A = { { 1,3,5,7 }, { 10,11,16,20 }, { 23,30,34,50 } };
        int B = 34;

        System.out.println(solve2(A, B));
    }
}
