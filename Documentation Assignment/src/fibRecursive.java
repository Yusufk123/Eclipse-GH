
public class fibRecursive {
	public static int fibR(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibR(n - 1)+fibR(n - 2);
		}
	}
}
