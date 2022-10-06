import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MicroWorld {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] temp = new int[1000001];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++){
			
			temp[Integer.parseInt(st1.nextToken())]++;
		}
		
		int b = k + 1;
		
		for (int i = 1000000; i > 0; i--){
			
			if (temp[i] > 0){
				if (b <= k){
					n -= temp[i];
				}
				b = 1;
			}else{
				b++;
			}
		}
		
		System.out.println(n);
		
	}

}
