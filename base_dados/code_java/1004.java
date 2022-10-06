import java.util.Scanner;

public class NickAndArray {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		 int array[]=new int[n];
		 int max=Integer.MAX_VALUE;
		 int index=0;
		 for(int i=0;i<n;i++)
		 {
			 int k=sc.nextInt();
			 array[i]=k;
			 if(array[i]>=0)
			 {
				 array[i]=-array[i]-1;
			 }
			 if(array[i]<max)
			 {
				 max=array[i];
				 index=i;
				 
			 }
		 }
		 if(n%2!=0)
		 {
			 array[index]=-array[index]-1;
		 }
		 for(int i=0;i<n;i++)
		 {
			 System.out.print(array[i]+" " );
		 }
	}

}
