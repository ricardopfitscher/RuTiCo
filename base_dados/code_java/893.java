
import java.math.BigInteger;
import java.util.Scanner;


public class Main {
	static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	char str[][] = new char[5][n];
        for(int i = 0;i < 4;i ++){
        	for(int j = 0;j < n;j ++)
                str[i][j] = '.';
        }
        if(k % 2 == 0){
            k /= 2;
            for(int i = 1;i <= 2;i++){
                for(int j = 1;j <= k;j++)
                     str[i][j] = '#'; 
            }
        }
        else{
            str[1][n / 2] = '#';
            if(k != 1){
                int tmp = n / 2;
                if(k <= n - 2){
                    for(int i = 1;i<= (k - 1) / 2;i++){
                        str[1][i] = '#';
                        str[1][n - 1 - i] = '#';
                    }
                }
                else{
                    for(int i = 1;i <= n - 2;i++) str[1][i] = '#';
                    k -= n - 2;
                    for(int i = 1;i <= k/2;i++){
                        str[2][i] = '#';
                        str[2][n - 1 - i]='#';
                    }
                }
     
            }
        }
        System.out.println("YES");
        for(int i = 0;i < 4;i ++){
        	System.out.println(str[i]);
        }
    }
 }