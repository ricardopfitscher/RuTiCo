

import java.util.*;
import java.lang.*;
public class CodeForce {
    
    
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String s=sc.next();
            String t=sc.next();
            int count=s.length()+t.length();
            for(int i=0;i<Math.min(s.length(), t.length());i++){
                if(s.charAt(s.length()-1-i)==t.charAt(t.length()-1-i))count=count-2;
                else break;
            }
            System.out.println(count);
            
            
            
            
           
            
                
        }    
    }


