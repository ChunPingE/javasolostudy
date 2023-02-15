package Ch05.sec09;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
		// 길이 3인 배열
		String[] oldStrArray = { "java", "array", "copy" };
		//길이 5인 배열을 새로생성
		String[] newStrArray = new String[5];
		//배열항목 복사
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		for (int i = 0; i < newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ", ");
		}
	}
}
