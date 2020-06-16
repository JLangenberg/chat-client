package controller;

import model.Data;
import view.GUI;
import view.UI;

/**
 * The controller and main class of the client program. Handles all processes
 * and steps.
 * 
 * @author Julius Langenberg
 *
 */
public class ControllerClient {

	public static void main(String[] args) {

		// Create an UI object for later usage of the console
		UI ui = new UI();

		// Create the data object and fill it with all needed data.
		Data data = new Data(ui.getIP(), ui.getNumber());

		// Create a client object and connect to the server.
		Client client = new Client(data.getHost(), data.getPort());

		// Create and start the GUI
		GUI gui = new GUI(client);

		// Create a controllerClient to access it's methods.
		ControllerClient controller = new ControllerClient();

		// Handle requests until the user cancels
		controller.messageLoop(ui, client, gui);

		// Closes all streams.
		client.closeStreams();
	}

	/**
	 * Lets the user send messages to the server until he cancels the process.
	 * 
	 * @param ui     The ui class used for console in
	 * @param client The client object with the server connection
	 * @param gui    The gui the inputThread will access to display new messages
	 */
	private void messageLoop(UI ui, Client client, GUI gui) {

		// This reads all input from the InputBufferedReader and handles the input.
		InputThread inputThread = new InputThread(client, gui);
		inputThread.start();

		// Loop until the user requests "bye"
		while (true) {
			// Let the user enter a request
			String request = ui.newMessage();

			// Send the request to the server
			client.sendRequest(request);

			// Check if the program should be ended
			if (request.equals("bye")) {
				break;
			}
		}
	}
}
