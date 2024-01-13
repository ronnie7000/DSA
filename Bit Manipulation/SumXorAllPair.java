public class SumXorAllPair {
    public static int solve(int[]A){
        long ans =0;
        for(int pos =0;pos<32;pos++){
            long setCount =0;
            long unsetCount =0;

            for(int i=0;i<A.length;i++){
                if(((A[i]>>pos)&1) ==1)
                    setCount++;
                else
                    unsetCount++;
            }
            ans += (setCount*unsetCount)*(1<<pos);
        }
        ans = ans % 1000000007;
        return (int) ans;
    }

    public static void main(String[] args) {
        int[]A = {3,4,2};
        System.out.println(solve(A));
    }
}
