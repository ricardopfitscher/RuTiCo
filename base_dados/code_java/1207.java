import java.util.*;
import java.io.*;

public class aaaaaaaaaaaaaaaa {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		int a = file.nextInt(), b= file.nextInt(), c = file.nextInt(), n = file.nextInt();
		a -= c;
		b -= c;
		if (a < 0 || b < 0) System.out.println(-1);
		else {
			int x = a + b + c;
			if (x >= n) System.out.println(-1);
			else System.out.println(n - x);
		}
	}

	public static void main(String[] args) throws Exception {
		new aaaaaaaaaaaaaaaa().run();
	}

}