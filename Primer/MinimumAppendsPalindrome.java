package Primer;

public class MinimumAppendsPalindrome {
    public static int solve(String A) {
        int count =0;
        int l =0;
        while(l<A.length()){
            boolean res = IsPalindrome(A.substring(l, A.length()));
            if(!res){
                count++;
                l++;
            }
            else
                break;
        }
        return count;  
    }

    public static boolean IsPalindrome(String S){
        int l=0, r=S.length()-1;
        boolean ans =false;
        while(l<=r){
            if(S.charAt(l) == S.charAt(r)){
                l++; r--;
                ans =true;
            }
            else{
                ans =false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // String A = "oqycntornscygodzdctxnhoc";
        String A = "oqycntornscygodzdctxnhoc";
        System.out.println(solve(A));
    }
}
