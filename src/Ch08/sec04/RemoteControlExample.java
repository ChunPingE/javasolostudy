package Ch08.sec04;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc.turnOn(); // TV를 켭니다.
		rc.setVolume(5); // 현재볼륨: 5
		rc.turnOff(); // TV를 끕니다.

		rc = new Audio();
		rc.turnOn(); // Auido를 켭니다.
		rc.setVolume(5); // 현재볼륨: 5
		rc.turnOff(); // Auido를 끕니다.
	}
}
