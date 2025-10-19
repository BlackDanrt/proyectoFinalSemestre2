package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Ventana extends JFrame  {
	
	
	public Ventana() {
		this.setTitle("🔥BosTinder");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setSize(1280, 920);
		this.setVisible(true);
	}
	
}
