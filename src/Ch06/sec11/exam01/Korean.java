package Ch06.sec11.exam01;

public class Korean {
	//인스턴스 final필드선언
	final String nation = "대한민국";
	final String ssn;
	
	//인스턴스 필드선언
	String name;
	
	//생성자 선언
	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
}
