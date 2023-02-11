package ch01java.ex03.sec07array;

public class Program4 {

	public static void main(String[] args) {

		int[] nums = { 5, 2, 7, 4, 6, 1, 3 };

		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", nums[i]);
		}
		
		System.out.println();
		
		int temp;

		temp = nums[1]; //2

		nums[1] = nums[3]; //4

		nums[3] = temp; //2

		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", nums[i]);
		}
	}

}
