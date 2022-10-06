import java.util.*;
import java.io.*;
public class code{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int ok,ok2;
        int va,vb;
        va = 0;
        vb = 0;
        out.println("? "+va+" "+vb);
        out.flush();
        ok = sc.nextInt();
        for(int i=29;i>=0;i--){
            if(ok==0){
                va += (1<<i);
                out.println("? "+va+" "+vb);
                out.flush();
                ok2 = sc.nextInt();
                if(ok2==1){
                    va -= (1<<i);
                }else{
                    vb += (1<<i);
                }
            }else{
                va += (1<<i);
                vb += (1<<i);
                out.println("? "+va+" "+vb);
                out.flush();
                ok2 = sc.nextInt();
                if(ok==ok2){
                    vb -= (1<<i);
                    out.println("? "+va+" "+vb);
                    out.flush();
                    ok2 = sc.nextInt();
                    if(ok2==1){
                        va -= (1<<i);
                    }else{
                        vb += (1<<i);
                    }
                }else{
                    if(ok==1){
                        vb -= (1<<i);
                        out.println("? "+va+" "+vb);
                        out.flush();
                        ok = sc.nextInt();
                    }
                    else {
                        va -= (1<<i);
                        out.println("? "+va+" "+vb);
                        out.flush();
                        ok = sc.nextInt();
                    }
                }
            }
        }
        out.println("! "+va+" "+vb);
        out.flush();
    }
}