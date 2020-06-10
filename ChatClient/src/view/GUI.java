package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;

public class GUI {
//TODO: ADD GUI function
	private JFrame frame;
	private JTextField textFieldEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
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
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(10, 356, 85, 21);
		frame.getContentPane().add(btnSend);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 527, 337);
		frame.getContentPane().add(scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JTextPane textPaneChat = new JTextPane();
		textPaneChat.setBounds(120, 86, 417, 261);
		frame.getContentPane().add(textPaneChat);
		textPaneChat.setBackground(Color.WHITE);
	}
}
