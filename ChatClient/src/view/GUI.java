package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.Client;
import controller.ControllerClient;
import controller.InputThread;

/**
 * Creates, displays and handles all functions related to the GUI
 * 
 * @author Julius Langenberg
 *
 */
public class GUI {

	private JFrame frame;
	private JTextField textFieldEnter;
	private Client client;
	private JTextPane textPaneChat;

	public void startGUI() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Initialize the GUI that the user sees
					GUI window = new GUI(client);
					window.frame.setVisible(true);

					/*
					 * Start the inputThread here so it can access the GUI and the TextPaneChat,
					 * then start it. This reads all input from the InputBufferedReader and handles
					 * the input.
					 */
					InputThread inputThread = new InputThread(client, window);
					inputThread.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI(Client client) {
		this.client = client;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textFieldEnter = new JTextField();
		textFieldEnter.setBounds(105, 357, 432, 19);
		frame.getContentPane().add(textFieldEnter);
		textFieldEnter.setBackground(Color.LIGHT_GRAY);
		textFieldEnter.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 527, 337);
		frame.getContentPane().add(scrollPane);

		textPaneChat = new JTextPane();
		textPaneChat.setEditable(false);
		textPaneChat.setText("This could be the beginning of a wonderfull friendship!");
		scrollPane.setViewportView(textPaneChat);

		JButton btnSend = new JButton("Send");
		btnSend.setBounds(10, 356, 85, 21);
		frame.getContentPane().add(btnSend);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chatMessage = textFieldEnter.getText();
				client.sendRequest(chatMessage);
				textFieldEnter.setText("");
			}
		});
	}
	
	/**
	 * Adds the message handed to it to the contents of the TextPane
	 * @param messageToDisplay The message that is supposed to be added
	 */
	public void displayMessage(String messageToDisplay) {
		textPaneChat.setText(textPaneChat.getText() + "\n" + messageToDisplay);
	}
}
