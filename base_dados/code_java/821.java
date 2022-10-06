 import java.util.Scanner;
    public class New_Year_and_Curling {
        static final double E = 0.00001;
 
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
 
            int n = sc.nextInt();
            int r = sc.nextInt();
            double[] y = new double[n];
            int arr[] = new int[n];
 
            for (int i = 0; i < n; i++) {
                arr[i] =sc.nextInt();
                double top = r; // if we make it 0 and subtract from the result will get WA (do not know why!!!)
                int x = arr[i];
                for(int  j =0 ;j<i;j++)
                {
                    if(Math.abs(arr[j] -x )<=2*r) {
 
                            top = Math.max(top  , y[j] + Math.sqrt((4 * r * r) - ((arr[j] - x) * (arr[j] - x))));
 
                    }
                }
                y[i] = top ;
                double res = y[i] ;
                System.out.print(res+" ");
            }
 
        }
 
    }