package Arrays;

public class MultipleQuerries {

    public static int[] solve1(int A, int[][] Q) {
        int[] res = new int[A];
        for (int i = 0; i < Q.length; i++) {
            int index = Q[i][0];
            int value = Q[i][1];
            res[index] = res[index] + value;
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

    public static int[] solve2(int A, int[][] Q) {
        int[] res = new int[A];
        for (int i = 0; i < Q.length; i++) {
            int start = Q[i][0]-1;
            int end = Q[i][1]-1;
            int value = Q[i][2];
            res[start] = res[start] + value;
            if(end<A-1)
                res[end + 1] = res[end + 1] - value;
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] Q1 = { { 1, 3 }, { 4, 2 }, { 3, 1 } };
        int[][] Q2 = {{1,2,10},{2,3,20},{2,5,25}};
        int[] res1 = solve1(A, Q1);
        int[] res2 = solve2(A, Q2);
        for (int val : res1) {
            System.out.print(" " + val);
        }
        System.out.println();
        for (int val : res2) {
            System.out.print(" " + val);
        }
    }
}
