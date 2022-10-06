import java.util.Scanner;


public class IfAtFIrstYouDIdnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int n  = input.nextInt();
		if(a<n && b<n && c < n && (a+b-c)<n && c<=a && c<=b){
			System.out.println((n)-(a+b-c));
		}
		else
			System.out.println("-1");
	}

}
