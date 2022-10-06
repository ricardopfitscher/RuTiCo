import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		String str = br.readLine().trim();
		int [] arr = new int[n];
		
		LL[] adjlist = new LL[n];
		
		for(int i =0 ; i < n; i++){
			int x = str.charAt(i) - 'a' + 1;
			arr[i] = x;
			adjlist[i] = new LL();
		}
		
		
		Arrays.sort(arr);
		
		for(int i =0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				int a = arr[i];
				int b = arr[j];
				
				if((b - a) >= 2){
					adjlist[i].add(new Pair(j, arr[j], 1));
				}
			}
		}
		
		LinkedList<Pair> list = new LinkedList<Pair>();
		LinkedList<Pair> tmpList = new LinkedList<Pair>();
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++){
			
			list.clear();
			list.add(new Pair(i,arr[i],0));
			// out.println("---- "+arr[i]);
			
			
			for(int j = 0; j < k; j++){
				tmpList.clear();
				while(!list.isEmpty()){
					
					
					Pair cur = list.removeFirst();
					if(j == k-1){
						ans = Math.min(cur.val, ans);
					}
					for(Pair adj : adjlist[cur.idx]){
						
						
						tmpList.add(new Pair(adj.idx, adj.val + cur.val, cur.val+1));
					}
				}
				
				
				
				// out.println(list.toString());
				if(tmpList.size() == 0){
					break;
				}
				else{
					list.addAll(tmpList);
				}
				
				// out.println(list.toString());
			}
			
			
		}
		
		if(ans == Integer.MAX_VALUE) out.println(-1);
		else out.println(ans);
		
		
	}
	public static class LL extends LinkedList<Pair>{}
	public static class Pair implements Comparable<Pair>{
		int val;
		int idx;
		int ctr;
		public Pair(int a, int b, int c){
			idx = a;
			val = b;
			ctr = c;
		}
		public int compareTo(Pair p){
			
			if(ctr == p.ctr){
				if(val == p.val) return idx - p.idx;
					
				return val - p.val;
			}
			return p.ctr - ctr;
		}
		public String toString(){
			return val+", ";
		}
	}
}