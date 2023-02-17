package Ch07.sec09;

public class InstanceofExample {
	public static void personInfo(Person person) {
		System.out.println("name: " + person.name);
		
		/*
		//person이 참조하는 객체가 Student 타입인지 확인
		if (person instanceof Student) {
			Student student = (Student) person;
			//Student객체만 가지고 있는 필드 및 메소드 사용
			student.study();
		}
		*/
		
		// 자바 12부터 가능한 문법
		if (person instanceof Student student) {
			System.out.println("studnetNo: " + student.studentNo);
			student.study();
		}
	}
	
	public static void main(String[] args) {
		//Person 객체를 매개값으로 제공하고 personInfo()메소드 호출
		Person p1 = new Person("홍길동");
		personInfo(p1); //name: 홍길동
		
		System.out.println();
		
		//Student 객체를 매개값으로 제공하고 메소드호출
		Person p2 = new Student("김길동", 10);
		personInfo(p2);
		//name: 김길동 / 공부를 합니다.
	}
}
