import java.io.*;
import java.util.*;
import java.lang.String;
public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String str = br.readLine();
            int q = Integer.parseInt(str);
            //int q = 7;
            //int q = 1345679;
        if(q%2 == 0 && q!=2)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
        catch(IOException e)
        {
            System.out.println("Input Error");
        }
        
        
 
       /* String str = "hello";
        String str1 = Character.toUpperCase(str.charAt(0))+str.substring(1);
        System.out.println(str1);
        */
 
    }
}