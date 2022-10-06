import java.util.*;

public class OrangeJuice{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int s=in.nextInt();
		if(n>=1&&n<=100000&&s>=1&&s<=1000000000){
			if(s%n==0){
				System.out.println(s/n);
			}else{
				int o=s%n;
				System.out.println((s-o)/n+1);
			}
		}
	}
}