    package Math1;

public class RangeSumQuery {

    public static long[] rangeSum(int[]A, int[][]B){
        int m = B.length;
        long[] res = new long[m];
        long[] preSum = new long[A.length];
        preSum[0] =A[0];
        for(int i=1;i<A.length;i++){
            preSum[i] = preSum[i-1]+A[i];
        }

        for(int i=0;i<m;i++){
            int l=B[i][0], r=B[i][1];
            res[i] = solve(preSum,l,r);
        }
        return res;
    }

    public static long solve(long[] preSum, int l, int r){
        if(l==0)   return preSum[r];
        return (preSum[r] - preSum[l-1]); 
    }

    public static void main(String[]args){
        int[] A = {1, 2, 3, 4, 5};
        int[][]M = {{0, 3}, {1, 2}};
        long[] res = rangeSum(A,M);
        for(long val:res){
            System.out.println(val+" ");
        }
    }
}
