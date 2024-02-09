// Java program to demonstrate working of LinkedHashSet

import java.util.LinkedHashSet;
public class Demo
{
	public static void main(String[] args)
	{
		LinkedHashSet<String> linkedset =
						new LinkedHashSet<String>();

		// Adding element to LinkedHashSet
		linkedset.add("A");
		linkedset.add("B");
		linkedset.add("C");
		linkedset.add("D");

		// This will not add new element as A already exists
		linkedset.add("A");
		linkedset.add("E");

		System.out.println("Size of LinkedHashSet = " +
									linkedset.size());
		System.out.println("Original LinkedHashSet:" + linkedset);
		System.out.println("Removing D from LinkedHashSet: " +
							linkedset.remove("D"));
		System.out.println("Trying to Remove Z which is not "+
							"present: " + linkedset.remove("Z"));
		System.out.println("Checking if A is present=" +
							linkedset.contains("A"));
		System.out.println("Updated LinkedHashSet: " + linkedset);
	}
}
