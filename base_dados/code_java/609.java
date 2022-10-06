
import java.util.*;

public class Main {

    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       int m = s.nextInt();
       m = 0;
       long sum = 0;
       int[] expon = new int[n];
        for (int i = 0; i < n; i++) {
            expon[i] = s.nextInt();
            m = Math.max(expon[i], m);
            sum += expon[i];
        }
        HashSet<Integer> levels = new HashSet<>();


        int amount = 0;
        for (int i = 0; i < n; i++) {
            int currentHigh = expon[i];
            for (int j = currentHigh; j >= 1; j--) {
                if(!levels.contains(j)) {
                    levels.add(j);
                    amount++;
                    break;
                }
                if(j == 1){
                    amount++;
                }
            }
        }
        System.out.println((sum - amount) - (m - levels.size()));
    }
}