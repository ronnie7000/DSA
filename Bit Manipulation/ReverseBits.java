public class ReverseBits {
    public static long solve(int a)
    {
        long res = 0;
	    
	    for(int i=0; i< 32; i++){
	        res <<=1;
	        if(((a>>i)&1) == 1){
	            res |= 1;
	        }
	    }
	    return res;
    }

    public static void main(String[] args)
    {
        System.out.println(solve(3));
    }
}
