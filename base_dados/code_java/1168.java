import java.util.*;
public class mad{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cura = 0,curb = 0;
        int ver;
        System.out.println("? 0 0");
        System.out.flush();
        ver = sc.nextInt();
        for(int i=29;i>=0;i--){
            System.out.println("? "+(cura+(1<<i))+" "+curb);
            System.out.flush();
            int temp1 = sc.nextInt();
            System.out.println("? "+cura+" "+(curb+(1<<i)));
            System.out.flush();
            int temp2 = sc.nextInt();
            if(temp1!=temp2){
                if(temp2==1){
                    cura += (1<<i);
                    curb += (1<<i);
                }
            }
            else{
                if(ver==1) cura += (1<<i);
                if(ver==-1) curb += (1<<i);
                
                ver = temp1;
            }
        }
        System.out.println("! "+cura+" "+curb);
    }
    
}