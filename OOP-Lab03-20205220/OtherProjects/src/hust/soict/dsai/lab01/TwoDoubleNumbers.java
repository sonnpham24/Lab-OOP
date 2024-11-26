/* Exercise 2.2.5. Write a program to calculate sum, difference, product and
 * quotient of 2 double numbers which are entered by user.*/
package hust.soict.dsai.lab01;


import javax.swing.JOptionPane;

public class TwoDoubleNumbers {

	public static void main(String[] args) {

		String strDouble1 = JOptionPane.showInputDialog(null, "Enter the first double number: ",
				"Enter the first double", JOptionPane.INFORMATION_MESSAGE);
		double double1 = Double.parseDouble(strDouble1);
		String strDouble2 = JOptionPane.showInputDialog(null, "Enter the second double number: ",
				"Enter the second double", JOptionPane.INFORMATION_MESSAGE);
		double double2 = Double.parseDouble(strDouble2);
		double sum = double1 + double2;
		double diff = double1 - double2;
		double product = double1 * double2;
		double quotient = double1 / double2;

		String strMessage = "Sum: " + sum + "\nDifference: " + diff + "\nProduct: " + product + "\nQuotient: "
				+ quotient;
		JOptionPane.showMessageDialog(null, strMessage, "Result", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
