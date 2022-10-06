import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else {
                map.replace(x, map.get(x) + 1);
            }
        }
        int[] power = new int[31];
        for (int i = 0; i < 31; i++) {
            power[i] = 1 << i; // 0 100=4 1000=8 10000=16
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
        boolean f = false;
        for (int j = 0; j <= 30; j++) {
        int check = power[j] - arr[i];
                if ((map.containsKey(check) && check != arr[i])) {
                f = true; break;}
                if((map.containsKey(check) && check == arr[i] && map.get(check) >=2)) {
                    f = true; break;
                }
            }
            if (!f) {
                c++;
            }
        }
        System.out.println(c);
    }
}