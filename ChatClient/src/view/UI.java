package view;

import java.util.Scanner;

/**
 * The class that handles everything related to the console
 * 
 * @author Julius Langenberg, AH811
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
	 * Prints a string that was handed to the function with the words "Server
	 * Answer:" at the beginning.
	 * 
	 * @param serverAnswer The string to be displayed
	 */
	public void printServerAnswer(String serverAnswer) {
		System.out.println("Server Answer: " + serverAnswer);
	}
	
	public void printForeignClientAnswer(String serverAnswer)	{
		System.out.println(serverAnswer);
	}
}
