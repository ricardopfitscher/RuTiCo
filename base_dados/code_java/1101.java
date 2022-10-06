import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TestClass1 {


    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        long A,B,y,g,b;
        A= Long.parseLong(s[0]);
        B= Long.parseLong(s[1]);
        s=br.readLine().split(" ");

        y = Long.parseLong(s[0]);
        g = Long.parseLong(s[1]);
        b = Long.parseLong(s[2]);

long ans=0;
        if(A-2*y-g < 0){
            ans+=Math.abs(A-2*y-g);
        }
        
        if(B-g-3*b < 0){
            ans+=Math.abs(B-g-3*b);
        }
        System.out.println(ans);



    }
}
