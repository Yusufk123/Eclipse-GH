
public class Main {

	public static void main(String[] args) {
		int n = 21;
		long startTime = 0, endTime = 0;
		
		startTime = System.nanoTime();
		System.out.println(fibRecursive.fibR(n));
		endTime = System.nanoTime();
		System.out.println("Time for fibRecursive:" + (endTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println(fibIterative.fibI(n));
		endTime = System.nanoTime();
		System.out.println("Time for fibIterative:" + (endTime - startTime));
	}
	
}
