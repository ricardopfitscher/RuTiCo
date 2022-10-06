

import java.util.Scanner;

public class Fly {

    static double ERROR = 0.0000001;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int m = scanner.nextInt();
        int [] a = new int[n + 1];
        int [] b = new int[n + 1];
        for(int i =0; i< n; i++ ) {
            a[i] = scanner.nextInt();
        }

        for(int i =0; i< n; i++ ) {
            b[i] = scanner.nextInt();
        }
        b[n] = b[0];

        double max =  1000000000;
        double min = 0;
        boolean found = false;
        while (max >= min) {
            double mid = max + min;
             mid /= 2;
             boolean v = isValid(a, b, m, n, mid);
             // System.out.println("For fuel:" + mid + " isValid: " + v + ", max:" + max + ", min:" + min);
             if (v) {
                 max = mid;
             }
             else {
                 min = mid;
             }
             if (max - min <= ERROR && v) {
                 //System.out.println("max: " + max + " , min:" + min);
                 found = true;
                 break;
             }
             if (max ==  min) {
                 break;
             }
        }
        //System.out.println(found);
        if (found) {
            System.out.println(max);
        }
        else System.out.println(-1);
    }


    static boolean isValid(int [] a, int [] b, int m, int n, double fuel) {
        double total =  m + fuel;
        for (int i=0; i<n;i++) {
            double lost = total;
            lost/= a[i];
            total -= lost;

            lost = total;
            lost/=b[i+1];
            total -= lost;
            if ((total-m) < 0) {
                return false;
            }
        }
        if ((total-m) < 0) return false;
        return  true;
    }
}
