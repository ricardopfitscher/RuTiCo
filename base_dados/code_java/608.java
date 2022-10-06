import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] v = new int[n];
        int[] ans = new int[n];
        long s = 0;
        int t;
        for(int i=0; i<n;i++) {
            v[i] = in.nextInt();
            s+=v[i];
        }

        for(int i=0; i<n-1;i++) {
            for (int j = i + 1; j < n; j++) {
                if (v[j] > v[i]) {
                    t = v[i];
                    v[i] = v[j];
                    v[j] = t;
                }
            }
        }

        for(int i=0; i<n-1; i++){
            if(v[i] > v[i+1]){
                    ans[i] = v[i]-v[i+1];
            }

            if(v[i] == v[i+1] && v[i]!=1){
                ans[i]=1;
                v[i+1]--;
            }

            if(v[i] < v[i+1]){
                ans[i]=1;
                v[i+1] = v[i]-1;
                if(v[i+1] == 0){
                    v[i+1] = 1;
                }
            }
            if(v[i] == 0 || v[i] == 1){
                ans[i] = 1;
                v[i] = 1;
            }
        }
        if (v[n-1] > 1){
            ans[n-1] = v[n-1];
        }
        else{
            ans[n-1] = 1;
        }

        for (int i=0; i<n; i++){
                s-=ans[i];

        }
        System.out.print(s);


    }
}