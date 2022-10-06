import java.io.*;

public class VJudgeProblem2{
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());

        if (x == 1)
            System.out.println(-1);
        else
            System.out.println(x + " " + x);    
    }
        
}