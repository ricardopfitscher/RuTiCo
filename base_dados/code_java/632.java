import java.util.*;
import java.io.*;
public class Solution{
    
    public static long page(long p,long k){
        
        return (p-1)/k;
        
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        int m = sc.nextInt();
        long k = sc.nextLong();
        long[] p = new long[m];
        long del = 0;
        long nb = 1;
        int op = 0;
        for(int i=0;i<m;i++) p[i] = sc.nextLong();
        for(int i=1;i<m;i++){
            if(page(p[i]-del,k)!=page(p[i-1]-del,k)){
                
                del += nb;
                nb = 1;
                op++;
                
            }else{
                nb++;
                
            }
        }
        if(nb!=0) op++;
        
        System.out.println(op);
        
    }
    
}