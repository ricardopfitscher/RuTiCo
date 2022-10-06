import java.util.*;
import java.util.Scanner;
public class task1{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int pos=in.nextInt();
        int l=in.nextInt();
        int r=in.nextInt();
        boolean b=false;
        boolean c=true;
        if(l==1&&r==n){
            c=false;
            System.out.println(0);
        }
        if(c){
            if(l==1){
            if(pos<r){
                System.out.println(r-pos+1);
                b=true;}
            else{
                System.out.println(pos-r+1);
                b=true;
            }
        }
        if(r==n){
            if(pos>l){
                System.out.println(pos-l+1);
                b=true;}
            else{
                System.out.println(l-pos+1);
                b=true;
            }
        }
        }
        if(b==false&&c){
            if(pos<l){
            System.out.println(l-pos+1+r-l+1);
        }
        else if(pos>r){
            System.out.println(pos-r+1+r-l+1);
        }
        else{
            if(((pos-l)<(r-pos))){
                System.out.println(pos-l+1+r-l+1);
                
            }
            
            else if((pos-l)>(r-pos)){
                System.out.println(r-pos+1+r-l+1);
                
            }
            else{
                System.out.println((r-pos)*3+2);
                
            }
        }
        }
        
    }
}