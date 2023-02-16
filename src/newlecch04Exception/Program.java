package newlecch04Exception;

public class Program {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int result = 0;

		try {
			result = Calculator.add(0, 0);
			System.out.println(result);
			result = Calculator.sub(0, 0);
			System.out.println(result);
		} catch (천을_넘는_예외 e) {
			System.out.println("특화처리");
		} catch (음수가되는예외 e) {
		}  catch (Exception e) {
		} finally {
			System.out.println("입력값에 오류가 있습니다.");
		}
		result = Calculator.multi(0, 0);
		System.out.println(result);
		result = Calculator.div(0, 0);
		System.out.println(result);

	}

}
