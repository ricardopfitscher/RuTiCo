import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main (String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String parameterStringList[] = reader.readLine().split(" ");
            int x = Integer.parseInt(parameterStringList[0]);
            int y = Integer.parseInt(parameterStringList[1]);
            int z = Integer.parseInt(parameterStringList[2]);
            int t1 = Integer.parseInt(parameterStringList[3]);
            int t2 = Integer.parseInt(parameterStringList[4]);
            int t3 = Integer.parseInt(parameterStringList[5]);

            int T1 = Math.abs(x-y) * t1;
            int T2 = Math.abs(x-z) * t2 + 3*t3 + Math.abs(x-y) * t2;

            if(T2 <= T1) System.out.println("YES");
            else System.out.println("NO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}