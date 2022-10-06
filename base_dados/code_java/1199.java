import java.util.*;
import java.io.*;

public class programA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n%2 == 0)System.out.println(n/2 +1);
		else System.out.println((int)Math.ceil((double)n/2));
	}
}




