import java.io.*;
import java.util.*;

public class Solution {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m]; // static
        for (int i=0; i < n; i++) {
            String gg = sc.next();
            for (int j=0; j < m; j++) {
                grid[i][j] = gg.charAt(j);
            }
        }
        sc.close();
        char[][] struct = new char[n][m]; // dynamic
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                struct[i][j] = '.';
            }
        }
        ArrayList<Integer> length = new ArrayList<Integer>();
        ArrayList<Integer> width = new ArrayList<Integer>();
        ArrayList<Integer> size = new ArrayList<Integer>();
        int blow = 0; // number of stars used
        for (int a=1; a < n-1; a++) {
            for (int b=1; b < m-1; b++) {
                if (grid[a][b] != '*') continue;
                int z = 0;
                while (a-z > 0 && a+z < (n-1) && b-z > 0 && b+z < (m-1)) {
                    z++;
                    if (grid[a-z][b]=='*' && grid[a+z][b]=='*' && grid[a][b-z]=='*' && grid[a][b+z]=='*') {
                        continue;
                    }
                    else {
                        z--;
                        break;
                    }
                }
                if (z > 0) {
                    blow++;
                    length.add(a);
                    width.add(b);
                    size.add(z);
                }
            }
        }
        for (int q=0; q < blow; q++) {
            int wa = length.get(q);
            int wb = width.get(q);
            int wc = size.get(q);
            for (int i=0; i <= wc; i++) {
                struct[wa-i][wb] = '*';
                struct[wa+i][wb] = '*';
                struct[wa][wb-i] = '*';
                struct[wa][wb+i] = '*';
            }
        }
        int yes = 1;
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (struct[i][j] != grid[i][j]) {
                    yes = 0;
                    break;
                }
            }
            if (yes==0) break;
        }
        if (yes==0) System.out.println(-1);
        else {
            System.out.println(blow);
            for (int q=0; q < blow; q++) {
                System.out.print((length.get(q)+1) + " " + (width.get(q)+1) + " " + size.get(q));
                System.out.println();
            }
        }
    }
}