		
							import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
											public class Solution1 implements Runnable
											{
												static final long MAX = 1000000007L;
												static class InputReader
												{
													private InputStream stream;
													private byte[] buf = new byte[1024];
													private int curChar;
													private int numChars;
													private SpaceCharFilter filter;
													private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
											 
													public InputReader(InputStream stream)
													{
														this.stream = stream;
													}
													
													public int read()
													{
														if (numChars==-1) 
															throw new InputMismatchException();
														
														if (curChar >= numChars)
														{
															curChar = 0;
															try 
															{
																numChars = stream.read(buf);
															}
															catch (IOException e)
															{
																throw new InputMismatchException();
															}
															
															if(numChars <= 0)				
																return -1;
														}
														return buf[curChar++];
													}
												 
													public String nextLine()
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
													public int nextInt()
													{
														int c = read();
														
														while(isSpaceChar(c)) 
															c = read();
														
														int sgn = 1;
														
														if (c == '-') 
														{
															sgn = -1;
															c = read();
														}
														
														int res = 0;
														do 
														{
															if(c<'0'||c>'9') 
																throw new InputMismatchException();
															res *= 10;
															res += c - '0';
															c = read();
														}
														while (!isSpaceChar(c)); 
														
														return res * sgn;
													}
													
													public long nextLong() 
													{
														int c = read();
														while (isSpaceChar(c))
															c = read();
														int sgn = 1;
														if (c == '-') 
														{
															sgn = -1;
															c = read();
														}
														long res = 0;
														
														do 
														{
															if (c < '0' || c > '9')
																throw new InputMismatchException();
															res *= 10;
															res += c - '0';
															c = read();
														}
														while (!isSpaceChar(c));
															return res * sgn;
													}
													
													public double nextDouble() 
													{
														int c = read();
														while (isSpaceChar(c))
															c = read();
														int sgn = 1;
														if (c == '-') 
														{
															sgn = -1;
															c = read();
														}
														double res = 0;
														while (!isSpaceChar(c) && c != '.') 
														{
															if (c == 'e' || c == 'E')
																return res * Math.pow(10, nextInt());
															if (c < '0' || c > '9')
																throw new InputMismatchException();
															res *= 10;
															res += c - '0';
															c = read();
														}
														if (c == '.') 
														{
															c = read();
															double m = 1;
															while (!isSpaceChar(c)) 
															{
																if (c == 'e' || c == 'E')
																	return res * Math.pow(10, nextInt());
																if (c < '0' || c > '9')
																	throw new InputMismatchException();
																m /= 10;
																res += (c - '0') * m;
																c = read();
															}
														}
														return res * sgn;
													}
													
													public String readString() 
													{
														int c = read();
														while (isSpaceChar(c))
															c = read();
														StringBuilder res = new StringBuilder();
														do 
														{
															res.appendCodePoint(c);
															c = read();
														} 
														while (!isSpaceChar(c));
														
														return res.toString();
													}
												 
													public boolean isSpaceChar(int c) 
													{
														if (filter != null)
															return filter.isSpaceChar(c);
														return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
													}
												 
													public String next() 
													{
														return readString();
													}
													
													public interface SpaceCharFilter 
													{
														public boolean isSpaceChar(int ch);
													}
												}
											 	
												public static void main(String args[]) throws Exception
												{
													new Thread(null, new Solution1(),"Solution1",1<<26).start();
												}
												long gcd(long a, long b)
											    {
											        if (a == 0)
											            return b;
											         
											        return gcd(b%a, a);
											    }
											    // method to return LCM of two numbers
												 long lcm(long a, long b)
												    {
												        return (a*b)/gcd(a, b);
												    }
												 int root(int a){
													 while(arr[a] != a){
														 arr[a] = arr[arr[a]];
														 a = arr[a];
													 }
													 return a;
												 }
												 void union(int a,int b){
													 int xroot = root(a);
													 int yroot = root(b);
													 if(arr[xroot] < arr[yroot]){
														 arr[xroot] = yroot;
													 }else{
														 arr[yroot] = xroot;
													 }
												 }
												 boolean find(int a,int b){
													 int roota = root(a);
													 int rootb = root(b);
													 if(roota == rootb){
														 return true;
													 }else{
														 return false;
													 }
												 }
												 int[] arr;
												 final int level = 20;
												 
												public void run()
												{
													InputReader sc= new InputReader(System.in);
													PrintWriter w= new PrintWriter(System.out);
													int n = sc.nextInt();
													char[] ch = new char[n];
													char[] ch2 = new char[n];
													ch = sc.next().toCharArray();
													ch2 = sc.next().toCharArray();
													HashSet<Integer> hset[] = new HashSet[26];
													for(int i = 0;i < 26;i++){
														hset[i]  =new HashSet();
													}
													int count = 0;
													for(int i = 0;i < ch.length;i++){
														if(ch[i] != ch2[i]){
															hset[ch[i]-97].add(ch2[i]-97);
															count++;
														}
													}
													boolean flag = false;
													int swap1 = -1;
													int swap2 = -1;
													int rem = -1;
													for(int i = 0;i < ch.length;i++){
														if(ch[i] != ch2[i]){
															if(hset[ch2[i]-97].size() != 0){
																swap1 = i;
																flag = true;
																if(hset[ch2[i]-97].contains(ch[i]-97)){
																	rem = i;
																	count-=2;
																	flag = false;
																	break;
																}
															}
														}
													}
													if(flag){
														count--;
														w.println(count);
														for(int i = 0;i < n;i++){
															if(i != swap1 && ch[i] == ch2[swap1] && ch[i] != ch2[i]){
																w.println((swap1+1) + " " + (i+1));
																w.close();
																System.exit(0);
															}
														}
													}else{
														if(rem == -1){
															w.println(count);
															w.println("-1 -1");
														}else{
															w.println(count);
															for(int i = 0;i < n;i++){
																if(i != rem && ch[i] == ch2[rem] && ch[rem] == ch2[i] && ch[i] != ch2[i]){
																	w.println((rem+1) + " " + (i+1));
																	w.close();
																	System.exit(0);
																}
															}
														}
													}
													w.close();
												}
												boolean fun(long[] prefix,long mid,long temp,long[] arr){
													if(temp >= prefix[(int)mid]){
														return true;
													}
													return false;
												}
												static class Pair implements Comparable<Pair>{
													int x;
													int y;
													
													Pair(){}	
													Pair(int x,int y){
														this.x = x;
														this.y = y;
													
														
													}
													public int compareTo(Pair p){
														
														return Long.compare(this.x,p.x);
													}
												}
								}