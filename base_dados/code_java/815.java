
import java.util.*;
import java.math.*;
public class Main {
	static class en implements Comparable<en>{
		int w,h,dex;
		en(int a,int b,int c){
			w=a;
			h=b;
			dex=c;
		}
		public int compareTo(en o) {
			return w-o.w;
		}
	}
	public static void main(String args[]) {
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt(),ww=cin.nextInt(),hh=cin.nextInt(),num=0;
		Queue<en> que=new PriorityQueue();
		for(int i=1;i<=n;i++) {
			int a=cin.nextInt(),b=cin.nextInt();
			if(a>ww&&b>hh) {
				que.add(new en(a,b,i));
				num++;
			}
		}
		int dp[][]=new int[num+5][2],ans=0,ad=0,arr[][]=new int[num+5][3];
		for(int i=1;i<=num;i++) {
			arr[i][0]=que.peek().w;
			arr[i][1]=que.peek().h;
			arr[i][2]=que.remove().dex;
		}
		for(int i=1;i<=num;i++) {
			int te=0,td=0;
			for(int j=1;j<i;j++) {
				if(arr[j][0]<arr[i][0]&&arr[j][1]<arr[i][1]&&dp[j][0]>te) {
					te=dp[j][0];
					td=j;
				}
			}
			dp[i][0]=te+1;
			dp[i][1]=td;
			if(dp[i][0]>ans) {
				ans=dp[i][0];
				ad=i;
			}
		}
		System.out.println(ans);
		ArrayList<Integer> an=new ArrayList();
		int u=ad;
		while(u>0) {
			an.add(arr[u][2]);
			u=dp[u][1];
			//System.out.println(u);
		}
		for(int i=an.size()-1;i>=0;i--) System.out.print(an.get(i)+" ");
	}
}
