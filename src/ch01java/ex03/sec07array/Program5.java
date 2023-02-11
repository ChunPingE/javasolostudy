package ch01java.ex03.sec07array;

import java.util.Random;

public class Program5 {

	public static void main(String[] args) {

		int[] lottos = new int[6]; 
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int num = rand.nextInt(45) + 1; 
			lottos[i] = num;
		}
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ",lottos[i]);
		}
	
		
		
		
		
	}

}
