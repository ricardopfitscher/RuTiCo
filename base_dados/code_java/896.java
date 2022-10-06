import java.util.*;
public class A
{
    public static int palin(String str)
    {
        int flag=0;
        int l=str.length();
        for(int i=0;i<l/2;i++)
        {
            if(str.charAt(i)!=str.charAt(l-i-1))
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
        return 0;
        else
        return 1;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<str.length();i++)
        {
            hs.add(str.charAt(i));
        }
        if(hs.size()==1)
        System.out.println(0);
        else if(palin(str)==0)
        System.out.println(str.length());
        else
        System.out.println(str.length()-1);
    }
}