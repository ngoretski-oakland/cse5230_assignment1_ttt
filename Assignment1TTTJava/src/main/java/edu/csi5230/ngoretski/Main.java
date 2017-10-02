package edu.csi5230.ngoretski;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1, 1));
		
		TttApplet applet = new TttApplet();
		frame.add(applet );
		
		frame.setSize(250, 430);
		
		applet.init();
		
		applet.start();
		
		frame.setVisible(true);
	}
}
