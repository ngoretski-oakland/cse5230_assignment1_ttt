package edu.csi5230.ngoretski;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Main extends Applet {

	JPanel topPanel = new JPanel();
	JPanel boardPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	TttLabel turnLabel = new TttLabel();
	Button startButton = new Button();
	Button[] tttButton = new Button[9];
	
	private TttGame tttGame = new TttGame();;
	
	@Override
	public void init() {
		super.init();
		resize(250, 430);
		add(topPanel);
		add(boardPanel);
		add(bottomPanel);
		
		// Add top panel and its components
		topPanel.setPreferredSize(new Dimension(250, 90));
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		topPanel.add(turnLabel);
		
		tttGame.setMessagingObserver(turnLabel);
		
		turnLabel.setText("Game is not started yet!!!");
		
		// Add Center Board
		boardPanel.setPreferredSize(new Dimension(250, 250));
		boardPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		for (int i = 0; i < 9; i++) {
			TttButton button = new TttButton(i);

			tttGame.setButtonObserver(button, i);
			
			tttButton[i] = button;
			tttButton[i].setPreferredSize(new Dimension(70, 70));
			
			boardPanel.add(tttButton[i]);
			
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("clicked on:"+button.getIndex());
					
					tttGame.actionOnCell(button.getIndex());
				}
			});
		}
		
		// Add bottom Layout
		bottomPanel.setPreferredSize(new Dimension(250, 90));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		startButton.setLabel("Start Game");
		startButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				tttGame.startGame();
			}
		});
		bottomPanel.add(startButton);
	}
}
