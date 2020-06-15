package controller;

import view.GUI;
import view.UI;

/**
 * A Thread that handles all incoming messages. It reads those messages and
 * tells the ui to display them on the gui and on the console
 * 
 * @author Julius Langenberg
 *
 */
public class InputThread extends Thread {

	// The client object, needed to get all the messages.
	private Client client = null;

	// The GUI object, needed to access the GUIs TextField
	private GUI gui = null;

	/**
	 * Constructor of the InputThread.
	 * 
	 * @param client
	 * @param gui
	 */
	public InputThread(Client client, GUI gui) {
		this.client = client;
		this.gui = gui;
	}

	/**
	 * Run method. Is run when this thread is started. This continuously runs. While
	 * running, it reads and displays incoming messages.
	 */
	public void run() {

		// The variable for the server answer.
		String serverAnswer = "default";

		// Run indefinetely
		while (true) {

			// Store the server answer
			serverAnswer = client.readAnswer();

			// Stop running if the Client throws an error
			if (serverAnswer.equals("ERROR")) {
				break;
			}

			// The ui object needed to read the input
			UI ui = new UI();
			// Print the server answer for the user
			ui.printForeignClientAnswer(serverAnswer);
			// Displays the message on the gui
			gui.displayMessage(serverAnswer);
		}
	}

}
