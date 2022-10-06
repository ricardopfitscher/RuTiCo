import java.util.*;
public class java{
          public static void main(String[]arg) {
        	 Scanner sc=new Scanner(System.in); 
        	 int x=sc.nextInt();
        	 String s=sc.next();
        	 boolean f=true;
        	 boolean f2=true;
        	 boolean f3=true;
        	 boolean f4=true;
        	 int v=0;
        	 for(int i=0;i<s.length()-1;i++) {
        		 if(s.charAt(i)==s.charAt(i+1)&&(s.charAt(i)!='?'||s.charAt(i+1)!='?')) {
        			 f=false;
        			 break;
        		 }else {
        			 f=true;
        		 }
        	 }
        	
        	 
        	 for(int i=0;i<s.length();i++) {
        		 if(s.charAt(i)=='?') {
        			 
        			 if(i==0||i==s.length()-1) {
        				 f2=true; 
        				 v++;
        			 }else if(s.charAt(i)==s.charAt(i+1)) {
        					 f2=true;
        					 v++;
        			          }
        			 else if(s.charAt(i-1)==s.charAt(i+1)&&i!=0&&i!=s.length()-1) {
        					 f2=true;
        					 v++;
        			         }
        			 }else {
        				 if(v>0) f2=true;
        				 else f2=false;
        			 }
        		 }
        	 
        	if(f&&f2) {
        		System.out.println("YES");
        	}else {
        		System.out.println("NO");
        	}
          }
          
}
