//https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
//O(log n)
//Java implementation of above approach
public class GFG {
	
	static int INT_SIZE = 32;

	static int Right_most_setbit(int num)
	{
		int pos = 1;
		// counting the position of first set bit
		for (int i = 0; i < INT_SIZE; i++) {
			if ((num & (1 << i))== 0)
				pos++;
			
			else
				break;
		}
		return pos;
	}
	
	//Driver code
	public static void main(String[] args) {
	
		int num = 18;
			int pos = Right_most_setbit(num);
			System.out.println(pos);
	}
}
