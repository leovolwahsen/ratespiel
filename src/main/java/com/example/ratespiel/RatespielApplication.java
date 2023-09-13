package com.example.ratespiel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RatespielApplication {

	static int generatedNumber = (int) Math.floor(Math.random() * 100);
	static Integer tries = 0;

	// JLabel ist in der gesammten Anwendung, allen anderen functionen aufrufbar und nutzbar.
	static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 und 100 ein!");
	static JLabel counterText = new JLabel("Zähler deiner Versuche:");
	static JTextField textField = new JTextField();
	static JTextField textFieldCounterOfTries = new JTextField();

	static JButton myButton = new JButton("Raten!");

	public static void main(String[] args) {
		openUI();
	}

	public static void openUI() {
		JFrame frame = new JFrame("Rate die Zahl!");
		frame.setSize(400, 300);
		frame.setLocation(100, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);

		text.setBounds(50, 80, 240, 30);
		counterText.setBounds(150, 20, 200, 20);

		textFieldCounterOfTries.setBounds(300, 20, 25, 20);

		textField.setBounds(50, 120, 240, 30);


		myButton.setBounds(50, 170, 240, 30);

		myButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String textFromTextField = textField.getText();
					Integer number = Integer.parseInt(textFromTextField);
					guess(number);
				} catch (Exception error) {
					text.setText("Bitte gebe eine Zahl ein");
				}
			}
		});

		frame.add(counterText);
		frame.add(textFieldCounterOfTries);
		frame.add(myButton);
		frame.add(textField);
		frame.add(text);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public static void guess(Integer number) {

		if (number == generatedNumber) {
			text.setText("Du hast richtig geraten beim " + tries + ". Versuch!");
			myButton.setEnabled(false);
		} else {
			tries++;
			if (number < generatedNumber) {
				text.setText("Falsch geraten! Deine Zahl ist zu klein!");
			} else {
				text.setText("Falsch geraten! Deine Zahl ist zu groß!");
			}
			textField.setText("");

			// Zählt im counter die Anzahl an versuchen
			textFieldCounterOfTries.setText(String.valueOf(tries));
		}
	}
}
