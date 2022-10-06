import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int [] a= new int[n];
        int k=0;
        int m=0;
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if (a[i]>=0){
                a[i]=-a[i]-1;
            }
            if (a[i]<m){
                m=a[i];
                k=i;
            }
        }
        if (n%2==1){
            a[k]=-a[k]-1;
        }
        for (int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
