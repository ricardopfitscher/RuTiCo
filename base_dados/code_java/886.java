import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        int[]f=new int[1001];
        int[]a=new int[n];
        StringTokenizer tk=new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int element=Integer.parseInt(tk.nextToken());
            a[i]=element;
            f[element]++;
        }
        PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<Integer> h=new ArrayList<>();
        int counter=0;
        for (int i = 0; i < n; i++) {
            if(f[a[i]]==1){counter++; h.add(a[i]);}
            else{f[a[i]]-=1;}
        }
        pw.write(counter+"\n");
        for (int i = 0; i < h.size(); i++) {
            pw.write(h.get(i)+" ");
        }
        pw.flush();
    }
}