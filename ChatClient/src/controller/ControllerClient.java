package controller;

import model.Data;
import view.UI;

/**
 * The controller and main class of the client program. Handles all processes
 * and steps.
 * 
 * @author Julius Langenberg, AH811
 *
 */
public class ControllerClient {
	// 172.16.21.209
	public static void main(String[] args) {

		// Create the data object and fill it with all needed data.
		Data data = new Data("localhost", 4504);
		// Create an UI object for later usage of the console
		UI ui = new UI();

		// Create a client object and connect to the server.
		Client client = new Client(data.getHost(), data.getPort());
		// Create a controllerClient to access it's methods.
		ControllerClient controller = new ControllerClient();

		// Handle requests until the user cancels
		controller.requestLoop(ui, client);

		// Closes all streams.
		client.closeStreams();
	}

	/**
	 * Lets the user send and receive messages to/from the server until he cancels
	 * the process.
	 * 
	 * @param ui     The ui class used for console in-/output
	 * @param client The client object with the server connection
	 */
	private void requestLoop(UI ui, Client client) {

		InputThread inputThread = new InputThread(client);
		inputThread.start();

		// Loop until the user requests "bye"
		while (true) {
			// Let the user enter a request
			String request = ui.newMessage();

			// Default the server answer
			// Send the request to the server
			client.sendRequest(request);

			// Check if the program should be ended
			if (request.equals("bye") || inputThread.isAlive() == false) {
				break;
			}
		}
	}
}
