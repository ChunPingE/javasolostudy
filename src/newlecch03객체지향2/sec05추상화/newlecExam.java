package newlecch03객체지향2.sec05추상화;

public class NewlecExam extends Exam {

	private int com;

	public NewlecExam() {
		this(0, 0, 0, 0);
	}

	public NewlecExam(int kor, int eng, int math, int com) {
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
		return getKor() + getEng() + getMath() + com;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}
}