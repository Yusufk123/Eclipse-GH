
public class Adder implements Runnable {
	private int[] a;
	private int min, max;
	private int sum;

	public Adder(int[] a, int min, int max) {
		this.a = a;
		this.min = min;
		this.max = max;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		this.sum = Main.range(a, min, max);
	}
}
