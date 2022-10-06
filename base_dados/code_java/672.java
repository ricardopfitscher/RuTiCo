import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AnnoyingPresent {

	
	//UPSOLVED
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()) , m = Long.parseLong(st.nextToken());
        
        long sum = 0;
        
        for(int i=0;i<m;i++){
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
            sum+= n* Long.parseLong(st1.nextToken());
            Long a= Long.parseLong(st1.nextToken());
            if(a < 0){
                if(n % 2 == 0)
                    sum += n*n / 4*a;
                else{
                    sum += (n/2) * (n/2+1) * a;
                }
            }
            else
                sum += (a*(n) * (n-1) / 2);
            
        }
        System.out.println((double)sum/n);
	}

}
