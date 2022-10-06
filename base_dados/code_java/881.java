import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice {
	
	   

		public static void main(String []args)
		{
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			sc.nextLine();
			String s=sc.nextLine();
			//System.out.println(s);
			char c[]=s.toCharArray();
			ArrayList a =new ArrayList();
			
			for(int i=0;i<c.length;i++)
			{
				//System.out.println(c[i]);
				a.add(c[i]);
			}
		
			int x=Collections.frequency(a,'0' );
			int y=Collections.frequency(a,'1');
			
			//System.out.println(x+ "  "+y );
			if(y==0 || y==1)
			{
				System.out.println(s);
			}
			else
			{
				if(y>=2)
				{
					String s1="1";
					for(int i=0;i<x;i++)
					{
						s1=s1+"0";
					}
					System.out.println(s1);
					
				}
			}
			
			
			
			
			
			
	}

}