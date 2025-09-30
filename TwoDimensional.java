import java.util.Scanner;
public class TwoDimensional{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of rows :");
        int row = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter number of columns :");
        int column = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[row][column];
        System.out.println("Enter matrix elements :");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++) 
            {
                matrix[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        System.out.println("Boundary elements :");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                if (i == 0 || i == row - 1 || j == 0 || j == column - 1)
                {
                    System.out.print(matrix[i][j] + "\t");
                    sum += matrix[i][j];
                }
                else
                {
                    System.out.print("\t"); // Empty space for non-boundary
                }
            }
            System.out.println();
        }
        System.out.println("Sum of Boundary elements :" + sum);
    }
}
