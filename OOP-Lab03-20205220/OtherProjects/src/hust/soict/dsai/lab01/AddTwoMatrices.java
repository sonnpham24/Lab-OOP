package hust.soict.dsai.lab01;

import java.util.Scanner;

public class AddTwoMatrices {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of rows and columns of the matrices:");
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();

		int[][] matrix1 = new int[rows][cols];
		int[][] matrix2 = new int[rows][cols];
		int[][] resultMatrix = new int[rows][cols];

		System.out.println("Enter the elements of the first matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix1[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Enter the elements of the second matrix:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix2[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}

		System.out.println("The resultant matrix after addition is:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}

		scanner.close();
	}
}
