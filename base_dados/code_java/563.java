import java.io.*;
import java.util.*;

public class Main {
  static Scanner in = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    long boyMax = 0;
    int NBoyMax = 0;

    long sweets = 0;
    TreeSet<Long> boyMember = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      long input = in.nextLong();
      boyMember.add(input);
      if (boyMax < input) {
        boyMax = input;
        NBoyMax = 1;
      } else if (boyMax == input) NBoyMax++;
      sweets += (input * m);
    }

    long smallestGirl = (long) 1e8 + 1;
    long sum = 0;
    for (int i = 0; i < m; i++) {
      long input = in.nextLong();
      sum += input;
      if (smallestGirl > input) smallestGirl = input;
    }

    if (smallestGirl < boyMember.last()) {
      out.println(-1);
    } else if (smallestGirl == boyMember.last()) {
      sweets += sum - boyMember.last() * m;
      out.println(sweets);
    } else {

      if (NBoyMax > 1) {
        sweets += sum - boyMember.last() * m;
        out.println(sweets);
      } else {
        Object[] boyList = boyMember.toArray();
        if (boyList.length > 1) {
          long boy = 0;
          boy = (long)boyList[boyList.length - 2];
          sweets += (sum - smallestGirl - boyMember.last() * (m - 1));
          sweets += (smallestGirl - boy);
          out.println(sweets);
        } else {
          out.println(-1);
        }
      }
    }

    in.close();
    out.close();
  }
}