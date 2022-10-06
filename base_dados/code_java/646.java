import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class problem2 {
    static class tile implements Comparable<tile> {
        int number;
        int suit;

        public int compareTo(tile b){

            return number - b.number;
        }

    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(" ");

        tile[] tiles = new tile[3];
        for(int i = 0; i < 3; i++){

            tiles[i] = new tile();
            tiles[i].number = parts[i].charAt(0) - '0';
            if(parts[i].substring(1,2).equals("s"))tiles[i].suit = 1;
            if(parts[i].substring(1,2).equals("m"))tiles[i].suit = 2;
            if(parts[i].substring(1,2).equals("p"))tiles[i].suit = 3;
            //System.out.println(tiles[i].number + " "+ tiles[i].suit);
        }
        Arrays.sort(tiles);

        int[][] tilesObtained = new int[10][4];
        int[][] stairCases = new int[10][4];
        int[][] stairCases2 = new int[10][4];
        for(int i = 0; i < 3; i++){
            int currNumber = tiles[i].number;
            int currSuit = tiles[i].suit;

            tilesObtained[currNumber][currSuit]++;
            stairCases[currNumber][currSuit] = 1 + stairCases[currNumber-1][currSuit];
            if(currNumber != 1){
                if(stairCases2[currNumber-2][currSuit] != 0){
                    stairCases2[currNumber][currSuit] = 2;
                }
                else{
                    stairCases2[currNumber][currSuit] = 1;
                }
            }
            else{
                stairCases2[currNumber][currSuit]++;
            }


        }
        int best = 3;

        for(int i = 1; i <= 9; i++){

            for(int j = 1; j <= 3; j++){

                best = Math.min(best, 3 - tilesObtained[i][j]);
                best = Math.min(best, 3 - stairCases[i][j]);
                best = Math.min(best, 3- stairCases2[i][j]);
                if(best <0)best = 0;
            }
        }
        System.out.println(best);


    }
}