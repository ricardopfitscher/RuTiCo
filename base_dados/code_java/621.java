import java.util.*;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int loca[]=new int[n+m];
		int res[]=new int[m];
		for(int i=0;i<n+m;i++)
			loca[i]=sc.nextInt();
		
		int y=0;
		int driver[]=new int[m];
		for(int i=0;i<n+m;i++){
			int x=sc.nextInt();
			if(x==1)
				driver[y++]=i;
		}
		
		int i=0,j=0,p=0,q=0;
		for(i=0;i<m+n;i++) {
			if(i==driver[0])
				{i++;break;}
			if(loca[i]<loca[driver[0]])
				res[0]++;
			else
				break;
		}
		
		//j=1;
		
		for(;i<n+m;i++){
			
			int coor=loca[i];
			
			/*if(coor>q&&j!=0)
				j++;*/
			
			if(j==m-1)
				break;
			
			p=driver[j];q=driver[j+1];		

			if(i==j)
				continue;
			
			int d1=coor-loca[p],d2=loca[q]-coor;
			
			if(d2==0)
				{j++;continue;}
			if(d1<=d2)
				res[j]++;
			else
				res[j+1]++;
			
			//add check for j+1<m
			//handle cases for j==0 && j==m-1
		}
		
		for(;i<m+n;i++) {
			
			if(i==driver[j])
			{i++;break;}
			
			if(loca[i]>loca[driver[j]])
				res[j]++;
			else
				break;
		}
		
		for(i=0;i<m;i++)
			System.out.print(res[i]+" ");
	}
}