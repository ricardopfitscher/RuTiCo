import java.awt.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] vertical = new int[n];

        for (int i = 0; i < n; i++) {
            vertical[i] = scanner.nextInt();
        }

        Arrays.sort(vertical);


        ArrayList<Integer> horisontal = new ArrayList<>();
        int amount = 0;
        for (int i = 0; i < m; i++) {
            int x1 = scanner.nextInt(), x2 = scanner.nextInt(), y = scanner.nextInt();
            if (x1 == 1) {
                amount++;
                horisontal.add(x2);
            }
        }

        Collections.sort(horisontal);


        if (amount == 0) {
            System.out.println(0);
            return;
        }


        int minVal = amount, horSize = horisontal.size(), verLen = vertical.length;
        int h = 0, v = 0;

        for (; v < verLen && h < horSize; ) {

           while (h < horSize && horisontal.get(h) < vertical[v]){
               h++;
               amount--;
           }
           minVal = Math.min(minVal, amount + v);

            while (h < horSize && v < verLen && horisontal.get(h) >= vertical[v]){
                minVal = Math.min(minVal, amount + v);
                v++;
            }

        }

        if(horisontal.get(horSize - 1) < 1E9){
            minVal = Math.min(minVal, v);
        }



        System.out.println(minVal);

    }
}
