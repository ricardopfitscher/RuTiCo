import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
	
	   

		public static void main(String []args)
		{
			Scanner sc=new Scanner(System.in);
			
			
			String s=sc.nextLine();
			int n=0;
			int m=0;
			//System.out.println(5%0);
			
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='-')
				{
					n++;
				}
				else
				{
					m++;
				}
			}
			if(m==0)
			{
				System.out.println("YES");
			}
			else
			{
			if(n%m==0)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			}
			
			
			
			
			
			
			
			
	}

}