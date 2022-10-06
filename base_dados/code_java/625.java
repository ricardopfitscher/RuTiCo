
import java.util.Scanner;

public class TaxistsnLyft {
	public static void main (String[] args){
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = n+m;
		long[] arr1 = new long[k];
		for(int i = 0; i<k; i++){
			arr1[i]=scan.nextLong();
		}
		long[] tax = new long[k];
		long[] taxcount = new long[k];
		for(int i = 0; i<k; i++){
			tax[i]=scan.nextInt();
		}
		int c;
		int b;
		for(int i = 0; i<k; i++){
			if(tax[i]==0){
				c=i;
				while(tax[c]!=1){
					if(c==0){
						c=-1;
						break;
					}
					c--;
					
				}
				b=i;
				while(tax[b]!=1){
					if(b>=k-1){
						b=-1;
						break;
					} 
					b++;
					
				}
				//System.out.println(">>"+b+">>"+c);
				if(c==-1&&b>=0){
					taxcount[b]++;
				} else if(b==-1&&c>=0) {
					taxcount[c]++;
				} else if(b>=0&&c>=0) {
					if(arr1[i]-arr1[c]>arr1[b]-arr1[i]){
						taxcount[b]++;
					}
					if(arr1[i]-arr1[c]<arr1[b]-arr1[i]){
						taxcount[c]++;
					}
					if(arr1[i]-arr1[c]==arr1[b]-arr1[i]){
						taxcount[c]++;
					}
					
				}
				
			}
			
			}
		for(int j = 0; j<k; j++){
			if(tax[j]==1){
				System.out.print(taxcount[j]+" ");
			}
		scan.close();
		}
	}
}
