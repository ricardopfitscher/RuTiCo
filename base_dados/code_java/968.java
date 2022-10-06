import java.util.Scanner;

/**
 *
 * @author User
 */
public class Code {

   static int [] reverse(int a[]) 
    { 
        int[] b = new int[a.length]; 
       int j = 0  ;
        for (int i = a.length-1; i >= 0; i--) {
            b[i] = a[j] ; 
            j++;
        }
        return b ;
    }
    public static void main(String[] args) {
        int pas ; 
        int top ; 
        Scanner in = new Scanner(System.in) ; 
        pas= in.nextInt(); 
        top=in.nextInt() ; 
        int a [] = new int[pas] ; 
        int b [] = new int[pas] ; 
        
        for (int i = 0; i < pas; i++) {
            a[i] = in.nextInt() ; 
            b[i] = in.nextInt() ; 
           
         }
       a =  reverse(a) ;
        b = reverse(b) ;
        int ftime =0 ; 
        int t;
        int po = top ; 
        for (int i = 0; i < pas; i++) {
             ftime+=(po-a[i]) ; 
            t = Math.max(b[i]-ftime, 0) ; 
            ftime+=t ; 
            po = a[i] ; 
           
        }
        if(po!=0) ftime+=po ;
        System.out.println(ftime);
        
    }
    
}
