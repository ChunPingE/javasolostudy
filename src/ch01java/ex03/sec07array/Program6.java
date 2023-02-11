package ch01java.ex03.sec07array;

import java.util.Random;

public class Program6 {

	public static void main(String[] args) {

		/*
		 * int[] lottos = new int[6]; int randnum = (int) ((Math.random()*100) + 1);
		 * Random rand = new Random(randnum); for (int i = 0; i < 6; i++) { int num =
		 * rand.nextInt(45) + 1; lottos[i] = num; }
		 */

		int[] lottos = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int num = rand.nextInt(45) + 1;
			lottos[i] = num;
			for (int j = 0; j < i; j++) {
				if (lottos[i] == lottos[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lottos[i]);
		}

	}

}
