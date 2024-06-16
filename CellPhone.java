import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The {@code CellPhone} class represents a cell phone with basic information such as serial number, brand, year, and price.
 * It includes constructors, getters, setters, a toString method, and methods for cloning and equality comparison.
 */

public class CellPhone implements Cloneable{

	// Initialize variables 
	private long serialNumber;
	private static long SNcount=0;
	private String brand;
	private int year;
	private double price;

	/**
     * Default constructor for the CellPhone class.
     * Initializes the serial number, brand, year, and price to default values.
     */
	// Default constructor
	public CellPhone() {
		serialNumber = SNcount++;
		brand = "";
		year = 0;
		price = 0;
	}
	
	/**
     * Parameterized constructor for the CellPhone class.
     *
     * @param serialNumber The serial number of the cell phone.
     * @param brand        The brand of the cell phone.
     * @param year         The manufacturing year of the cell phone.
     * @param price        The price of the cell phone.
     */
	// Parameterized constructor
	public CellPhone(long serialNumber, String brand, int year, double price) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
     * Copy constructor for the CellPhone class.
     *
     * @param other        The original cell phone to be copied.
     * @param serialNumber The new serial number for the cloned cell phone.
     */
	// copy constructor 
	public CellPhone(CellPhone other, long serialNumber) {
		this.serialNumber = serialNumber;
		this.brand = other.brand;
		this.year = other.year;
		this.price = other.price;
		SNcount++;
	}

	// getters and setters
	/**
     * Getter for the serial number of the cell phone.
     *
     * @return The serial number of the cell phone.
     */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	/**
     * Setter for the serial number of the cell phone.
     *
     * @param serialNumber The new serial number to be set.
     */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
     * Getter for the brand of the cell phone.
     *
     * @return The brand of the cell phone.
     */
	public String getBrand() {
		return brand;
	}

	/**
     * Setter for the brand of the cell phone.
     *
     * @param brand The new brand to be set.
     */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	 /**
     * Getter for the manufacturing year of the cell phone.
     *
     * @return The manufacturing year of the cell phone.
     */
	public int getYear() {
		return year;
	}

	/**
     * Setter for the manufacturing year of the cell phone.
     *
     * @param year The new manufacturing year to be set.
     */
	public void setYear(int year) {
		this.year = year;
	}

	 /**
     * Getter for the price of the cell phone.
     *
     * @return The price of the cell phone.
     */
	public double getPrice() {
		return price;
	}

	/**
     * Setter for the price of the cell phone.
     *
     * @param price The new price to be set.
     */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
     * Returns a string representation of the cell phone.
     *
     * @return A string containing the serial number, brand, price, and year of the cell phone.
     */
	// to String method

	public String toString() {
		return "["+ serialNumber + ": " + brand + " " + price + "$ " + year + "]";
	}
	

    /**
     * Creates and returns a new cell phone with the same attributes as the current cell phone but with a new serial number.
     * The new serial number is obtained from user input.
     *
     * @return A new cell phone with the same attributes and a new serial number.
     * @throws InputMismatchException If the user enters an invalid serial number.
     */
	// clone method
	public CellPhone clone() {
		try {
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Please enter new serial number: ");
	    long newSN = scanner.nextLong();
	    return new CellPhone(this, newSN);
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} 
		return null;
		
	}

	/**
     * Checks if the current cell phone is equal to another object.
     * Two cell phones are considered equal if they have the same brand, price, and year.
     *
     * @param a The object to be compared with the current cell phone.
     * @return {@code true} if the cell phones are equal, {@code false} otherwise.
     */
	// equals method
	public boolean equals(Object a) {
		// check if the object being compared is also a CellPhone
		if (a.getClass() != this.getClass() || a == null ) {
			return false;
		}
		else {
			CellPhone b = (CellPhone)a;
			return b.brand.equalsIgnoreCase(this.brand) && b.price == this.price && b.year == this.year;
		}
	}
	
	

}
