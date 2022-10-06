import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {
	public static void main (String[] args) {
	PrintWriter pw=new PrintWriter(System.out);
	Scanner sc=new Scanner(System.in);
    long n=sc.nextLong();
    int m=sc.nextInt();
    long k=sc.nextLong();
    Long[] a=new Long[m];
    for(int i=0;i<m;i++)
     a[i]=sc.nextLong();
 long r=0,count=0,k1=k,f=0;   
Arrays.sort(a);
for(int i=0;i<m;i++){
    if(a[i]<=k){
      count++;
     if(f==0){
       r++;
         f=1;
     }
    }
    else{
        f=1;
      k+=count;
      count=0;
      if(a[i]<=k){
        count++;
         r++;
               }
      else{
          k+=((a[i]-k)/k1)*k1;
          if(a[i]>k)
          k+=k1;
          if(a[i]<=k){
           count++;
             r++;
                        }
           }    
    }  

}
   //if(count>0)
   //  r++;
    pw.print(r);
	pw.close(); 
	}
}