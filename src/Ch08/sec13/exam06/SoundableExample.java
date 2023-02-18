package Ch08.sec13.exam06;

public class SoundableExample {
	public static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	public static void main(String[] args) {

		printSound(new Dog());
		printSound(new Cat());
	}
}
