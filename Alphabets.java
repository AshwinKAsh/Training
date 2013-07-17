import java.util.Scanner;

/*      Enter the number of alphabets pattern in scanner  
 *      So that the output should be for n=2      n=4  
 *                                         a        a
 *                                         bc       bc
 *													cde
 *        											defg
 */

public class Alphabets {
	public static void main(String[] args) {
		System.out.println("Enter the Alphabet size :");
		Scanner scanner = new Scanner(System.in);
		int alphabets = scanner.nextInt();
		for (int row = 0; row < alphabets + 1; row++) {
			for (int col = row + 96; col <= 2 * row - 1 + 96; col++)
				System.out.print((char) col);
			System.out.println();

		}

	}
}