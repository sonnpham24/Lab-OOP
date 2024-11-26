package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DaysInMonth {
	// Array holding the number of days in each month for non-leap years
	static final int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// Array holding month names for validation and lookup
	static final String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	// Check if a given year is a leap year
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				return year % 400 == 0;
			} else {
				return true;
			}
		}
		return false;
	}

	// Convert user input (month) into an index (0 to 11) corresponding to the month
	// array
	public static int getMonthIndex(String input) {
		input = input.trim().toLowerCase();
		switch (input) {
		case "1":
		case "january":
		case "jan":
		case "jan.":
			return 0;
		case "2":
		case "february":
		case "feb":
		case "feb.":
			return 1;
		case "3":
		case "march":
		case "mar":
		case "mar.":
			return 2;
		case "4":
		case "april":
		case "apr":
		case "apr.":
			return 3;
		case "5":
		case "may":
			return 4;
		case "6":
		case "june":
		case "jun":
		case "jun.":
			return 5;
		case "7":
		case "july":
		case "jul":
		case "jul.":
			return 6;
		case "8":
		case "august":
		case "aug":
		case "aug.":
			return 7;
		case "9":
		case "september":
		case "sep":
		case "sep.":
			return 8;
		case "10":
		case "october":
		case "oct":
		case "oct.":
			return 9;
		case "11":
		case "november":
		case "nov":
		case "nov.":
			return 10;
		case "12":
		case "december":
		case "dec":
		case "dec.":
			return 11;
		default:
			return -1; // Invalid month
		}
	}

	// Get the number of days in a month given a year and a month index
	public static int getDaysInMonth(int monthIndex, int year) {
		if (monthIndex == 1 && isLeapYear(year)) {
			return 29; // February in a leap year
		} else {
			return daysInMonths[monthIndex]; // Other months or non-leap February
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				// Ask for the month
				System.out.print("Enter a month (full name, abbreviation, or number): ");
				String monthInput = scanner.nextLine();

				// Convert month input to an index
				int monthIndex = getMonthIndex(monthInput);

				if (monthIndex == -1) {
					System.out.println("Invalid month input. Please try again.");
					continue;
				}

				// Ask for the year
				System.out.print("Enter a year (non-negative number): ");
				String yearInput = scanner.nextLine();

				// Validate if year is a positive integer and parse it
				int year;
				try {
					year = Integer.parseInt(yearInput);
					if (year < 0 || yearInput.length() != 4) {
						System.out.println("Invalid year input. Please enter a valid 4-digit year.");
						continue;
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid year input. Please enter a valid 4-digit year.");
					continue;
				}

				// Calculate the number of days in the month
				int days = getDaysInMonth(monthIndex, year);
				System.out.println("Number of days in " + monthNames[monthIndex] + " " + year + ": " + days);
				break; // Exit the loop after successful input and output

			} catch (Exception e) {
				System.out.println("An error occurred. Please try again.");
			}
		}

		scanner.close();
	}
}
