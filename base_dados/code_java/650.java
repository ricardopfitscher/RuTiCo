import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LightItUp {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int previous = 0;
		int array[] = new int[n+1];
		int answer = 0;
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			array[i] = Integer.parseInt(st1.nextToken());
			if(i % 2 == 0){
				answer += (array[i] - previous);
			}
			previous = array[i];
		}
		
		if(n % 2 == 0){
			answer += (m - previous);
		}
		previous = m;
		int max = Integer.MAX_VALUE;
		
		while(n-- != 0){
			int temp = array[n];
			if(n%2 == 0){
				array[n] = array[n+1] - (previous - array[n]);
			}
			else{
				array[n] = array[n+1] + (previous - array[n]);
			}
			previous = temp;
			max = Math.min(max, array[n]);
		}
		if(max>=-1){
			System.out.println(answer);
		}
		else{
			System.out.println(answer - (max+1));
		}

	}

}
