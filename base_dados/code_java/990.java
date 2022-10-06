//q4

import java.io.*;
import java.util.*;
import java.math.*;


public class q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int query = in.nextInt();
        
        while (query -- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            
            char[] arr = new char[n];
            //slot all n into char array
            String code = in.next();
            for (int i = 0; i < n; i++) {
                arr[i] = code.charAt(i);
                
            }
            
            //R, G, B cycle
            int r = 0;
            int g = 0;
            int b = 0;
            
            for (int i = 0; i < k; i++) {
                if (i % 3 == 0) {
                    if (arr[i] == 'R') {g++; b++;}
                    else if (arr[i] == 'G') {r++; b++;}
                    else {r++; g++;} //if is 'B'
                } else if (i % 3 == 1) {
                    if (arr[i] == 'G') {g++; b++;}
                    else if (arr[i] == 'B') {r++; b++;}
                    else {r++; g++;} //if is 'R'
                } else { //if mod 3 is 2
                    if (arr[i] == 'B') {g++; b++;}
                    else if (arr[i] == 'R') {r++; b++;}
                    else {r++; g++;} //if is 'G'     
                }
            }
            
            //starting from kth position, if different then add 1, and check (j-k)th position
            int rMin = r;
            int gMin = g;
            int bMin = b;
            for (int j = k; j < n; j++) {
                //R cycle
                if ((j % 3 == 0 && arr[j] != 'R') ||  
                    (j % 3 == 1 && arr[j] != 'G') ||
                    (j % 3 == 2 && arr[j] != 'B')) {
                    r++;
                }
                //R cycle 
                if (((j - k) % 3 == 0 && arr[j - k] != 'R') ||  
                    ((j - k) % 3 == 1 && arr[j - k] != 'G') ||
                    ((j - k) % 3 == 2 && arr[j - k] != 'B')) {
                    r--;
                }
                rMin = Math.min(r, rMin);
                //G cycle
                if ((j % 3 == 0 && arr[j] != 'G') ||  
                    (j % 3 == 1 && arr[j] != 'B') ||
                    (j % 3 == 2 && arr[j] != 'R')) {
                    g++;
                } 
                if (((j - k) % 3 == 0 && arr[j - k] != 'G') ||  
                    ((j - k) % 3 == 1 && arr[j - k] != 'B') ||
                    ((j - k) % 3 == 2 && arr[j - k] != 'R')) {
                    g--;
                }      
                gMin = Math.min(gMin, g);
                //B cycle
                if ((j % 3 == 0 && arr[j] != 'B') ||  
                    (j % 3 == 1 && arr[j] != 'R') ||
                    (j % 3 == 2 && arr[j] != 'G')) {
                    b++;
                }       
                if (((j - k) % 3 == 0 && arr[j - k] != 'B') ||  
                    ((j - k) % 3 == 1 && arr[j - k] != 'R') ||
                    ((j - k) % 3 == 2 && arr[j - k] != 'G')) {
                    b--;
                } 
                bMin = Math.min(bMin, b);
                
            }
            
            System.out.println(Math.min(Math.min(rMin, gMin), bMin));
            
        }
        
    } 
    
}