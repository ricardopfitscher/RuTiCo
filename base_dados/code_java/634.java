import java.util.Scanner;
public class Tokitsukaze {


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k =sc.nextLong();
        double[]p=new double[m];
        for(int i = 0;i<m;i++){
            p[i]=sc.nextDouble();
        }
        int c=0;
        int used=0;
        for(int i = 0;i<m;){
            long low=(long)((Math.floor(p[i]/k)*k)-i)+1;
            long high=low+k;
            for(int j=i;j<m;j++){
                if(p[j]>=low&&p[i]<=high){
                    i++;
                }
            }
            c++;
        }
        System.out.println(c);

    }
    
}
