
import java.util.ArrayList;
import java.util.Scanner;

public class TaxiDriversAndLyft {
	
	static class Resident{
		Integer index;			// For all residents
		Integer type;			// 1 if driver & 0 for rider
		Integer requests;		// Only for drivers
		
		public Resident(int index, int type) {
			this.index = index;
			this.type = type;
			this.requests = 0;
		}
		
		@Override
		public String toString() {
			if(type == 0) {
				return "Rider at index : " + index;
			}
			else {
				return "Driver at index : " + index + ", Requests: " + requests;
			}
		}
	}
	
	static ArrayList<Resident> residents;
	static ArrayList<Integer> drivers_indexes = new ArrayList<>();

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		int length = n + m;
		
		int [] coordinates = new int[length];
		int [] types = new int[length];
		residents = new ArrayList<>();
		drivers_indexes = new ArrayList<>();
		
		for (int i = 0; i < length; i++) {
			coordinates[i] = reader.nextInt();
		}
		
		for (int i = 0; i < length; i++) {
			types[i] = reader.nextInt();
			
			if(types[i] == 1)
				drivers_indexes.add(i);
				
			residents.add(new Resident(i, types[i]));
		}
		reader.close();	
		
		for (int i = 0; i < length; i++) {
			Resident current = residents.get(i);
			if(current.type == 0) {
				int left = i-1, right = i+1;
								
				while(left >= 0 || right < length) {
					if(left >= 0 && residents.get(left).type == 1) {
						residents.get(left).requests++;
						break;
					}
					else if(right < length && residents.get(right).type == 1) {
						residents.get(right).requests++;
						break;
					}
					
					left--;
					right++;
				}
			}
		}
		
		for(int index : drivers_indexes) {
			System.out.print(residents.get(index).requests + " ");
		}
	}

}
