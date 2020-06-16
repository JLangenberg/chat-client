package controller;

import view.GUI;
import view.UI;

/**
 * A Thread that handles all incoming messages. It reads those messages and
 * tells the UI to display them on the GUI and on the console
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

		// The UI object needed to read the input and display messages
		UI ui = new UI();

		// Run indefinitely
		while (true) {

			// Store the server answer
			serverAnswer = client.readAnswer();

			// Check if the server gave an answer. If not, assume the connection has
			// been canceled
			if (serverAnswer == null) {
				ui.printDisconnect();
				gui.displayDisconnect();
				break;
			}
			// Stop running if the Client throws an error
			if (serverAnswer.equals("ERROR")) {
				break;
			}

			// Print the server answer for the user
			ui.printForeignClientAnswer(serverAnswer);
			// Displays the message on the GUI
			gui.displayMessage(serverAnswer);
		}
	}

}
