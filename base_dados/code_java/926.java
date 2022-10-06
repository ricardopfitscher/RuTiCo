import java.util.HashSet;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            if(a!=0){
                set.add(a);
            }
        }
        System.out.println(set.size());
    }
}