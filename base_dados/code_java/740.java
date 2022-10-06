import java.util.Scanner;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        byte n, i = 0, number;
        boolean flag = false;
        n = sc.nextByte();
        do{
            number = sc.nextByte();
            if(number == 1){
                System.out.println("HARD");
                flag = true;
                break;
            }
            i++;
        }while(i < n);
        if(!flag)
            System.out.println("EASY");
        
    }
}
