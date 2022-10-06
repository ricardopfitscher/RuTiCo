import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double a = (double)read.nextInt();
        double v = (double)read.nextInt();
        double l = (double)read.nextInt();
        double d = (double)read.nextInt();
        double w = (double)read.nextInt();
        double t=0;
        if(w>=v){
            double d1=v*v/(2*a);
            if(d1>l){
                t+= Math.sqrt(2*l/a);
            }
            else{
                t+= v/a + (l-d1)/v;
            }
        }
        else{
            double temp = (v-w)/a;
            double d1 = v*v/(2*a);
            double d2 = d - v*temp + a*temp*temp/2;
            if(d1>d2){
                double temp2 = Math.sqrt(2*a*d);
                if(temp2<w){
                    w=temp2;
                    temp=(v-w)/a;
                    t+= temp2/a;
                }
                else{
                    double vx=Math.sqrt(v*v/2+a*d2);
                    t+= (vx/a) + ((vx-w)/a);
                }
            }
            else{
                t+= (v/a) + ((d2-d1)/v) + (temp);
            }
            double d3 = d + w*temp + a*temp*temp/2;
            if(d3>l){
                t+= (-w+Math.sqrt(w*w+2*a*(l-d)))/a;
            }
            else{
                t+= (temp) + ((l-d3)/v);
            }
        }
        System.out.printf("%.6f", t);
        read.close();
    }
}