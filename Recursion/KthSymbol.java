package Recursion;

public class KthSymbol {
    public static int solveEasy(int A, int B) {
        StringBuilder pattern = drawPattern(A);
        int ans = Character.getNumericValue(pattern.charAt(B));
        return ans;
    }

    public static StringBuilder drawPattern(int A) {
        // Base Case
        if (A == 1)
            return new StringBuilder("0");
        StringBuilder oldPattern = drawPattern(A - 1);
        StringBuilder newPattern = new StringBuilder();
        for (int i = 0; i < oldPattern.length(); i++) {
            if (oldPattern.charAt(i) == '0')
                newPattern.append("01");
            else
                newPattern.append("10");
        }
        return newPattern;
    }

    public static int solveHard(int A, int B) {
        long a = A, b = B;
        int ans = getValue(a, b);
        return ans;
    }

    public static int getValue(long A, long B) {
        // Base Case
        if (B == 0)
            return 0;
        
        if( B%2 ==1){
            return 1- getValue(A-1, B/2);
        }    
        else{
            return getValue(A-1, B/2);
        }    
    }

    public static void main(String[] args) {
        // System.out.println(solveEasy(5, 4));
        System.out.println(getValue(649, 692));
        System.out.println(getValue(3, 1));
    }
}
