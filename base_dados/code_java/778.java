import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 
public class B1076 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		if(isPrime(n)) {
			System.out.println(1);
			System.exit(0);
			
		}else {
			if(n % 2 == 0) {
				System.out.println(n /2);
				System.exit(0);
			}else {
				long spd = smallestPrimeDiv(n);
				n -= spd;
				System.out.println(n/2 + 1);
			}
		}
 
		
		
		
		
 
		
	}
 
 
	static long smallestPrimeDiv(long n){
		for(int i =2 ; i < n ; i ++) {
			if(n % i == 0) {
				if(isPrime(i)) {
					return i;
				}
			}
		}
		return n;
	}
	/*static boolean isPrime(long n) {
		for(int i= 2; i <n-1; i ++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	*/
	static boolean isPrime(long n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}
}