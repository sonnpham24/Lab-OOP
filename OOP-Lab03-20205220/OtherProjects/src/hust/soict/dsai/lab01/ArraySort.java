package hust.soict.dsai.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array;
		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();
		array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array);

		int sum = 0;
		for (int num : array) {
			sum += num;
		}

		double average = (double) sum / size;

		System.out.println("Sorted array: " + Arrays.toString(array));
		System.out.println("Sum of array : " + sum);
		System.out.println("Average of array : " + average);
		scanner.close();
	}

}
