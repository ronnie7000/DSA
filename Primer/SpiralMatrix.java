package Primer;
public class SpiralMatrix {
    public static int[][] solve(int a) {
        int[][] ans = new int[a][a];
        int num = 1;
        int row1 = 0, row2 = a - 1;
        int col1 = 0, col2 = a - 1;

        while (num <= a * a) {
            for (int i = col1; i <= col2; i++) {
                ans[row1][i] = num;
                num++;
            }
            for (int i = row1 + 1; i <= row2; i++) {
                ans[i][col2] = num;
                num++;
            }
            for (int i = col2 - 1; i >= col1; i--) {
                ans[row2][i] = num;
                num++;
            }
            for (int i = row2 - 1; i > row1; i--) {
                ans[i][col1] = num;
                num++;
            }
            row1++;
            row2--;
            col1++;
            col2--;
        }
        return ans;
    }

    
    public static void printBoundary(int[][]mat, int r, int c, int n){
        for(int i=1;i<n;i++){
            System.out.print(mat[r][c]);
            c++;
        }
        for(int i=1;i<n;i++){
            System.out.print(mat[r][c]);
            r++;
        }
        for(int i=1;i<n;i++){
            System.out.print(mat[r][c]);
            c--;
        }
        for(int i=1;i<n;i++){
            System.out.print(mat[r][c]);
            r--;
        }
        if(n==1)    System.out.println(mat[r][c]);  
    }
    
    public static void solve2(int n){
        int [][] mat = new int[n][n];
        int num=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = num;
                num++;
            }
        }
        int r=0, c=0;
        while(n>0){
            printBoundary(mat, r, c, n);
            r++; c++; 
            n-=2;
        } 
    }

    public static void main(String[] args) {
        //int[][] ans = solve(5);
        // for (int i = 0; i < ans[0].length; i++) {
        //     for (int j = 0; j < ans.length; j++) {
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        solve2(3);
    }
}
