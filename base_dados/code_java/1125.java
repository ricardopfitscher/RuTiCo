import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
public class A {

	public static void main(String[] args) {
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
        String input;
		try {
			input = br.readLine();
			long n = Long.parseLong(input.split(" ")[0]);
	        long k = Long.parseLong(input.split(" ")[1]);
	        long red = (long) (Math.ceil((n * 2.0)/k));
	        long blue = (long) (Math.ceil((n * 5.0)/k));
	        long green = (long) (Math.ceil((n * 8.0)/k));
	        System.out.println(red + blue +green);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
