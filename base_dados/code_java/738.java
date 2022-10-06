
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF_1029E_Tree_with_Small_Distances {
	static ArrayList<Integer> adj[];
	static int dist[];
	static boolean visitParent[];
	static int ans=0;
 public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(System.in);
	int n  =sc.nextInt();
	adj=new ArrayList[n+1];
	dist = new int[n+1];
	visitParent = new boolean[n+1];
	for(int i=0;i<=n;i++) adj[i]=new ArrayList<Integer>();
	int max=0;
	//first contribution
	for(int i=1;i<n;i++){
		int u = sc.nextInt(),v=sc.nextInt();
		adj[u].add(v);
		adj[v].add(u);
	}
	dist[1]=0;
	dfs(1,1);
 System.out.println(ans);
 
 
 }
private static void dfs(int i , int j) {
	// TODO Auto-generated method stub
	boolean f = false;
	for(int k=0;k<adj[i].size();k++){
		int x = adj[i].get(k);
		if(x!=j){
			dist[x]=dist[i]+1;
			dfs(x,i);
			if(visitParent[x])
				f=true;
		}
	}
	//System.out.println(Arrays.toString(dist));
	if(dist[i]>2&&!visitParent[j]&&!f&&!visitParent[i]){
		visitParent[j]=true;
		ans++;
		for(int v=0;v<adj[i].size();v++){
			
		}
	}
	
}
static class Scanner 
{
    StringTokenizer st;
    BufferedReader br;

    public Scanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}

    public String next() throws IOException 
    {
        while (st == null || !st.hasMoreTokens()) 
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    
    public double nextDouble() throws IOException
    {
        String x = next();
        StringBuilder sb = new StringBuilder("0");
        double res = 0, f = 1;
        boolean dec = false, neg = false;
        int start = 0;
        if(x.charAt(0) == '-')
        {
            neg = true;
            start++;
        }
        for(int i = start; i < x.length(); i++)
            if(x.charAt(i) == '.')
            {
                res = Long.parseLong(sb.toString());
                sb = new StringBuilder("0");
                dec = true;
            }
            else
            {
                sb.append(x.charAt(i));
                if(dec)
                    f *= 10;
            }
        res += Long.parseLong(sb.toString()) / f;
        return res * (neg?-1:1);
    }


    public int nextInt() throws IOException {return Integer.parseInt(next());}

    public long nextLong() throws IOException {return Long.parseLong(next());}

    public String nextLine() throws IOException {return br.readLine();}

    public boolean ready() throws IOException {return br.ready(); }


}
	
}

