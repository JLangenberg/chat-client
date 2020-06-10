package controller;

import view.UI;

public class InputThread extends Thread {

	private Client client = null;

	public InputThread(Client client) {
		this.client = client;
	}

	public void run() {
		String serverAnswer = "default";
		while (true) {
			// Store the server answer
			serverAnswer = client.readAnswer();
			if (serverAnswer.equals("ERROR")) {
				break;
			}

			UI ui = new UI();
			// Print the server answer for the user
			ui.printForeignClientAnswer(serverAnswer);
		}
	}

}
