package TwoPointers;

public class ClosestPair {
    public static int[] solve(int[]A, int[]B, int C){
        int sizeA = A.length;
        int sizeB = B.length;
        int p1 = 0, p2 = sizeB-1;
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while(p1 < sizeA && p2 > -1){
            int diff = Math.abs(A[p1] + B[p2] - C);
            if(diff < ans){
                ans = diff;
                left = p1;
                right = p2;
            }
            if(diff < C){
                p1++;
            }
            else{
                p2--;
            }
        }
        int[] res = {A[left], A[right]};
        return res;
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] B = {2,4,6,8};
        int[] ans = solve(A, B, 9);
        
    }
}
