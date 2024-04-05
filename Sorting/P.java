package Sorting;

public class P {
    
    private static int[] A = {54 ,26 , 93 ,17 ,77 ,31 ,44 ,55 ,20 };

    public static void quickSort(int l, int r){
        if(l<=r){
            int pivot = partition(l, r);
            quickSort(l, pivot-1);
            quickSort(pivot+1, r);
        }
    }

    public static void swap(int l, int r){
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

    public static int partition(int l, int r){
        int p = A[l];
        int p1 = l+1, p2 = r;

        while(p1 <= p2){
            if(p > A[p1])
                p1++;
            else if(p < A[p2])
                p2--;
            else{
                swap(p1, p2);
            }
        }
        swap(l, p2);
        return p2;
    }

    public static void main(String[] args) {
        quickSort(0, A.length-1);
        for(int val : A)
            System.out.println(val);
    }
}
