//https://www.geeksforgeeks.org/find-day-of-the-week-for-a-given-date/
//O(1)
/*This code will return the string value and the exact date
* both for leap and non leap years*/
import java.util.*;
class FindDay {
	static int dd;
	static int mm;
	static int yyyy;
	FindDay(int dd, int mm, int yyyy)
	{
		this.dd = dd;
		this.mm = mm;
		this.yyyy = yyyy;
	}
	static int checkLeap(int y)
	{
		if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0))
			return 1;
		else
			return 0;
	}
	static void calculate()
	{

		// Checking Leap year. If true then 1 else 0.
		int flag_for_leap = checkLeap(yyyy);

		/*Declaring and initialising the given informations
		* and arrays*/
		String day[] = { "Sunday", "Monday", "Tuesday",
						"Wednesday", "Thursday", "Friday",
						"Saturday" };
		int m_no[] = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

		/*Generalised check to find any Year Value*/
		int j;
		if ((yyyy / 100) % 2 == 0) {
			if ((yyyy / 100) % 4 == 0)
				j = 6;
			else
				j = 2;
		}
		else {
			if (((yyyy / 100) - 1) % 4 == 0)
				j = 4;
			else
				j = 0;
		}

		/*THE FINAL FORMULA*/
		int total = (yyyy % 100) + ((yyyy % 100) / 4) + dd
					+ m_no[mm - 1] + j;
		if (flag_for_leap == 1) {
			if ((total % 7) > 0)
				System.out.println(day[(total % 7) - 1]);
			else
				System.out.println(day[6]);
		}
		else
			System.out.println(day[(total % 7)]);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		/*Take input in string format and then convert to
		* integer values*/
		String date = sc.next();
		String[] values = date.split("/");
		new FindDay(Integer.parseInt(values[0]),
					Integer.parseInt(values[1]),
					Integer.parseInt(values[2]));
		calculate();
	}
}
/*Contributed and written by Aniket Dey*/
