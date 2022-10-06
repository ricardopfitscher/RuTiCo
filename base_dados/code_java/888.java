import java.util.Scanner;
public class JavaApplication7 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        long sum=0;
        long []d=new long[n];
        long[]ds=new long[n];
        for(int i =0;i<n;i++){
            d[i]=sc.nextLong();
            sum+=d[i];
            ds[i]=sum;
        }
        long[]le=new long[m];
        for(int i =0;i<m;i++){
            le[i]=sc.nextLong();
        }
        int l=0;
        int h=n;
        int k=(h-l)/2;
        k+=l;
        for(int i=0;i<m;i++){
        l=0;
        h=n;
        k=(h-l)/2;
        k+=l;
            for(;l<=h;){
                k=(h-l)/2;
                k+=l;
                if(ds[k]<le[i]){
                    l=k+1;
                }
                else if(ds[k]==le[i]){break;}
                else{
                    h=k-1;
                }
            }
            //System.out.println(k);
            if(ds[k]<le[i]){
                    k++;
                }
          if(k==0){
              System.out.println((int)(k+1)+" "+le[i]);
           }
            else{
                System.out.println((int)(k+1)+" "+(long)(le[i]-ds[k-1]));
           }
        }
        
    }
    
}
