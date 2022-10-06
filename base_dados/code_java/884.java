

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class LessorEqual_CodeForces {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[]=br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		temp=br.readLine().split(" ");
		int [] num = new int[n];
//		int [] freq = new int [1000000000];
		PriorityQueue<Integer>pq = new PriorityQueue<Integer>();  
		for(int i=0;i<n;i++){
			num[i]=Integer.parseInt(temp[i]);
			pq.add(num[i]);
		//	freq[num[i]]++;
						
		}
		if(k==0){
			int y= pq.poll();
			if(y==1){
				System.out.println(-1);
				System.exit(0);
			}
			else 
				{
				System.out.println(y-1);
				System.exit(0);
			}
				
		}
		
		//System.out.println(pq);
		int count=0;
		int max=0;
		while (!pq.isEmpty()){
			int x = pq.poll();
			while(count<=k&&!pq.isEmpty()&& pq.peek()==x){
				pq.poll();
				count++;
			}
		//	System.out.println(x);
			count++;
			max=x;
			if(count==k)
				break;
		}
		
		//System.out.println("the count is "+ count);
		if(count==k){
			if(!pq.contains(max+1)&& max<1e9)
				System.out.println(max+1);
			else 
				System.out.println(max);
			}
		else 
			System.out.println(-1);
 
		
	}

}
