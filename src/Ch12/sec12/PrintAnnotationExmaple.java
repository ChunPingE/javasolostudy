package Ch12.sec12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrintAnnotationExmaple {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] declareMethods = Service.class.getDeclaredMethods();
		
		for(Method method : declareMethods) {
			//PrintAnnotation얻기
			//메소드에 PrintAnnotation이 적용되어 있으면객체얻음
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			
			//설정 정보를 이용해서 value속성과 number속성을 얻어와서 선 출력
			printLine(printAnnotation);
			
			//메소드호출 리플렉션에서 얻은 것을 호출
			//향상된 for문으로 method에 얻은 메소드 배열을 하나씩 담아서 꺼냄
			method.invoke(new Service());
			
			//설정정보를 이용해서 선출력
			printLine(printAnnotation);
		}
		
	}

	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
			//number 속성값 얻기
			int number = printAnnotation.number();
			for (int i = 0; i < number; i++) {
				//value 속성값 얻기
				String value = printAnnotation.value();
				System.out.print(value);
			}
			System.out.println();
		}
	}
}
