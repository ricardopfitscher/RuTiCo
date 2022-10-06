import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoveredPointsCount {
	
	//UPSOLVE
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	        
		int n = Integer.parseInt(st.nextToken());
	     
		long[] myArray = new long[2 * n];
	        
			for (int i = 0; i < n; i++)  {
	        	StringTokenizer st1 = new StringTokenizer(br.readLine());
	        	myArray[2 * i] = Long.parseLong(st1.nextToken()) * 2;
	        	myArray[2 * i + 1] = Long.parseLong(st1.nextToken()) * 2 + 1;
	        }  
	        
	        Arrays.sort(myArray);
	        long[] ans = new long[n + 1];
	        int cnt = 0;
	       
	        for (int i = 0; i < 2 * n - 1; i++)   {
	            if (myArray[i] % 2 == 0) cnt++; else cnt--;
	            ans[cnt] += (myArray[i + 1] + 1) / 2 - (myArray[i] + 1) / 2;
	        }   
	        
	        StringBuilder answer = new StringBuilder();
	        
	        for (int i = 1; i < n + 1; i++) {
	        	answer.append(ans[i]);
	        	answer.append(" ");
	        }  
	        
	        System.out.println(answer);

	}

}
