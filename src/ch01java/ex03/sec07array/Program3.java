package ch01java.ex03.sec07array;

public class Program3 {

	public static void main(String[] args) {

		int[] nums = { 5, 2, 7, 4, 6, 1, 3 };

		int index = -1;

		for (int i = 0; i < 7 ; i++) {
			if (nums[i] == 1) {
				index = i;
				break;
			}
		}
		System.out.printf("idnex is %d\n", index);

	}

}
