import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        try {
            new Main().solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ArrayList<Edge>[]edge;
    int n,m,cnt=0;
    int ord;
    int[]order;int[]vis;
    Edge[] e;
    private void solve() throws Exception{
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n=in.nextInt();m=in.nextInt();
        edge=new ArrayList[n+1];
        e=new Edge[m];
        vis=new int[n+1];
        order=new int[n+1];
        for(int i=1;i<=n;i++){
            edge[i]=new ArrayList<>();
        }
        for(int i=1;i<=m;i++){
            int s=in.nextInt(),t=in.nextInt(),c=in.nextInt();
            edge[s].add(new Edge(s,t,c,i));
        }
        int l=0,r=1000000000;
        while (l<r){
            int mid=(l+r)>>>1;
            if(judge(mid,false))r=mid;
            else l=mid+1;
        }
        out.print(l+" ");
        judge(l,true);
        Arrays.sort(e,0,cnt,Comparator.comparingInt(x->x.id));
        int ans=0;
        int[]a=new int[m];
        for(int i=0;i<cnt;i++){
            if(order[e[i].s]<order[e[i].t])a[ans++]=e[i].id;
        }
        out.println(ans);
        for(int i=0;i<ans;i++){
            out.print(a[i]+" ");
        }
        out.println();
        out.flush();
    }
    boolean judge(int min,boolean mod){
        Arrays.fill(vis,0);
        cycle=false;
        for(int i=1;i<=n;i++){
            if(vis[i]==0){
                dfs(i,min,mod);
                if(cycle)return false;
            }
        }
        return true;
    }
    boolean cycle=false;
    void dfs(int cur,int min,boolean mod){
        if(cycle)return;
        vis[cur]=1;
        for(Edge e:edge[cur]){
            if(e.c<=min){
                if(mod)this.e[cnt++]=e;
                continue;
            }
            if(vis[e.t]==1){
                cycle=true;return;
            }
            else if(vis[e.t]==0)dfs(e.t,min,mod);
        }
        vis[cur]=2;
        if(mod)order[cur]=ord++;
    }
}
class Edge{
    int s,t,c,id;
    Edge(int a,int b,int c,int d){
        s=a;t=b;this.c=c;id=d;
    }
}
class InputReader{
    StreamTokenizer tokenizer;
    public InputReader(InputStream stream){
        tokenizer=new StreamTokenizer(new BufferedReader(new InputStreamReader(stream)));
        tokenizer.ordinaryChars(33,126);
        tokenizer.wordChars(33,126);
    }
    public String next() throws IOException {
        tokenizer.nextToken();
        return tokenizer.sval;
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    public boolean hasNext() throws IOException {
        int res=tokenizer.nextToken();
        tokenizer.pushBack();
        return res!=tokenizer.TT_EOF;
    }
}