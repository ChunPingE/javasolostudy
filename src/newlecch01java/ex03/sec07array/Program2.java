package newlecch01java.ex03.sec07array;

public class Program2 {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { 4, 5, 6 };

		int[] nums = new int[6];
		
		for (int i = 0; i < 3; i++) {
			nums[i] = nums1[i];
			nums[3+i]= nums2[i];
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", nums[i]);
		}
		

	}

}
