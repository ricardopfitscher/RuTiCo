
import java.util.Scanner;

public class origami {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		double n = input.nextInt();
		double k = input.nextInt();
		double red = 0;
		double green = 0;
		double blue = 0;
		double ans = 0;
		red = (2 * n) / k;
		green = (5 * n) / k;
		blue = (8 * n) / k;

		double red1 = Math.ceil(red) ;
		double green1 = Math.ceil(green);
		double blue1 = Math.ceil(blue);

		ans+=red1;
		ans+=green1;
		ans+=blue1;
		Double answer = new Double(ans);
		int finished = answer.intValue();
		System.out.println(finished);
	}
}
