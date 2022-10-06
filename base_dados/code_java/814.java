import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CodeForces {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int d = in.nextInt(), sum = in.nextInt();
		List<Data> data = new ArrayList<>();
		
		for (int i = 0; i < d; ++i) {
			int min = in.nextInt(), max = in.nextInt();
			int centre = (min + max) / 2;
			data.add(new Data(centre - min, max - centre, centre));
			sum -= centre;
		}
		
		Iterator<Data> it = data.iterator();
		
		while (sum != 0) {
			if (!it.hasNext()) {
				System.out.println("NO");
				return;
			}
			
			Data da = it.next();

			if (sum > 0) {
				da.centre += da.above;
				sum -= da.above;
			} else {
				da.centre -= da.below;
				sum += da.below;
			}
		}
		
		System.out.println("YES");
		
		for (Data da : data) {
			System.out.print(da.centre + " ");
		}
	}
}

class Data {
	int below, above, centre;
	
	Data(int below, int above, int centre) {
		this.below = below;
		this.above = above;
		this.centre = centre;
	}
}