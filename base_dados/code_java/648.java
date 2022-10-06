//package codeforces;
import java.util.Scanner;
public class ex5 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String S [] = new String[3];
	
	int m=0,s=0,p=0;
	int temp=0;
	
	for (int i = 0; i < S.length; i++) {
		S[i]=scan.next();
		if(S[i].indexOf('m')!=-1) m++;
		if(S[i].indexOf('s')!=-1) s++;
		if(S[i].indexOf('p')!=-1) p++;
	}
	
	
	int n1 = Integer.parseInt(S[0].substring(0,1));
	int n2 = Integer.parseInt(S[1].substring(0,1));
	int n3 = Integer.parseInt(S[2].substring(0,1));
	
	
	
	    int d3 = Math.abs(n1-n2);
		int d4 = Math.abs(n1-n3);
		int d5 = Math.abs(n2-n3);
		
	
	if(m==3||s==3||p==3) {
		
		    if(d3==1&d5==1&d4==2||d3==1&d4==1&d5==2||d5==1&d4==1&d3==2)
			System.out.println(0);
		else 
		    if(d3==0&d4==0) System.out.println(0);
		else 
			if(d3<d5&d3<d4) {
			    if(d3==1||d3==2||d3==0) System.out.println(1);
		        else                 System.out.println(2);
			    }
			else if (d5<d4&d5<d3){
				 if(d5==1||d5==2||d5==0) System.out.println(1);
					else                 System.out.println(2);
			}
			else if(d4<d5&d4<d3) {
				if(d4==1||d4==2||d4==0) System.out.println(1);
				else                 System.out.println(2);
			}
			else if(d3==2&d5==2||d4==2&d5==2||d3==2&d4==2||d3==1&d5==1||d4==1&d5==1||d3==2&d4==1)
				System.out.println(1);
			else System.out.println(2);
			
			
		
		 
		    
		    
	}
	
	if(m==2||s==2||p==2) {
		
		
		
		char c1 = S[0].charAt(1);
		char c2 = S[1].charAt(1);
		char c3 = S[2].charAt(1);
		
		
		if(c1==c2) {
			if(n1==n2) System.out.println(1);
			else if(d3==1||d3==2) System.out.println(1);
			else System.out.println(2);
		}
		if(c1==c3) {
			if(n1==n3) System.out.println(1);
			else if(d4==1||d4==2) System.out.println(1);
			else System.out.println(2);
		}
		if(c2==c3) {
			if(n2==n3) System.out.println(1);
			else if(d5==1||d5==2) System.out.println(1);
			else System.out.println(2);
		}
	}
	
	if(m==1&s==1&p==1) System.out.println(2);
		
	
	
}
}
