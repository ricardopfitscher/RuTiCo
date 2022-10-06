import java.util.*;
import java.io.*;



 public class Param
{
                
      public static  void main( String[]args) 
    {
       MyScanner param = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
       long l2 =param.nextLong();
       long dice1=param.nextLong();
       long dice2=param.nextLong();
      
       long l1=1;
       long r1=1;
       long r2=l2;
       long count=0;
       long check=0;
       count=l2-dice1;
       count=count+(r2-dice2);
       check=dice1-l1;
       check=check+(dice2-r1);
       if(check<=count){
          System.out.println("White");
       }
       else{
          System.out.println("Black");
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
   