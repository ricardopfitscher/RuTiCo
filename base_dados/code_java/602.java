import java.util.Scanner;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int coins;
        if(s%n != 0)
            coins = s/n + 1;
        else
            coins = s/n;

        System.out.println(coins);

    }
}