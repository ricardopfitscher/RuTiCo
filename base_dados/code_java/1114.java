import java.util.*;
import java.io.*;



 public class Param
{
                
      public static  void main( String[]args) 
    {
       MyScanner param = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      int highestcoin=param.nextInt();
      int sum=param.nextInt();
      int remainder=sum%highestcoin;
      if(remainder!=0){
         remainder=1;
      }
      else{
         remainder=0;
      }
      int count=(sum-remainder)/highestcoin;
     
       if (highestcoin>=sum){
         System.out.println("1");
      }
      else{
      System.out.println(count+remainder);
      }
      out.close();
}
public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }
}
}
   