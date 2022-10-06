import java.util.Scanner;;
public class JavaApplication2 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n= sc.nextInt();
        int li[]=new int[n];
        for(int i = 0 ;i<n;i++){
            li[i]=sc.nextInt();
        }
        int max=0;
         int c=0;
        for(int i = 0;i<n;i++){
           c=0;
            for(int j=i;j<n;j++){
                if(j!=n-1&&j!=0&&li[j]-li[j-1]==1&&li[j+1]-li[j]==1){
                    c++;
                    i++;
                }
                else if(j!=n-1&&j==0&&li[j+1]-li[j]==1&&li[j]==1){
                    c++;
                    i++;
                }
                else if(j==n-1&&j!=0&&li[j]-li[j-1]==1&&li[j]==1000){
                    c++;
                    i++;
                }
                else{ break;}
            }
            if(c>max){
                max=c;
            }
        }
        if(c>max){
                max=c;
            }
        System.out.println(max);
        
       
    }
    
}
