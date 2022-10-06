import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cheast {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        l[0] = sc.nextInt();
        int x=1;
        int c=1;
        for (int i=1;i<n;i++) {
            l[i] = sc.nextInt();
            if (l[i] <= l[i-1]*2) {
                c++;
                x = Math.max(x,c);
            }
            else
                c = 1;
        }
        System.out.println(x);



    }
}
