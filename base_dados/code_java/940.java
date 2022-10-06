import java.util.*;
public class Solution{
	public static void main(String sp[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String st = sc.next();
		
		char arr[] = st.toCharArray();
		
		boolean b=false;
		for(char j='a';j<='z';j++){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==j){
				arr[i]='*';
				k--;
			}
			if(k==0){
				b=true;
				prin(arr);
				return;
			}
		}}

	}
	
	public static void prin(char arr[]){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			if(arr[i]!='*')
				sb.append(arr[i]);
		}
		if(sb.length()!=0)
			System.out.println(sb.toString());
	}
}