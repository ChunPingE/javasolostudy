package newlecch05Collection.app.util;

public class GList<T> {
	//<타입, 두번째 타입>
	private Object[] nums;
	private int current;
	private int capacity; //용량
	private int amount; //추가 증가량

	public GList() {
		capacity = 3;
		amount = 5;
		nums = new Object[capacity];
		current = 0;
	}
 
	public void add(T num) {
		if(capacity <= current) {
			Object[] temp = new Object[capacity + amount];
			for (int i = 0; i < current; i++) {
				temp[i] = nums[i];
			}
			nums = temp;
			capacity += amount;
		}
		nums[current] = num;
		current++;
	}

	public void clear() {
		current = 0;
	}

	public int size() {
		return current;
	}

	public T get(int index) {
		if (current < index) {
			throw new IndexOutOfBoundsException();
		}
		return (T) nums[index];
	}
}
