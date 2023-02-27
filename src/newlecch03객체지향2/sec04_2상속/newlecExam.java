package newlecch03객체지향2.sec04_2상속;

public class newlecExam extends Exam {
	private int com;
	
	public newlecExam() {
		this(0,0,0,0);
	}
	
	public newlecExam(int kor, int eng, int math, int com) {
		super(kor, eng, math);
		this.com = com;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		return super.total() + com;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}
}
