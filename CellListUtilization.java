/**
 * Name(s) and ID(s) (Dalia Betinjaneh 40200966)
 * COMP249
 * Assignment # (3)
 * Due Date (Saturday December 2)
 * 
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * The {@code CellListUtilization} class is a utility class to demonstrate the functionality
 * of the {@link CellList} and {@link CellPhone} classes. It includes methods to read cell phone
 * information from a file, perform operations on cell phone lists, and test various methods
 * of the {@link CellPhone} and {@link CellList} classes.
 */

public class CellListUtilization {

	/**
     * The main method of the CellListUtilization class, which serves as the entry point
     * for the program. It demonstrates the usage of CellList and CellPhone classes
     * through various operations.
     *
     * @param args Command-line arguments (not used in this program).
     */
	
	public static void main(String[] args) {
		System.out.println("Welcome to Dalia's cellphone record code!");
		System.out.println("============================================================================\n");
		
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		
		try {
			Scanner sc = new Scanner(new FileInputStream("Cell_Info.txt"));
			
			// taking in all values from the file
			while(sc.hasNextLine()) {
				long sn = sc.nextLong();
				String brand = sc.next();
				double price = sc.nextDouble();
				int year = sc.nextInt();
				
				// creating new cellphone based on the values
				CellPhone cellPhone = new CellPhone(sn, brand, year, price);
				if ((!list1.contains(sn))) { // if list1 doesn't already have the phone we got from the file
					list1.addToStart(cellPhone); // we add the phone to the list1
				}
				else // case where the phone is already in the list
					System.out.println("This record is already in the list : " + cellPhone);
			}
			
			System.out.println();
            list1.showContent();
			
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
		System.out.print("\nPlease enter 5 serial numbers: ");
		Scanner kb = new Scanner(System.in);
		long sn1 = kb.nextLong();
		long sn2 = kb.nextLong();
		long sn3 = kb.nextLong();
		long sn4 = kb.nextLong();
		long sn5 = kb.nextLong();
		
		System.out.println(list1.find(sn1));
		System.out.println(list1.find(sn2));
		System.out.println(list1.find(sn3));
		System.out.println(list1.find(sn4));
		System.out.println(list1.find(sn5));

		
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		}
		
		// CELLPHONE
		// test cellPhone copy constructor
		// test clone copy constructor cellPhone
		// test equals method
		
		System.out.println("\nTESTING ALL CELLPHONE METHODS");
		System.out.println("-------------------------------");
		System.out.println("\nTesting default constructor:");
		CellPhone cell1 = new CellPhone();
		System.out.println(cell1);
		
		System.out.println("\nTesting parameterized constructor:");
		CellPhone cell2 = new CellPhone(1119000, "SonyEricsson", 2009, 347.94);
		System.out.println(cell2);
		
		System.out.println("\nTesting copy constructor: ");
		CellPhone cell3 = new CellPhone(cell2, 9182736);
		System.out.println(cell2);
		System.out.println(cell3);
		
		System.out.println("\nTesting clone method:");
		CellPhone cell4 = cell3.clone();
		System.out.println(cell3);
		System.out.println(cell4);
		
		System.out.println("\nTesting equals method:");
		System.out.println(cell3.equals(cell4));
		System.out.println(cell2.equals(cell3));
		
		
		// CELLLIST
		// test insertAtIndex with try catch 
		// test deleteFromIndex with try catch 
		// test deleteFromStart with try catch 
		// test replaceAtIndex
		// test equals methods
		
		System.out.println("\nTESTING ALL CELL LIST METHODS");
		System.out.println("-------------------------------");
		
		System.out.println("\nTesting insert at index:");
		try {
			list1.insertAtIndex(cell4, 3);
			list1.showContent();
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		
		System.out.println("\nTesting delete from index:");
		try {
			list1.deleteFromIndex(3);
			list1.showContent();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nTesting delete from start: ");
		try {
			list1.deleteFromStart();
			list1.showContent();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println("\nTesting replace at index: ");
		list1.replaceAtIndex(cell2, 3);
		list1.showContent();
		
		System.out.println("\nTesting copy constructor");
		CellList l2 = new CellList(list1);
		System.out.println("this is the list we want to copy");
		list1.showContent();
		System.out.println("\nthis is the copied list");
		l2.showContent();
	
		System.out.println("\nTesting equals method:");
		System.out.println(l2.equals(list1));

		System.out.println("\nThank you for using my code! ");
		System.out.println("Merry Christmas and happy new year :)");
	}

}
