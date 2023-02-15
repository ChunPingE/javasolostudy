package Ch05.sec01;

public class sec03 {
	public static void main(String[] args) {
		int[] arr1; //배열 변수 arr1선언
		int[] arr2; //배열 변수 arr2선언
		int[] arr3; //배열 변수 arr3선언
		
		arr1 = new int[] {1,2,3}; //배열{1,2,3}을 생성하고 arr1변수에 대입
		arr2 = new int[] {1,2,3}; //배열{1,2,3}을 생성하고 arr2 변수에 대입
		arr3 = arr2; //배열변수 arr2의 값을 배연 변수 arr3에 대입
		
		System.out.println(arr1 == arr2); //참조하는 객체가 다르므로 false
		System.out.println(arr2 == arr3); //참조하는 객체가 같아서 true
	}
}
