//package codeforces;

import java.util.Scanner;

public class Fingerprints {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] code = new int[scanner.nextInt()];
		int[] prints = new int[scanner.nextInt()];

		for (int i = 0; i < code.length; i++) {
			code[i] = scanner.nextInt();
		}
		for (int i = 0; i < prints.length; i++) {
			prints[i] = scanner.nextInt();
		}
		for (int i = 0; i < code.length; i++) {
			for (int j = 0; j < prints.length; j++) {
				if (code[i] == prints[j]) {
					System.out.print(prints[j] + " ");
				}
			}
		}
		scanner.close();
	}

}
