import java.util.*;
import java.io.*;

public class TwoGram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        HashMap <String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String curr = s.substring(i, i + 2);

            if (hm.containsKey(curr)) {
                hm.put(curr, hm.get(curr) + 1);
            } else {
                hm.put(curr, 1);
            }
        }

        String ans = "";
        int currMax = 0;
        for (String twoGram : hm.keySet()) {
            if (hm.get(twoGram) > currMax) {
                ans = twoGram;
                currMax = hm.get(twoGram);
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
