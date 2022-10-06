 import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;
import java.math.BigInteger.*;
import java.util.Arrays; 

public class   CF111111
{
  BufferedReader in;
  StringTokenizer as;
  int nums[],nums2[];
  int[] nums1[];
  boolean con = true;
 
  ArrayList < Integer >  ar = new ArrayList < Integer >();
  ArrayList < Integer >  fi = new ArrayList < Integer >();
  Map<Integer,Integer > map = new HashMap<Integer, Integer>();
  public static void main (String[] args)
  {
    new CF111111  ();
  }
  
  public int GCD(int a, int b) {
    if (b==0) return a;
    return GCD(b,a%b);
  }
  
  public int LIS(int arr[])
  {
    int n = arr.length;
    int sun[] = new int [n];
    int cur = 0;
    for(int x = 0;x<n;x++)
    {
      int temp = Arrays.binarySearch(sun,0,cur,arr[x]);
      if(temp < 0)
        temp = -temp -1;
      sun[temp] = arr[x];
      if(temp == cur)
        cur++;
    }
    return cur;
    
  }
  
  
  public void no()
  {
    System.out.println("NO");
    System.exit(0);
  }
  
  public CF111111  ()
  {
    try
    {
      
      in = new BufferedReader (new InputStreamReader (System.in));
      int a = nextInt();
      nums = new int [a];
      int max = -1;
      int index = -1;
     for(int x = 0;x<a;x++)
     {
       nums[x] = nextInt();
       if(nums[x] > max)
       {
         max = nums[x];
         index = x;
       }
     }
      int lindex = index-1;
      int rindex = index+1;
      int done = 1;
      int top = max;
      for(;;)
      {
        done++;
      //  System.out.println(done + " " + lindex + " " + rindex);
        if(lindex < 0)
        {
           if(nums[rindex] > top)
           {
             no();
           }
           else
             top = nums[rindex];
           rindex++;
        }
        else if(rindex >= a)
        {
          if(nums[lindex] > top)
            no();
          else
            top = nums[lindex];
          lindex--;
        }
        else
        {
          if(nums[lindex] > top || nums[rindex] > top)
            no();
          else
          {
            if(nums[lindex] > nums[rindex])
            {
              top = nums[lindex];
              lindex--;
            }
            else
            {
              top = nums[rindex];
              rindex++;
            }
          }
        }
        if(done == a)
        {
          System.out.println("YES");
          System.exit(0);
        }
      }
    }
    catch(IOException e)
    {

    }
  }
  
  
  
  
  
  
  
  String next () throws IOException
  {
    while (as == null || !as.hasMoreTokens ())
    {
      as = new StringTokenizer (in.readLine ().trim ());
    }
    
    
    return as.nextToken ();
  }
  
  
  
  long nextLong () throws IOException
  {
    return Long.parseLong (next ());
  }
  
  
  int nextInt () throws IOException
  {
    return Integer.parseInt (next ());
  }
  
  
  double nextDouble () throws IOException
  {
    return Double.parseDouble (next ());
  }
  
  
  String nextLine () throws IOException
  {
    return in.readLine ().trim ();
  }
}