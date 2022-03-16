
public class fibIterative {
	public static int fibI(int n) {
		if (n <= 1) {
			return n;
		} else {
			int f = 1;
			int pf = 1;
			
			for(int i = 2; i < n; i++) {
				int t = f;
				f += pf;
				pf = t;
			}
			return f;
		}
	}
}
