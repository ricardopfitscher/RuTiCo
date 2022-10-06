import java.util.*;
public class Main {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[] game=new int[n];
        int[] bill=new int[m];
        for (int i = 0; i <n ; i++) {
            game[i]=scan.nextInt();
        }
        for (int i = 0; i <m ; i++) {
            bill[i]=scan.nextInt();
        }
        int i=0;
        int j=0;
        int ans=0;
        while (i<m){
            boolean f=true;
            for (int k = j; k <n ; k++) {
                if (bill[i]>=game[k]){
                    ans++;
                    i++;
                    j=k+1;
                    f=false;
                    break;
                }
            }
            if (f){
                break;
            }
        }
        System.out.println(ans);
    }
}


