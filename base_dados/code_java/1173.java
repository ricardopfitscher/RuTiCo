import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//kai
		Scanner kai = new Scanner(System.in);
		while (kai.hasNext()) {
			int a = kai.nextInt();
			if ((a & 1) == 0) {
				System.out.println("Mahmoud");
			}else {
				System.out.println("Ehab");
			}
		}
	}
}
 	   				 	   			 		  	  	 	 	