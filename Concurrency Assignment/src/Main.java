import java.util.Random;

public class Main {
	private static final Random RAND = new Random();
	private static int cores = 8;

	public static void main(String[] args) {

		System.out.println("CPU Cores: " + cores);

	}

	public static int[] randomArray(int length) {
		int a[] = new int[length];

		for (int i = 0; i < a.length; i++) {
			a[i] = RAND.nextInt();
		}
		return a;
	}

	public static int range(int[] a, int min, int max) {
		int answer = 0;
		for (int i = min; i < max; i++) {
			answer += a[i];
		}
		return answer;
	}

	public static int sumSingle(int a[]) {
		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			answer += a[i];
		}
		return answer;
	}

	public static int sumMulti(int a[]) {
		int length = (int) Math.ceil(1 * a.length / cores);
		int answer = 0;
		Adder[] adders = new Adder[cores];
		Thread[] threads = new Thread[cores];
		for (int i = 0; i < cores; i++) {
			adders[i] = new Adder(a, i * length, Math.min((i + 1) * length, a.length));
			threads[i] = new Thread(adders[i]);
			threads[i].start();
		}
		try {
			for (Thread t : threads) {
				t.join();
			}
		} catch (InterruptedException ie) {
			System.out.println("Thread Issue");
		}

		for (Adder adder : adders) {
			answer += adder.getSum();
		}
		return answer;
	}
}
