import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String args[]) {new Main().run();}
	
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	void run(){
	    int q=in.nextInt();
	    for(int i=0;i<q;i++){
	        out.println(work());
	    }
	    out.flush();
	}
	int work() {		
		int n=in.nextInt();
	    int k=in.nextInt();
	    String str=in.next();
	    char[] chs=new char[]{'R','G','B'};
	    int c1=0,c2=0,c3=0;
	    int ret=99999999;
	    for(int i=0,p1=0,p2=1,p3=2;i<n;i++,p1=(p1+1)%3,p2=(p2+1)%3,p3=(p3+1)%3){
	        char ch=str.charAt(i);
	        //c1
	        if(ch!=chs[p1]){
	            c1++;
	        }
	        if(i>=k){
	            char pre1=str.charAt(i-k);
	            char pre2=chs[((p1-(k%3))+3)%3];
	            if(pre1!=pre2){
	                c1--;
	            }
	        }
	        if(i+1>=k){
	            ret=Math.min(ret,c1);
	        }
	        
	        //c2
	        if(ch!=chs[p2]){
	            c2++;
	        }
	        if(i>=k){
	            char pre1=str.charAt(i-k);
	            char pre2=chs[((p2-(k%3))+3)%3];
	            if(pre1!=pre2){
	                c2--;
	            }
	        }
	        if(i+1>=k){
	            ret=Math.min(ret,c2);
	        }
	        
	        //c3
	        if(ch!=chs[p3]){
	            c3++;
	        }
	        if(i>=k){
	            char pre1=str.charAt(i-k);
	            char pre2=chs[((p3-(k%3))+3)%3];
	            if(pre1!=pre2){
	                c3--;
	            }
	        }
	        if(i+1>=k){
	            ret=Math.min(ret,c3);
	        }
	    } 
	    return ret;
	   
	}
}
