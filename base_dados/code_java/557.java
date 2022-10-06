//package com.krakn.CF.B1159;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = 1000000000, temp;

        for (int i = 0; i < n; i++) {
            temp = arr[i] / Math.max(i, n - 1 - i);
            if (temp < min)
                min = temp;
//            System.out.println(i + " " + temp);
        }

        System.out.println(min);
    }
}
