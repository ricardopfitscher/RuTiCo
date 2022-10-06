import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/**
 *
 * @author Antonio "Teo" Alurralde
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer tok = new StringTokenizer(br.readLine());
    int ax = Integer.parseInt(tok.nextToken());
    int ay = Integer.parseInt(tok.nextToken());
    tok = new StringTokenizer(br.readLine());
    int bx = Integer.parseInt(tok.nextToken());
    int by = Integer.parseInt(tok.nextToken());
    tok = new StringTokenizer(br.readLine());
    int cx = Integer.parseInt(tok.nextToken());
    int cy = Integer.parseInt(tok.nextToken());
    boolean ans = (bx < ax && cx < ax && by < ay && cy < ay) ||
    (bx < ax && cx < ax && by > ay && cy > ay) ||
    (bx > ax && cx > ax && by < ay && cy < ay) ||
    (bx > ax && cx > ax && by > ay && cy > ay);
    System.out.print(ans?"YES":"NO");
  }
}
