

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class NastyaWardrobe {
    static long modulo = 1000000007;
    static long ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = inp.readLine().split(" ");
        long clothes = Long.parseLong(s1[0]);
        long months = Long.parseLong(s1[1]);

        //formula 2^k(2x-1)+1;
        calc(clothes,months);
        System.out.print(ans);
    }
    static void calc(long clothes,long months){
        if(clothes!=0) {
            long a;
            long count = 0;
            ArrayList<Long> list = new ArrayList<>();
            if (months >= 2) {
                a = 2;
                long c = months;

                while (c > 1) {
                    if (c % 2 == 1) {
                        count++;
                        list.add(a);
                    }
                    c = c / 2;

                    a = (a * a) % modulo;
                }
                while (count > 0) {
                    long b = list.get(0);
                    list.remove(0);
                    a = (a * b) % modulo;
                    count--;
                }

            } else {
                a = (long) Math.pow(2, months);
            }


            long b = clothes;

            //System.out.println(b);
            b = (2 * b - 1) % modulo;
            ans = (a * b) % modulo;
            ans = (ans + 1) % modulo;
        }else{
            ans = 0;
        }

    }
}
