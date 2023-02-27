package newlecch03객체지향2.sec05추상화;

public class NewlecExamConsole extends ExamConsole {
	@Override
	protected Exam makeExam() {
		return new NewlecExam();
	}
}
