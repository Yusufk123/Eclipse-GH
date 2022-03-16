
public class Main {

	public static void main(String[] args) {
		int n = 21;
		
		System.out.println("Start Time for Recursive: " + System.nanoTime());
		System.out.println(fibRecursive.fibR(n));
		System.out.println("End Time for Recursive: " + System.nanoTime());
		
		System.out.println("Start Time for Iterative: " + System.nanoTime());
		System.out.println(fibIterative.fibI(n));
		System.out.println("End Time for Iterative: " + System.nanoTime());
	}
	
}
