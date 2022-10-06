import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int hp = scanner.nextInt();
        if (hp%4 == 1){
            System.out.println("0 A");
        }
        else if (hp%4 == 2){
            System.out.println("1 B");
        }
        else if (hp%4 == 3){
            System.out.println("2 A");
        }
        else {
            System.out.println("1 A");
        }

    }
    }
