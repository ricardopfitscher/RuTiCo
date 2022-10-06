import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) {
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
        String input;
		try {
			input = br.readLine();
			int n = Integer.parseInt(input);
			input = br.readLine();
			int qx = Integer.parseInt(input.split(" ")[0]);
			int qy = Integer.parseInt(input.split(" ")[1]);
			input = br.readLine();
			int kx = Integer.parseInt(input.split(" ")[0]);
			int ky = Integer.parseInt(input.split(" ")[1]);
			input = br.readLine();
			int gx = Integer.parseInt(input.split(" ")[0]);
			int gy = Integer.parseInt(input.split(" ")[1]);
			if((kx<qx && gx<qx)||(kx>qx && gx>qx)) {
				if((ky<qy && gy<qy)||(ky>qy && gy>qy))System.out.println("YES");
				else System.out.println("NO");
			}else System.out.println("NO");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
