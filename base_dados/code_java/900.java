import java.util.*;
		public class mohamedy23
		{
	      public static void main (String args[])
		    {
		    	Scanner sc=new Scanner(System.in);
		    	int n=sc.nextInt();String s=sc.next();int i=s.length()-1;
		    	
		    	if(n==1) {
		    		if(s.charAt(0)=='1') {
		    			System.out.print("YES");return;
		    		}else {
		    			System.out.print("NO");return;
		    		}
		    	}else if(n==2) {
		    		if(s.contains("00")||s.contains("11")) {
		    			System.out.print("NO");return;
		    		}else {
		    			System.out.print("Yes");return;
		    		}
		    	}
		    	else if(s.contains("000")||s.contains("11")) {
		    		System.out.print("NO");return;
		    	}
		    	else	if(s.charAt(0)=='0'&&s.charAt(1)=='0'&&s.charAt(2)=='1') {
		    		System.out.print("NO");return;
		    	}
		    	else	if(s.charAt(i)=='0'&&s.charAt(i-1)=='0') {
		    		System.out.print("NO");
		    		return;
		    		}
		    	 System.out.print("YES");
		    }
		}
		 