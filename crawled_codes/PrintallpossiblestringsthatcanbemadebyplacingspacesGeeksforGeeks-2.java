//https://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/
//O(n*(2^n)
// Java program for above approach
import java.util.*;

public class GFG
{
	private static ArrayList<String>
						spaceString(String str)
	{

		ArrayList<String> strs = new
						ArrayList<String>();

		// Check if str.length() is 1
		if (str.length() == 1)
		{
			strs.add(str);
			return strs;
		}

		ArrayList<String> strsTemp
			= spaceString(str.substring(1,
							str.length()));

		// Iterate over strsTemp
		for (int i = 0; i < strsTemp.size(); i++)
		{

			strs.add(str.charAt(0) +
							strsTemp.get(i));
			strs.add(str.charAt(0) + " " +
							strsTemp.get(i));
		}

		// Return strs
		return strs;
	}

	// Driver Code
	public static void main(String args[])
	{
		ArrayList<String> patterns
			= new ArrayList<String>();

		// Function Call
		patterns = spaceString("ABCD");

		// Print patterns
		for (String s : patterns)
		{
			System.out.println(s);
		}
	}
}
