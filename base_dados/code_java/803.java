import java.io.*;
import java.util.*;
public class Main{
public static void main(String[] args){
 Scanner s= new Scanner(System.in);
 int n=s.nextInt();StringBuilder sb=new StringBuilder();
 long[] a=new long[n/2];
 for(int i=0;i<n/2;i++){
                  a[i]=s.nextLong();
 }int j=0;long[] a2=new long[n/2];long[] a1=new long[n/2];
 a1[j]=a[a.length-1]/2;
 a2[j]=a[a.length-1]-a[a.length-1]/2;
 for(int i=(n-1)/2-1;i>=0;i--){
 //    a1[j]=a[i]/2;a2[j++]=a[i]-a[i]/2;
    long n1=a1[j];
    if((a[i]-n1)<a2[j]){
      a2[j+1]=a2[j++];a1[j]=a[i]-a2[j];                      
     }else{a1[++j]=n1;a2[j]=a[i]-n1;}
 }int k=0;//int[] ans=new int[2*n];
 for(int i=(n-1)/2;i>=0;i--)
   sb.append(a1[i]+" ");
  for(int i=0;i<n/2;i++)
    sb.append(a2[i]+" ");
            System.out.println(sb.toString());     
}
}