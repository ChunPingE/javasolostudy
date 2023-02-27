package newlecch03객체지향2.sec04_2상속;

public class Program {
	public static void main(String[] args) {
		newlecExam exam = new newlecExam();
		
		exam.setKor(10);
		exam.setEng(10);
		exam.setMath(10);
		exam.setCom(10);
		
		System.out.println(exam.total()); //30
	}
}
