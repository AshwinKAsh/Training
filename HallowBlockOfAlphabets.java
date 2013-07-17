import java.util.Scanner;

/*      Enter the number of alphabets pattern in scanner  
 *      So that the output should be for       n=4  
 *                                             abcd
 *                                             a  d
 *											   a  d
 *        							    	   abcd
 */

public class HallowBlockOfAlphabets {
	public static void main(String[] args) {
		System.out.println("Enter the Alphabet size :");
		int alphabets = new Scanner(System.in).nextInt();
		for (int row = 97; row < alphabets + 96; row++) {
			for (int col = 97; col < alphabets+97; col++) {
				System.out.print((char) col);
			}
			System.out.println();
		}
		if (alphabets != 1)
			for (int row1 = 0 + 97; row1 < alphabets + 97; row1++)
				System.out.print((char) row1);
		// System.out.println();

	}
}