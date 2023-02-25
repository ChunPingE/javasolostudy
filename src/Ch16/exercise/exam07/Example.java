package Ch16.exercise.exam07;

public class Example {
	private static int[] scores = { 10, 50, 3 };
	
	public static int maxOrMin(Operator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}
	
	public static void main(String[] args) {
		//최대값 걷기
		int Max = maxOrMin((a,b) -> {
			if(a>=b) {
				return a;
			} else {
				return b;
			}
		});
		
		
	}

}
