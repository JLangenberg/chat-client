package view;

import java.util.Scanner;

/**
 * The class that handles everything related to the console
 * 
 * @author Julius Langenberg
 *
 */
public class UI {

	// The scanner used to read console input
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Tells the reader what he can do, reads and return the user input
	 * 
	 * @return
	 */
	public String newMessage() {
		// Get the user input
		String request = scanner.nextLine();

		// Return the user input to the controller
		return request;
	}

	/**
	 * Gets a string from the user via the console
	 * 
	 * @return The string the user entered.
	 */
	public String getIP() {
		// Tells the user what to do
		System.out.println("Please enter an IP");
		// Get the user input
		String ip = scanner.nextLine();

		// Return the user input to the controller
		return ip;
	}

	/**
	 * Gets an integer from the user via the console
	 * 
	 * @return The integer the user entered
	 */
	public Integer getNumber() {
		// TODO: Is there some way to check if a port is
		// occupied? (aside from getting an error that says exactly that)
		System.out.println("Please enter a port");
		// Get the user input
		String port = scanner.nextLine();

		// Return the user input to the controller
		return Integer.parseInt(port);
	}

	/**
	 * Prints a string that was handed to the function with the words "Server
	 * Answer:" at the beginning.
	 * 
	 * @param serverAnswer The string to be displayed
	 */
	public void printServerAnswer(String serverAnswer) {
		System.out.println("Server Answer: " + serverAnswer);
	}

	public void printForeignClientAnswer(String serverAnswer) {
		System.out.println(serverAnswer);
	}
}
