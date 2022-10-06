/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package newpackage;
import java.util.*;
/**
 *
 * @author parpaorsa
 */
public class NewClass {
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt(),ans=Integer.MAX_VALUE,t=0;
        String x = in.next();
        for (int i = 0; i < n; i++) {
            if(x.charAt(i)=='-')t--;
            else t++;
            ans=Math.min(ans,t);
        }
           if(ans <= 0) 
               System.out.println(Math.abs(ans)+t);
           else 
               System.out.println(t);
    }
 
}
