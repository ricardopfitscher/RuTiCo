import java.io.*;
import java.util.*;
public class Codechef{
      

    public static void main(String []args){
       Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
		Set<HashSet> s3 = new HashSet<>();

      
         for(int j=0;j<n;j++){
         	String a=sc.next();
         HashSet<Character> t = new HashSet<Character>();
			for(char c:a.toCharArray()){
			t.add(c);
			}

        s3.add(t);
    
          

         }
         System.out.println(s3.size());
    }
}