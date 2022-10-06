import java.io.*;
import java.lang.*;
public class CF1003E{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int d = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        StringBuffer sb = new StringBuffer();
        int[] rem = new int[n];
        int[] deg = new int[n];
        int i = 0;
        if(k == 1){
            if(n <= 2){

            }else{
                System.out.println("NO");
                return;
            }
        }
        for(i=0;i<d;i++){
            if(i>=n-1){
                System.out.println("NO");
                return;
            }
            sb.append((i+1) +" " + (i+2)+"\n");
            rem[i] = Math.min(i, d-i);
            deg[i]++;
            if(i+1<n)
            deg[i+1]++;
        }
        if(i<n){
            rem[i] = 0;
            deg[i] = 1;
        }
        i++;
        int j  = 0;
        for(;i<n;i++){
            //For all remaining Nodes
            while(true){
                if(j>=n){
                    System.out.println("NO");
                    return;
                }
                if(rem[j] > 0 && deg[j]<k){
                    deg[j]++;
                    rem[i] = rem[j] - 1;
                    sb.append((j+1)+" "+(i+1)+"\n");
                    deg[i]++;
                    break;
                }else{
                    j++;
                }
            }
        }
        System.out.println("YES");
        System.out.println(sb);
    }
}
