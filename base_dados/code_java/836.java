
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] P = new int[n];
        int[] check=new int[n];
        for (int i = 1; i < n; i++) {

            P[i] = scanner.nextInt();
            P[i]--;
            check[P[i]]++;
        }
        int[] leaves = new int[n];


        for (int i=0;i<n;i++) {
            if(check[i]==0){
                leaves[P[i]]++;
            }
        }


        for (int i = 0; i < n; i++) {

            if (check[i]>0&&leaves[i]<3) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
