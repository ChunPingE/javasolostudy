package newlecch03객체지향.sec05추상화;

public class ExamList {
	
	private Exam[] exams;
	private int current;

	public ExamList() {
		exams = new Exam[3];
		current = 0;
	}
	
	public Exam get(int i) {
		return this.exams[i];
	}

	public void add(Exam exam) {
		Exam[] exams = this.exams;
		int size = this.current;

		if (exams.length == size) {
			// 1.크기가 5개정도 더 큰 새로운 배열생성
			Exam[] temp = new Exam[size + 5];
			// 2.값이주
			for (int i = 0; i < size; i++) {
				temp[i] = exams[i];
			}
			// 3.list.exams가 새로만든 temp 배열참조
			this.exams = temp;

		}
		this.exams[this.current] = exam;
		this.current++;
		
	}

	public int size() {
		
		return current;
	}

	
}
