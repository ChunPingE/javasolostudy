package newlecch04Exception;

public class 천을_넘는_예외 extends RuntimeException {
	@Override
	public String getMessage() {
		return "1000을 넘는 예외가 발생하였습니다.";
	}
}
