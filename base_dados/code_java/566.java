import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();

    long[] boys = readArray(in, n);
    long[] girls = readArray(in, m);

    long res = solve(boys, girls);
    System.out.println(res);
  }

  private static long[] readArray(Scanner in, int size) {
    long[] arr = new long[size];
    for (int i = 0; i < size; i += 1) {
      arr[i] = in.nextInt();
    }
    return arr;
  }

  private static long solve(long[] boys, long[] girls) {
    Arrays.sort(boys);
    Arrays.sort(girls);

    int n = boys.length;
    int m = girls.length;

    if (girls[0] < boys[n - 1] || (m == 1 && girls[0] != boys[n - 1])) {
      return -1;
    }
    if (n == 1) {
      for (long num : girls) {
        if (num != boys[0]) {
          return -1;
        }
      }
    }

    long res = 0;
    for (int i = 0; i + 1 < n; i += 1) {
      res += boys[i] * m;
    }
    for (long num : girls) {
      res += num;
    }

    if (girls[0] != boys[n - 1]) {
      res -= boys[n - 2];
      res += boys[n - 1];
    }
    return res;
  }
}
