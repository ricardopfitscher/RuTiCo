import java.util.Scanner;

public class Test{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int num=1;
		int add;
		for(int i=1;i<n;i++){
			add=4*i;
			num+=add;
		}
		System.out.println(num);
	}
}