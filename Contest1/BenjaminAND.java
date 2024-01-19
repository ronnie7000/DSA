package Contest1;

public class BenjaminAND {
    public static int[] solve(int[]A, int[]B){
        int [] ans = new int[B.length];
        
        for(int i=0;i<B.length;i++){
            int pos = B[i];
            int setBits = 0;
            
            for(int num : A){
                if( (num & (1<<pos)) != 0){
                    setBits++;
                }
            }
            long val = (setBits * (setBits - 1))/2;
            ans[i] = (int)val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] A = {28,7,3,6,23,16,5,29,23};
        int[] B = {5,0,1};

        int[] ans = solve(A, B);

        for(int a : ans){
            System.out.println(a);
        }
    }
}
