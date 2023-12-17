package Primer;
public class StringSequence {
    public static int solve(String A) {
        int size = A.length();
        int[] pre = new int[size];
        int[] suf = new int[size];
        int li = Integer.MIN_VALUE + size;
        int ri = Integer.MAX_VALUE - size;
        int currDist = 0, dist = Integer.MAX_VALUE - size;
        for (int i = 0; i < pre.length; i++) {
            if (A.charAt(i) == 'x') {
                li = i;
            }
            pre[i] = li;
        }
        for (int i = suf.length - 1; i >= 0; i--) {
            if (A.charAt(i) == 'x') {
                ri = i;
            }
            suf[i] = ri;
        }
        for (int i = 0; i < size; i++) {
            if (A.charAt(i) == 'o') {
                currDist = Math.min(Math.abs((pre[i] - i)), Math.abs((suf[i] - i)));
                dist = Math.min(dist, currDist);
            }
        }
        return dist>size ? -1 : dist;
    }

    public static void main(String[] args) {
        String A = "o..o.xx.ooo.x.o.o";
        System.out.println(solve(A));

    }
}
