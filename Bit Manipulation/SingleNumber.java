public class SingleNumber {
    
    public static int solve(int[] A){
        int ans =0;
        for(int i=0;i<A.length;i++){
            ans ^= A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        System.out.println(solve(A));
    }
}
