import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int [n];
		int maxindex=0;
		int minindex=0;
		int max;
		int min;
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		int k=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(i!=j) {
					int k1=Math.min(arr[i], arr[j])/Math.abs(i-j);
					if(k1<k) {
						k = k1;
					}
				}
			}
		}
		System.out.println(k);
	}

}