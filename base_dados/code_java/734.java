import java.util.Scanner;


public class FUck {

		public static void main(String args[])
		{
			Scanner scan=new Scanner(System.in);
			int n=scan.nextInt();
			int k=scan.nextInt();
			String t=scan.next();
			int mx=0;
			for(int i=1;i<n;i++)
			{
				int gd=1;
				for(int j=0;j<i;j++)
				{
					
					if(t.charAt(j)!=t.charAt((n-i)+j))
					{
						
						gd=0;
						// i think i can break here
					}
					}
				if(gd==1){
					mx=i;
					
				}
			}
			System.out.print(t);
			for(int i=2;i<=k;i++)
			{
				for(int j=mx;j<n;j++)
				{
					System.out.print(t.charAt(j));
				}
			}
		}
}
