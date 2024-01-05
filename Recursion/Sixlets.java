package Recursion;

public class Sixlets {
    
    public static int solve(int[]A, int index, int sum, int B){
        //Base condition
        if (sum > 1000)
        return 0;
        if (B == 0)
        return 1;
        if (index == A.length)
        return 0;
        return solve(A, index + 1, sum, B) + solve(A, index + 1, sum + A[index], B - 1);
    }
    public static void main(String[] args){
        int[]A ={1,2,8};
        int B = 2;
        System.out.println(solve(A,0, 0,B));
    }
}
