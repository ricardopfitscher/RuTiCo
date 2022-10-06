import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(a[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                System.out.println(0);
                return;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if ((a[i] & x) == (a[i - 1] & x) && !list.contains(x)) {
                System.out.println(2);
                return;
            } else if (list.contains(x) && a[i] > x && (a[i] & x) == x) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(-1);
    }
}