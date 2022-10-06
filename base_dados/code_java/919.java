import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MicroWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] a = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int count = 1;
        int remaining = n;
        for(int i=0; i<n-1; i++){
            if((int)a[i] == (int)a[i+1]){
                count++;
                continue;
            }
            if((a[i] + k) >= a[i+1]){
                remaining -= count;
            }
            count = 1;
        }
        System.out.println(remaining);
    }
}
