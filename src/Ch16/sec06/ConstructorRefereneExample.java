package Ch16.sec06;

public class ConstructorRefereneExample {
	public static void main(String[] args) {
		Person person = new Person();
		
		Member m1 = person.getMember1(Member :: new);
		System.out.println(m1);//{id: winter, name:null }
		System.out.println();
		
		Member m2 = person.getMember2(Member :: new);
		System.out.println(m2);//{id: winter, name:한겨울 }
	}
}
