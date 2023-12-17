package Searching2;
public class SmallestGoodBase {
    public static int solve(int num){
        if(num<3)  return 0;
        int ans =0;
        int top=1, end =num-1, mid=0;
        while(top<=end){
            mid =(top+end)/2;
            if(check(mid, num)){
                ans =mid;
                end =mid-1;
            }
            else    
                end =mid-1;
        }
        return ans;
    }

    public static boolean check(int a, int num){
        int temp =0;
        int index=0;
        while(temp<=num){
            temp += (int)Math.pow(a, index);
            index++;
        }
        if(temp==num)
            return true;
        return false;
    }
    public static void main(String[]args){
        System.out.println(solve(13));
    }
}
