import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Codeforces {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 == 0){
                arr[i]--;
            }
        }
        for(int i = 0; i < n; i++){
            pw.print(arr[i] + " ");
        }
        pw.flush();
        pw.close();
    }
}