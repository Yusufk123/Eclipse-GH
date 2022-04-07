import java.util.Random;

public class Main {
	private static final Random RAND = new Random();

	public static void main(String[] args) {
		int Size = 1000;

		int a[] = randomArray(Size);

		System.out.println(sumSingle(a));

	}

	public static int[] randomArray(int length) {
		int a[] = new int[length];

		for (int i = 0; i < a.length; i++) {
			a[i] = RAND.nextInt(50);
		}
		return a;
	}

	public static int sumSingle(int a[]) {
		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			answer += a[i];
		}
		return answer;
	}

	public static int sumMulti(int a[]) {
		int answer = 0;

		return answer;
	}
}
