import java.util.*;
public class Main{
    public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int a[]=new int[n];
    for(int i=0;i<n;i++)
    a[i]=sc.nextInt();
    Arrays.sort(a);
    //boolean 
    int t=1,c=0;
    for(int i=1;i<n;i++){
        if(a[i]==a[i-1])
        {
            if(i-2>=0&&a[i-2]==a[i-1]-1){
                System.out.println("cslnb");
                return;
            }
            c++;
        }
        if(a[i]==a[i-1]&&a[i]==0){
        System.out.println("cslnb");
        return;
        }
    }
    if(c>1)
    {
        System.out.println("cslnb");
        return;
    }
    for(int i=0;i<n;i++){
        if((a[i]-i)%2!=0)
        t=t^1;
    }
    if(t==1)
    System.out.println("cslnb");
    else
    System.out.println("sjfnb");
    
    
    
    }
    
}