package Ch08.sec06;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc.turnOn(); // TV를 켭니다.
		rc.setVolume(5); // 현재볼륨: 5
		rc.setMute(true); //무음처리합니다. 현재볼륨: 0
		rc.setMute(false); //무음 해제합니다.
		rc.turnOff(); // TV를 끕니다.
		
		rc = new Audio();
		rc.turnOn(); // Auido를 켭니다.
		rc.setVolume(5); // 현재볼륨: 5
		rc.setMute(true); //무음처리합니다. 현재볼륨: 0
		rc.setMute(false); //무음 해제합니다. 현재볼륨: 5
		rc.turnOff(); // Auido를 끕니다.
		
		//정적메소드 호출
		RemoteControl.changeBattery(); //리모콘 건전지를 교환합니다.
	}
}
