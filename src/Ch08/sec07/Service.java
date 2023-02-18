package Ch08.sec07;

public interface Service {
	// 디폴트메소드
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속 코드");
		// System.out.println("defaultMethod 중복 코드1");
		// System.out.println("defaultMethod 중복 코드2");
		defaultCommon();
	}

	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속 코드");
		// System.out.println("defaultMethod 중복 코드1");
		// System.out.println("defaultMethod 중복 코드2");
		defaultCommon();
	}

	// pirvate 메소드
	private void defaultCommon() {
		System.out.println("defaultMethod 중복 코드1");
		System.out.println("defaultMethod 중복 코드2");
	}

	// 정적메소드
	static void staticMethod1() {
		System.out.println("staticMethod1 종속 코드");
		staticCommon();
	}

	static void staticMethod2() {
		System.out.println("staticMethod2 종속 코드");
		staticCommon();
	}

	// private 정적메소드
	private static void staticCommon() {
		System.out.println("staticMethod 중복 코드1");
		System.out.println("staticMethod 중복 코드2");
	}
}
