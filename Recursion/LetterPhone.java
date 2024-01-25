package Recursion;

import java.util.ArrayList;

public class LetterPhone {
    private static String[][] dict = new String[][] { { "0" }, { "1" }, { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" },
            { "j", "k", "l" }, { "m", "n", "o" }, { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };

    private static ArrayList<String> results = new ArrayList<String>();

    public static ArrayList<String> letterCombinations(String A){
        solve(0, A, "");
        return results;
    }

    public static void solve(int index, String A, String ans){
        //Base Condition
        if(index == A.length()){
            results.add(ans);
            return;
        }

        int num = Character.getNumericValue(A.charAt(index));
        for(int i =0;i < dict[num].length; i++){
            solve(index+1, A, ans+dict[num][i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> answer = letterCombinations("23");
        for(String str : answer){
            System.out.println(str);
        }
    }





}
