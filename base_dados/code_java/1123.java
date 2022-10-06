import java.io.*;
public class coins
{
 public static void main(String args[])throws IOException
 {
  InputStreamReader read=new InputStreamReader(System.in);
  BufferedReader in=new BufferedReader(read);
  int i,k,n,v;
  String a;
  a=in.readLine();
  for(i=0;i<a.length();i++)
  {
   if(a.charAt(i)==' ')
   break;
  }
  n=Integer.parseInt(a.substring(0,i));
  v=Integer.parseInt(a.substring(i+1));
  k=v%n;
  v=v/n;
  if(k>0)
  v++;
  System.out.println(v);
 }
}
