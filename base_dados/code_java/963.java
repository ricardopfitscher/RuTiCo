/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ahmed
 */




public class Watermelon {

   static class Passengers {
  
     public int floor ;
     public int time;
     
     
     public Passengers( int floor  , int time){
         this.floor =floor;
         this.time =time;
     }
     
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        
        int x = in.nextInt() , y = in.nextInt();
        
        ArrayList<Passengers> list = new ArrayList<>();
        
        for(int i = 1 ; i <= x ; ++i){
            list.add(new Passengers(in.nextInt(), in.nextInt()));
        }
        
        int sum = 0 ;
       for(int i = list.size() - 1 ; i >= 0 ; --i)
       {
          int s = y -  list.get(i).floor;
          sum = sum + s ; 
          
          if(sum < list.get(i).time)
          {
              sum = sum + ( list.get(i).time - sum);
          }
          
          y = list.get(i).floor;
       } 
        
        
       if( list.get(list.size() - 1).floor != 0){
           sum = sum  + (list.get(0).floor);
       }
        System.out.println(sum);
    }
    
}
