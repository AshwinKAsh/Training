import java.util.Scanner;

/*   Take a number from scanner. So it should print a triangle as below
 *   ex: number=2           2      number=5          5
 *                         222                      505
 *                                                 50005
 *                                                5000005
 *                                               555555555
 */
public class PrintingZerosInsideANumberTriangle {

    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for(int row=0;row<1;row++)
            for(int j=0;j<number-row-1;j++)
                System.out.print(" ");
            System.out.print(number);
        System.out.println();
        for(int row=2;row<number;row++)
        {
            for(int j=0;j<number-row;j++)
                System.out.print(" ");
            for(int j=0;j<1;j++)
            System.out.print(number);
            for(int j=1;j<2*row-2;j++)
            	System.out.print(0);
            for(int j=0;j<1;j++)
            System.out.print(number);
            System.out.println();
        }
        if(number!=1)
        for(int row=2;row<(2*number)+1;row++)
                System.out.print(number);
    }
}