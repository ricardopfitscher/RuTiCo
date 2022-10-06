//https://www.geeksforgeeks.org/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/
//O(sum)
// Java program to Count of n digit numbers
// whose sum of digits equals to given sum

public class GFG {

	public static void main(String[] args) {
		
		int n = 3;
		int sum = 5;	
		findCount(n,sum);
		
	}
	
	private static void findCount(int n, int sum) {
		
		//in case n = 2 start is 10 and end is (100-1) = 99
		int start = (int) Math.pow(10, n-1);
		int end = (int) Math.pow(10, n)-1;
	
		int count = 0;
		int i = start;
		
				while(i < end) {
			
			int cur = 0;
			int temp = i;
			
			while( temp != 0) {
				cur += temp % 10;
				temp = temp / 10;
			}
			
			if(cur == sum) {			
				count++;			
				i += 9;		
			}else
				i++;
			
		}	
		System.out.println(count);

		/* This code is contributed by Anshuman */
	}
}
