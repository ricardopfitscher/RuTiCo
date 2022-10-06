
import java.io.*;
import java.util.Scanner;
public class abc{
    public static int check(StringBuilder s)
    {
    	int countRemove=0;
    	if(!s.toString().contains("xxx")) return countRemove;
    	else{
    		
    		for(int i=1;i<s.length()-1;i++)
    		{
    			if(s.charAt(i-1)=='x' && s.charAt(i)=='x' && s.charAt(i+1)=='x')
    			{
    			
    				countRemove++;
    			}
    		}
    		return countRemove;
    	}
    }
   
	public static void main (String[] args) {
	
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	//sc= new Scanner(System.in);
	String s = sc.next();
	StringBuilder sb = new StringBuilder("");
	sb.append(s);
	
    System.out.println(check(sb));
	
	
	
	}
}