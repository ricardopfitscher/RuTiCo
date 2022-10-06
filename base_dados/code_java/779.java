import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//import TetraHedron.Scanner;


public class DivisorSubtraction {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long cnt=0;
		if(n%2==1){
			cnt=1;
			for(int a=3; (long)a*a<=n;a+=2){
				if(n%a==0){
					n-=a;
					break;
				}
			}
			if(n%2==1){
				n=0;
			}
		}
		cnt+=n/2;
		System.out.println(cnt);
	}

}
