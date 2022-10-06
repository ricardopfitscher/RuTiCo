import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		String str=in.next();
		int cnt=0;
		for(int i=0;i<str.length();++i) {
			if(str.charAt(i)=='1') {
				++cnt;
			}
		}
		int i=0;
		for(;i<str.length();++i) {
			if(str.charAt(i)=='0') {
				System.out.print("0");
			}
			else if(str.charAt(i)=='2') {
				while(cnt-->0) {//
					System.out.print("1");
				}
				System.out.print("2");
			}
		}
		while(cnt-->0) {
			System.out.print("1");
		}
		in.close();
	}
}