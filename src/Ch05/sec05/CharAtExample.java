package Ch05.sec05;

public class CharAtExample {

	public static void main(String[] args) {
		String ssn = "9506211230123";
		char sex = ssn.charAt(6);
		
		switch (sex) {
		case 1:
		case 2:
			System.out.println("남자입니다.");
			break;
		case 3:
		case 4:
			System.out.println("여자입니다.");
			break;
		}
	}
}
