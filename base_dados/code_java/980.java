import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class Beacon8 {
    public static void main(String[] args) throws IOException {
//        int[] arr = {1, 3, 7, 18};
//        int bIndex = Arrays.binarySearch(arr, 4);
//        System.out.println(bIndex);


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Map<Integer, Integer> beacons = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int index = scan.nextInt();
            int power = scan.nextInt();
            beacons.put(index, power);
        }
        int[] indicesArr = new int[n];
        int arrInd = 0;
        for (int index : beacons.keySet()) {
            indicesArr[arrInd] = index;
            arrInd++;
        }
       // Integer[] indicesArr = ((Integer[])beacons.keySet().toArray());
        int[] nDestroys = new int[n];
        for (int i = 0; i < n; i++) {
            int bIndex = Arrays.binarySearch(indicesArr, indicesArr[i] - beacons.get(indicesArr[i]));
            if (bIndex < 0)
                bIndex = -(bIndex + 1);
            nDestroys[i] = i - bIndex;
        }
        int[] totalBeacons = new int[n];
        int maxBeacons = 1;
        totalBeacons[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nDestroys[i] == 0)
                totalBeacons[i] = totalBeacons[i - 1] + 1;
            else {
                if ((i - nDestroys[i] - 1) >= 0)
                    totalBeacons[i] = totalBeacons[i - nDestroys[i] - 1] + 1;
                else
                    totalBeacons[i] = 1;
            }
               // totalBeacons[i] = totalBeacons[i - nDestroys[i]] + 1;
            //totalBeacons[i] = i - nDestroys[i] + totalBeacons[i - nDestroys[i]] + 1;
            if(totalBeacons[i] > maxBeacons)
                maxBeacons = totalBeacons[i];
        }
//        System.out.println("\ntotalBeacons array");
//        for (int i = 0; i < n; i++) {
//            System.out.print(totalBeacons[i] + " ");
//        }
//        if (maxBeacons == -1)
//            System.out.println(n);
        System.out.println(n - maxBeacons);
    }

}
