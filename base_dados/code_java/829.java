
 import java.io.*;

import java.util.*;
import java.util.Collections;
import java.util.Arrays;


public class Codechef {
     

  public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int a=sc.nextInt();
    int b=sc.nextInt();
      int res=0;
     for(int i=1;i<n;i++)
     res=Math.max(res, Math.min(a/i, b/(n-i) ) );
     System.out.println(res);
  }

   }
  








