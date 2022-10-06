import java.util.*;
import java.io.*;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] point = new int[n][];
        for(int i=0;i<n;i++) point[i] = new int[]{sc.nextInt(),sc.nextInt()};
        Arrays.sort(point,(a,b)->((a[0]-a[1])-(b[0]-b[1])));
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            int x = point[i][0], w = point[i][1];
            Map.Entry<Integer,Integer> cur =  tm.ceilingEntry(x+w);
            int curRes;
            if(cur==null) curRes = 1;
            else curRes = cur.getValue()+1;
            ans = Math.max(ans,curRes);
            Map.Entry<Integer,Integer> upper = tm.ceilingEntry(x-w);
            if(upper==null||upper.getValue()<curRes) tm.put(x-w,curRes);
            //Integer key = tm.
        }
        System.out.println(ans);
    }
}
