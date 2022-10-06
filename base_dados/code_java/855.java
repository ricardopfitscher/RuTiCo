import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        //Scanner sc = new Scanner();
        Reader in = new Reader();
        Main solver = new Main();
        solver.solve(out, in);
        out.flush();
        out.close();
 
    }
 
    static int INF = (int)1e5*4*4+5;
    static int maxn = (int)1e5*2+1;
    static int mod=(int)1e9+7 ;
    static int n,m,k,t,q,x,a,b,y;
    
    static ArrayList<Integer> adj[];
    static int[] dist,parent,back;
    static boolean[] vis,vist;
    static int root=0,ans=1;
    
    
    void solve(PrintWriter out, Reader in) throws IOException{
        n = in.nextInt();


        if(n==1) {out.println(1);return;}
        adj = new ArrayList[n+1];
        for(int i=1;i<=n;i++) 
            adj[i] = new ArrayList<Integer>();
        
        int u,v;
        for(int i=0;i<n-1;i++){
            u = in.nextInt();
            v = in.nextInt();
             
            adj[u].add(v);
            adj[v].add(u);
        }
        
        vist = new boolean[n+1];
        vis = new boolean[n+1];
        vist[1] =true;
        makeroot(1);
        
        parent = new int[n+1];
        dist = new int[n+1];
        back = new int[n+1];
        
        dfs(root,0);
        calcdist(root);
        
        vist = new boolean[n+1];
        vis = new boolean[n+1];
        vist[root] =true;
        
        

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i=1;i<=n;i++){
            if(i!=root) pq.add(new Node(i,dist[i]));
        }
        
        Node elm;
        int rt = root;
        out.print(1);
        
        makeroot(root);
        removeNodes(root,rt);
        ans+=dist[rt];
        out.print(" "+ans);
        int itr=2;
        for(int i=2;i<=n;i++){
            
            elm = pq.remove();
            if(vis[elm.idx]) continue;
            removeNodes(back[elm.idx],elm.idx);
            ans += elm.dist+1;
            out.print(" "+ans);
            itr++;
        }
        for(int i=itr;i<n;i++)
            out.print(" "+ans);
        out.println();
    }
    
    //<>
    
    static class Node implements Comparable<Node>{
        int dist,idx;
        
        Node(int idx,int dist){
            this.idx = idx;
            this.dist = dist;
        }
        
        public int compareTo(Node o) {
            return o.dist-this.dist;
        }
    }
    
    static void removeNodes(int s,int e){
        vis[s]=true;
        while(s!=e){
            vis[s] = true;
            s = parent[s];
        }
        vis[s]=true;
        return;
    }
    
    static int calcdist(int s){
        int res=0;
        int tmp=0;
        for(int e:adj[s]){
            if(e!=parent[s]){
                tmp= calcdist(e);
                if(1+tmp>res){
                    res = 1+tmp;
                    back[s] = back[e];
                }
            }
        }
        
        if(res==0) back[s]=s;
        return dist[s] = res;
    }
    
    static void dfs(int s,int p){
        for(int e:adj[s]){
            if(e!=p){
                parent[e]=s;
                dfs(e,s);
            }
        }
        return;
    }
    
    static void makeroot(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        
        int elm=0;
        while(q.size()!=0){
            elm = q.remove();
            for(int e:adj[elm]){
                if(!vist[e]){
                    vist[e]=true;
                    q.add(e);
                    root = e;
                }
            }
        }
        return;
    }
    
    
    static class Reader {

    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public Reader() {
        this(System.in);
    }

    public Reader(InputStream is) {
        mIs = is;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();

    }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    }
}