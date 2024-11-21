package com.example.javaMultipleApps;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SpringBootApplication
public class JavaMultipleAppsApplication extends JFrame {

	public JavaMultipleAppsApplication() {
		JButton launchButton = new JButton("Iniciar App Secundaria");
		launchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Iniciar la aplicación secundaria como un proceso independiente
				try {
					ProcessBuilder builder = new ProcessBuilder("java", "-jar", "ruta/al/jar/AppSecundaria.jar");
					Process process = builder.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		JPanel panel = new JPanel();
		panel.add(launchButton);

		setTitle("Aplicación Principal");
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(panel);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JavaMultipleAppsApplication().setVisible(true);
			}
		});
	}
}
