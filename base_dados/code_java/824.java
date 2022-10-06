import java.util.Scanner;

public class GenerateLogin {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		char last = b.charAt(0);
		String ans = ""+a.charAt(0);
		for(int i = 1;i<a.length();i++){
			if(a.charAt(i)>=last)break;
			ans+=a.charAt(i);
		}
		ans+=last;
		System.out.println(ans);
	}

}
