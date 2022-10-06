/*
Roses are red
Memes are neat
All my test cases time out
Lmao yeet
*/
import java.util.*;
import java.io.*;

   public class A
   {
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in)); 
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int L = Integer.parseInt(st.nextToken());
         int A = Integer.parseInt(st.nextToken());
         int[] arr1 = new int[N];
         int[] arr2 = new int[N];
         for(int i=0; i < N; i++)
         {
            st = new StringTokenizer(infile.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken())+x;
            arr1[i] = x;
            arr2[i] = y;
         }
         int res = 0;
         for(int i=1; i < N; i++)
            res += (arr1[i]-arr2[i-1])/A;
         if(N > 0)
            res += (L-arr2[N-1])/A+arr1[0]/A;
         else
            res += L/A;
         System.out.println(res);
      }
   }