package Ch08.sec06;

public class Audio implements RemoteControl {
	//필드
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Auido를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Auido를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재볼륨: " + volume);
	}
	
	//필드
	private int memoryVolume;
	
	@Override
	public void setMute(boolean mute) {
		if (mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음처리합니다.");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
			setVolume(this.memoryVolume);
		}
	}
}
