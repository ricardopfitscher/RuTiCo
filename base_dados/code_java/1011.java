import java.io.*;
import java.util.*;

public class Main
	{	
		class node{
		int data;
		node next;
		public node(int val){
			data=val;
			next=null;
		}
	}
	class linkedlist{
		node start;
		node end;
		int size;
		int turn;
		public linkedlist(){
			start=null;
			end=null;
			size=0;
		}
		void add(int val){
			if(size==0){
				node t=new node(val);
				start=t;
				end=t;
				size++;
			}
			else{
				node t=new node(val);
				end.next=t;
				end=end.next;
				size++;
			}
		}
		void myfunc(){
			if(start.data>start.next.data){
				// System.out.println("me ni hu");
				node t=new node(start.next.data);
				start.next=start.next.next;
				end.next=t;
				end=end.next;
			}
			else{
				// System.out.println("me hu");
				int t=start.data;
				start=start.next;
				add(t);
				size--;
			}
		}
		int findmax(){
			int m=0;
			node temp=start;
			for(int i=0;i<size;i++){
				if(temp.data>m){
					m=temp.data;
				}
				temp=temp.next;
			}
			return m;
		}
		void display(){
			node temp=start;
			for(int i=0;i<size;i++){
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println("");
		}
	}
	linkedlist l;
	public Main(){
		l=new linkedlist();
	}
	public static void main(String [] argv) throws IOException
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		Main ma=new Main();
		String[] l1=in.readLine().split(" ");
		int n=Integer.parseInt(l1[0]);
		int q=Integer.parseInt(l1[1]);
		String[] ar=in.readLine().split(" ");
		int a1=Integer.parseInt(ar[0]);
		int b1=Integer.parseInt(ar[1]);
		for(int i=0;i<n;i++){
			ma.l.add(Integer.parseInt(ar[i]));
		}
		int m=ma.l.findmax();
		int[][] pair=new int[n][2];
		int t=0;
		for(int i=0;i<n;i++){
			if(ma.l.start.data==m)
				break;
			ma.l.myfunc();
			pair[t][0]=ma.l.start.data;
			pair[t][1]=ma.l.start.next.data;
			t++;
		}
		int rl[]=new int[n];
		node temp=ma.l.start;
		for(int i=0;i<n;i++){
			rl[i]=temp.data;
			temp=temp.next;
		}
		for(int i=0;i<q;i++){
			long a=Long.parseLong(in.readLine());
			if(a==1){
				System.out.println(a1 + " " + b1);
			}
			else{
				if(a<=t+1){
					System.out.println(pair[(int)(a-2)][0]+" "+pair[(int)(a-2)][1]);
				}
				else{
					if((a-t)%(n-1)==0){
						System.out.println(rl[0]+" "+rl[n-1]);
					}
					else{
						System.out.println(rl[0]+" "+rl[(int)((a-t)%(n-1))]);
					}
				}
			}
		}
	}
}