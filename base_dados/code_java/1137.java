import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ElevatorOrStairs {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static final OutputStreamWriter writer = new OutputStreamWriter(System.out);
	
	public static void main(String...strings) throws Exception {
		String[] specs = reader.readLine().split(" ");
		
		int x = Integer.parseInt(specs[0]);
		int y = Integer.parseInt(specs[1]);
		int z = Integer.parseInt(specs[2]);
		int t1 = Integer.parseInt(specs[3]);
		int t2 = Integer.parseInt(specs[4]);
		int t3 = Integer.parseInt(specs[5]);
		
		reader.close();
		String ans = solve(x, y, z, t1, t2, t3);
		writer.append(ans);
		writer.flush();
		writer.close();
	}
	
	private static String solve(int x, int y, int z, int t1, int t2, int t3) {
		int time_using_stairs = Math.abs(x - y) * t1;
		int elevator_time_between_floor = Math.abs(x - z) * t2;
		int elevator_from_z_to_x = elevator_time_between_floor + 2*t3;
		
 		int time_using_elevator = elevator_from_z_to_x + (Math.abs(x - y) * t2) + t3;
 		
 		if(time_using_elevator <= time_using_stairs) {
 			return "YES";
 		}
 		return "NO";
	}
}