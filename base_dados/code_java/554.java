import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			int n=sc.nextInt();
			String s=sc.next();
			int sum=0;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='+') {
					sum++;
				}
				if(s.charAt(i)=='-'&&sum!=0) {
					sum--;
				}
			}
			System.out.println(sum);
		}
	}
}