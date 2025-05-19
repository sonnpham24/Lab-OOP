
// Exercise 2.2.6. First-degree equation one variable, two variable and second-degree equation one variable

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Equations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("      		>>FEATURE SELECTION<<     ");
			System.out.println("++-----------------------------------------++");
			System.out.println("|1. First-degree equation, one variable		|");
			System.out.println("|2. First-degree equation, two variables	|");
			System.out.println("|3. Second-degree equation, one variable	|");
			System.out.println("|4. End program								|");
			System.out.println("++-----------------------------------------++");

			String strValue = JOptionPane.showInputDialog(null, "Enter your choice (1-4): ", "Enter your choice",
					JOptionPane.INFORMATION_MESSAGE);
			if (strValue == null) {
				System.out.println("Exit program");
				scanner.close();
				System.exit(0);
			}
			int value = Integer.parseInt(strValue);

			switch (value) {
			case 1:
				System.out.println("You choose First-degree equation with one variable");
				System.out.println("Given the equation ax + b = 0");
				String strA = JOptionPane.showInputDialog(null, "Enter integer a: ", "Enter integer a",
						JOptionPane.INFORMATION_MESSAGE);
				int a = Integer.parseInt(strA);
				String strB = JOptionPane.showInputDialog(null, "Enter integer b: ", "Enter integer b",
						JOptionPane.INFORMATION_MESSAGE);
				int b = Integer.parseInt(strB);
				System.out.println("You have entered " + a + "x + " + b + " = 0");

				if (a == 0 && b == 0) {
					System.out.println("Phuong trinh co vo so nghiem");
				} else if (a == 0 && b != 0) {
					System.out.println("Phuong trinh vo nghiem");
				} else {
					float x = -(float) b / a;
					System.out.println("x = " + x);
				}
				System.out.println();
				break;

			case 3:
				System.out.println("You choose Second-degree equation with one variable");
				System.out.println("Given the equation ax^2 + bx + c = 0");
				System.out.println("Enter integer a: ");
				a = scanner.nextInt();
				System.out.println("Enter integer b: ");
				b = scanner.nextInt();
				System.out.println("Enter integer c: ");
				int c = scanner.nextInt();
				System.out.println("You've entered " + a + "x^2 + " + b + "x + " + c + " = 0");

				if (a == 0) {
					if (b == 0 && c == 0) {
						System.out.println("Phuong trinh co vo so nghiem");
					} else if (b == 0 && c != 0) {
						System.out.println("Phuong trinh vo nghiem");
					} else {
						float x = -(float) c / b;
						System.out.println("x = " + x);
					}
				}
				if (a != 0) {
					double delta = Math.pow(b, 2) - 4 * a * c;
					if (delta < 0) {
						System.out.println("Phuong trinh vo nghiem");
					} else if (delta == 0) {
						float x = -(float) b / 2 * a;
						System.out.println("Nghiem kep x = " + x);
					} else {
						double x1 = (-b + Math.sqrt(delta)) / (2 * a);
						double x2 = (-b - Math.sqrt(delta)) / (2 * a);
						System.out.println("Phuong trinh co 2 nghiem x1 = " + x1 + ", x2 = " + x2);
					}
				}
				System.out.println();
				break;

			case 2:
				System.out.println("You choose First-degree equation with two variables");
				System.out.println("Given two equations: ax + by = c");
				System.out.println("and dx + ey = f");
				System.out.print("Enter integer a: ");
				a = scanner.nextInt();
				System.out.print("Enter integer b: ");
				b = scanner.nextInt();
				System.out.print("Enter integer c: ");
				c = scanner.nextInt();
				System.out.print("Enter integer d: ");
				int d = scanner.nextInt();
				System.out.print("Enter integer e: ");
				int e = scanner.nextInt();
				System.out.print("Enter integer f: ");
				int f = scanner.nextInt();
				System.out.println("You have entered: " + a + "x + " + b + "y = " + c);
				System.out.println("and " + d + "x + " + e + "y = " + f);

				int determinant = a * e - b * d;

				if (determinant == 0) {
					if ((a * f == c * d) && (b * f == c * e)) {
						System.out.println("Phuong trinh vo so nghiem");
					} else {
						System.out.println("Phuong trinh vo nghiem");
					}
				} else {
					double x = (double) (c * e - b * f) / determinant;
					double y = (double) (a * f - c * d) / determinant;

					System.out.printf("Phuong trinh co nghiem x = %.2f, y = %.2f%n", x, y);
				}

			case 4:
				System.out.println("You choose End program");
				scanner.close();
				System.exit(0);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Invalid choice. Please try again", "Error",
						JOptionPane.ERROR_MESSAGE);
				System.out.println();
				break;
			}
		}
	}
}
