import java.io.*;

public class n5D
{
    public static void main(String[] args)
    {
        double a = 0, v = 0, l = 0, d = 0, w = 0;
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            a = Double.parseDouble(str[0]);
            v = Double.parseDouble(str[1]);
            str = br.readLine().split(" ");
            l = Double.parseDouble(str[0]);
            d = Double.parseDouble(str[1]);
            w = Double.parseDouble(str[2]);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        double t1, t2, t3, t4, t5, t, D = 0;
        
        if (w > v) w = v;
        t2 = d / v - v / a + w * w / 2 / a / v;
        if (t2 >= 0)
        {
            t1 = v / a; 
            t3 = t1 - w / a;
        }
        else
        {
            if (Math.sqrt(2 * d / a) > (w / a))
            {
                t1 = Math.sqrt((2 * a * d + w * w) / (a * a * 2));
                t3 = t1 - w / a;
            }
            else
            {
                t1 = Math.sqrt(2 * d / a);
                t3 = 0;
            }
            t2 = 0;
        }
        t5 = (l - d - v * v / 2 / a + a * (t1 - t3) * (t1 - t3) / 2) / v;
        if (t5 >= 0) t4 = v / a - (t1 - t3);
        else
        {
            t5 = 0;
            t4 = -t1 + t3 + Math.sqrt((t1 - t3) * (t1 - t3) + 2 * (l - d) / a);
        }
        t = t1 + t2 + t3 + t4 + t5;
        System.out.println(t);
        //System.out.println(t1 + " " + t2 + " " + t3 + " " + t4 + " " + t5);
    }
}