import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cr500 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n, x, status = -1;
        Set<Integer> a = new HashSet<>(), bitA = new HashSet<>();
        ArrayList<Integer> al = new ArrayList<>(), bl = new ArrayList<>();
        n = scanner.nextInt();
        x = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            int v;
            if(!a.add(v = scanner.nextInt())) {
                System.out.println(0);
                return;
            }

            if(!bitA.add(v & x)) {
                status = 2;
            }
            al.add(v);
            bl.add(v & x);
        }

        if(contains(al, bl)) {
            System.out.println(1);
            return;
        }

        System.out.println(status);
    }

    private static boolean contains(ArrayList<Integer> a, ArrayList<Integer> b) {
        for(int i = 0; i < a.size(); i++) {
            int v1 = a.get(i);
            for(int j = 0; j < b.size(); j++) {
                int v2 = b.get(j);
                if(i != j && v1 == v2) {
                    return true;
                }
            }
        }
        return false;
    }
}