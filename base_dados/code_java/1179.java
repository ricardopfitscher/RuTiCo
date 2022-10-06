//Author: Patel Rag
//Java version "1.8.0_211"
import java.util.*;
import java.io.*;

public class Main
{
  static class FastReader
  {
    BufferedReader br;
    StringTokenizer st;

    public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in)); }

    String next()
    {
      while (st == null || !st.hasMoreElements())
      {
        try
        {
          st = new StringTokenizer(br.readLine());
        }
        catch (IOException  e)
        {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong(){ return Long.parseLong(next()); }

    double nextDouble(){ return Double.parseDouble(next()); }

    float nextFloat() { return Float.parseFloat(next()); }

    boolean nextBoolean() { return Boolean.parseBoolean(next()); }

    String nextLine()
    {
      String str = "";
      try
      {
        str = br.readLine();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      return str;
    }
  }
  static long modExp(long x, long n, long mod)    //binary Modular exponentiation
  {
    long result = 1;
    while(n > 0)
    {
        if(n % 2 == 1)
            result = (result%mod * x%mod)%mod;
        x = (x%mod * x%mod)%mod;
        n=n/2;
    }
    return result;
  }
  static long gcd(long a, long b)
  {
    if(a==0) return b;
    return gcd(b%a,a);
  }
  public static void main(String[] args)
  throws IOException
  {
    FastReader fr = new FastReader();
    long[] dat = new long[14];
    for(int i = 0; i < 14; i++) dat[i] = fr.nextLong();
    long res = 0;
    for(int i = 0; i < 14; i++)
    {
      long all = dat[i]/14;
      long last = dat[i]%14;
      long tot = 0;
      for(int j = 1; j < 14; j++)
      {
        int nex = (j + i)%14;
        long ava = dat[nex] + all;
        if(j <= last)
        {
           ava++;
          if(ava%2 == 0) tot = tot + ava;
        }
        else
        {
          if(ava%2 == 0) tot = tot + ava;
        }
      }
      if(all%2 == 0) tot = tot + all;
      res = Long.max(res,tot);
    }
    System.out.println(res);

  }
}
class pair
{
  public int first;
  public int second;
  public pair(int first,int second)
  {
    this.first = first;
    this.second = second;
  }
  public pair(pair p)
  {
    this.first = p.first;
    this.second = p.second;
  }
  public int first() { return first; }
  public int second() { return second; }
  public void setFirst(int first) { this.first = first; }
  public void setSecond(int second) { this.second = second; }
}
class myComp implements Comparator<pair>
{
  public int compare(pair a,pair b)
  {
    if(a.first != b.first) return (a.first - b.first);
    return (b.second - a.second);
  }
}

class BIT       //Binary Indexed Tree aka Fenwick Tree
{
  public long[] m_array;

  public BIT(long[] dat)
  {
    m_array = new long[dat.length + 1];
    Arrays.fill(m_array,0);
    for(int i = 0; i < dat.length; i++)
    {
      m_array[i + 1] = dat[i];
    }
    for(int i = 1; i < m_array.length; i++)
    {
      int j = i + (i & -i);
      if(j < m_array.length)
      {
        m_array[j] = m_array[j] + m_array[i];
      }
    }
  }

  public final long prefix_query(int i)
  {
    long result = 0;
    for(++i; i > 0; i = i - (i & -i))
    {
      result = result + m_array[i];
    }
    return result;
  }

  public final long range_query(int fro, int to)
  {
    if(fro == 0)
    {
      return prefix_query(to);
    }
    else
    {
      return (prefix_query(to) - prefix_query(fro - 1));
    }
  }

  public void update(int i, long add)
  {
    for(++i; i < m_array.length; i = i + (i & -i))
    {
      m_array[i] = m_array[i] + add;
    }
  }
}
