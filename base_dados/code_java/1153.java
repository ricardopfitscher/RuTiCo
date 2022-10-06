import java.io.IOException;
import java.util.*;

public class Main implements Runnable {
  static String readLn(int maxLength) {

    byte line[] = new byte[maxLength];
    int length = 0;
    int input = -1;
    try {
      while (length < maxLength) {
        input = System.in.read();
        if ((input < 0) || (input == '\n')) {
          break;
        }

        line[length++] += input;
      }

      if ((input < 0) && (length == 0)) {
        return null;
      }

      return new String(line, 0, length);
    } catch (IOException e) {
      return null;
    }
  }

  public static void main(String args[]) {
    Main myWork = new Main();
    myWork.run();
  }

  public void run() {
    new Watermelon().run();
  }
}

class Watermelon implements Runnable {
  public void run() {
    String line = Main.readLn(100).trim();
    int weight = Integer.parseInt(line);
    System.out.println(weight % 2 == 0 && weight > 2 ? "YES": "NO");
  }
}