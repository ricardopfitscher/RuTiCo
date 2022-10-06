import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		long sum1=0,sum2=0;
		for(int i=0;i<num*2;i++){
			sum1+=sc.nextInt();
			sum2+=sc.nextInt();
		}
		System.out.println(sum1/num+" "+sum2/num);
	}
}
				  			 		  	 			 				 	