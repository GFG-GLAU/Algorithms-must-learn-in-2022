// Java Program to Illustrate StringBuffer class
// via append() method

// Importing required classes
import java.io.*;

// Main class
class GFG {

	// Main driver method
	public static void main(String[] args)
	{
		// Creating an object of StringBuffer class and
		// passing random string
		StringBuffer s = new StringBuffer("Geeksfor");

		// Usage of append() method
		s.append("Geeks");

		// Returns GeeksforGeeks
		System.out.println(s);

		s.append(1);
		// Returns GeeksforGeeks1
		System.out.println(s);
	}
}
