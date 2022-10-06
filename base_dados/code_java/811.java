import java.util.Scanner;

public class Amain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[] = new int[100005];
		int vis[] = new int[100005];
		int maxx = -1;
		int n , k ;
		int e = 0  , s = 0 ;
		int ans = 0  ;
		
		n=sc.nextInt();
		k=sc.nextInt();

		for(int i = 1 ; i<=n ; i++ )
		{
			a[i]=sc.nextInt() ;
			if(a[i]== 1 )
			{
				e++ ;
			}
			else
			{
				s++ ;
			}
		}

		for(int i = 1 ; i<=k  ;i++ )
		{
			int e1 = 0 ;
			int s1 = 0 ;
			for(int j = i ; j<=n ;j+=k )
			{
				if(a[j]==1 )
				{
					e1++ ;
				}
				else
				{
					s1++ ;
				}
			}

	 
			ans = Math.abs(  (s-s1)-(e-e1)) ;
			maxx = Math.max(maxx,ans) ;
		}
       System.out.print(maxx);
	}

}
