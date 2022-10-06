//package com.krakn.CF.D1159;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();

        int a = (n - k) / 2;

        StringBuilder s = new StringBuilder();

        int i;
        while (s.length() < n) {
            i = 0;
            while (i < a && s.length() < n) {
                s.append("0");
                i++;
            }
            if (s.length() < n) s.append("1");
        }

        System.out.println(s);
    }
}
