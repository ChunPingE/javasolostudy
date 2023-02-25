package Ch16.sec06;

public class Person {
	public Member getMember1(Createable1 creatable) {
		String id = "winter";
		Member member = creatable.create(id);
		return member;
	}
	
	public Member getMember2(Createable2 creatable) {
		String id = "winter";
		String name = "한겨울";
		Member member = creatable.create(id, name);
		return member;
	}
}
