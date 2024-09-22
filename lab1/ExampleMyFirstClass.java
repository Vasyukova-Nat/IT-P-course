import java.util.Scanner;

public class ExampleMyFirstClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(plus(a, b));
		scanner.close();
	}

	public static int plus(int a, int b) {
		return a + b;
	}
}