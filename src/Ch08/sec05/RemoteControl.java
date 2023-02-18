package Ch08.sec05;

public interface RemoteControl {
	// 상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	// public 추상메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//디폴트 인스턴스 메소드
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음처리합니다.");
			//추상메소드 호출하면서 상수필드 사용
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
}
