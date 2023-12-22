package Math1;

public class EquilibriumCount {

    public static int solve(int[]A){
        long[] preSum = new long[A.length];
        preSum[0] = A[0];
        for(int i=1;i<A.length;i++){
            preSum[i] = preSum[i-1] + A[i]; 
        }
        int count =0;
        int n=A.length-1;
        for(int i=0;i<A.length;i++){
            long left = 0, right =0;
            if(i==0){
                left =0;
                right = preSum[n]-preSum[i];
            }
            else if(i==n){
                left =preSum[i-1];
                right =0;
            }
            else{
                left=preSum[i-1];
                right =preSum[n] - preSum[i];
            }
            if(left == right)
                count =i;
        }
        return count;
    }
    public static void main(String[]args){
        int[]A = {1,2,3,7,1,2,3};
        System.out.println(solve(A));
    }
}
