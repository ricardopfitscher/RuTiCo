import java.util.Scanner;

//import java.util.Scanner;




public class SingleWildcard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input =new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		char[] s1 =new char[a];
		s1 = input.next().toCharArray();
		
		char[] s2 = new char[b];
		s2 = input.next().toCharArray();
	    boolean condition = false;
	    for(int i=0; i<a;i++){
	    	if(s1[i]=='*'){
	    		condition= true;
	    		break;
	    	}
	    }
	   
	    if(!condition){
	    	if(match(s1,s2)){
	    		System.out.println("YES");
	    		
	    	}
	    	else
	    		System.out.println("NO");
	       return;
	    }
	    else{
	    	int i=0;
	    	if(s1.length-1>s2.length){
	    		System.out.println("NO");
	    		return;
	    	}
	    	while(i<s1.length && i<s2.length && s1[i]==s2[i]){
	    		i++;
	    	}
	    	int j=s2.length-1;
	    	int k = s1.length-1;
	    	while(j>=0 && k>=0 &&  s1[k]==s2[j] && i<=j){
	    		j--;
	    		k--;
	    	}
	    	//System.out.println(i);
	    	if(i==k && i>=0 && i<s1.length && s1[i]=='*' ){
	    		System.out.println("YES");
	    		return;
	    	}
	    	System.out.println("NO");
	    }
		
		
	}
	
	static boolean match(char[] s1,char[] s2){
		if(s1.length!=s2.length)return false;
		for(int i=0; i<s1.length;i++){
			if(s1[i]!=s2[i])return false;
		}
		return true;
	}
	

}
