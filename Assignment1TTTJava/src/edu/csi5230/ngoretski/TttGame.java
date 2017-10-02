package edu.csi5230.ngoretski;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class TttGame {

	private Observer messageObserver;
	private List<DataCell> dataCells = new ArrayList<DataCell>(9);
	Player player1 = new Player("player1", "X");
	Player player2 = new Player("player2", "O");
	Player currentPlayer;
	private boolean gameActive = false;
	
	public TttGame() {
		for (int i = 0; i < 9; i++) {
			dataCells.add(new DataCell());
		}
	}
	
	public void startGame(){
		currentPlayer = player1;
		
		gameActive = true;
		
		messageObserver.update(null, currentPlayer.getLabel()+"'s turn.");
		
		for (DataCell dataCell : dataCells) {
			dataCell.clear();
		}
	}
	
	public void setMessagingObserver(Observer messageObserver) {
		this.messageObserver = messageObserver;
		
	}

	public void setButtonObserver(Observer buttonObserver, int buttonIndex) {
		dataCells.get(buttonIndex).addObserver(buttonObserver);
	}

	public void actionOnCell(int index) {
		if (!gameActive) {
			System.out.println("game not started yet");
			return;
		}
		
		DataCell dataCell = dataCells.get(index);
		
		Player currentCellPlayer = dataCell.getPlayer();
		
		if (currentCellPlayer != null) {
			System.out.println("cell is already claimed by "+currentCellPlayer.getLabel());
			return;
		}
		
		dataCell.setPlayer(currentPlayer);
		
		checkForWin();
		checkForDraw();
		
		if (!gameActive) {
			return;
		}
		
		messageObserver.update(null, currentPlayer.getLabel()+"'s turn.");
		
		if (currentPlayer == player1) {
			currentPlayer = player2;
		}
		else {
			currentPlayer = player1;
		}
	}

	private void checkForDraw() {
		if (!gameActive) {
			return;
		}
		
		for (DataCell dataCell : dataCells) {
			if (dataCell.getPlayer() == null) {
				
				System.out.println("found a datacell with no player at "+dataCells.indexOf(dataCell));
				return;
			}
		}
		
		gameActive  = false;
		messageObserver.update(null, "Game is a draw.");
	}

	private void checkForWin() {
		if ((currentPlayer.equals(dataCells.get(0).getPlayer()) && currentPlayer.equals(dataCells.get(1).getPlayer()) && currentPlayer.equals(dataCells.get(2).getPlayer()))
				||
				(currentPlayer.equals(dataCells.get(3).getPlayer()) && currentPlayer.equals(dataCells.get(4).getPlayer()) && currentPlayer.equals(dataCells.get(5).getPlayer()))
				||
				(currentPlayer.equals(dataCells.get(6).getPlayer()) && currentPlayer.equals(dataCells.get(7).getPlayer()) && currentPlayer.equals(dataCells.get(8).getPlayer()))
				||
				(currentPlayer.equals(dataCells.get(0).getPlayer()) && currentPlayer.equals(dataCells.get(3).getPlayer()) && currentPlayer.equals(dataCells.get(6).getPlayer()))
				||
				(currentPlayer.equals(dataCells.get(1).getPlayer()) && currentPlayer.equals(dataCells.get(4).getPlayer()) && currentPlayer.equals(dataCells.get(7).getPlayer()))
				||
				(currentPlayer.equals(dataCells.get(2).getPlayer()) && currentPlayer.equals(dataCells.get(5).getPlayer()) && currentPlayer.equals(dataCells.get(8).getPlayer()))
				||
				(currentPlayer.equals(dataCells.get(0).getPlayer()) && currentPlayer.equals(dataCells.get(4).getPlayer()) && currentPlayer.equals(dataCells.get(8).getPlayer()))
				||
				(currentPlayer.equals(dataCells.get(2).getPlayer()) && currentPlayer.equals(dataCells.get(4).getPlayer()) && currentPlayer.equals(dataCells.get(6).getPlayer()))){
			gameActive  = false;
			
			messageObserver.update(null, currentPlayer.getLabel()+" is the winner!");
		}
	}

}
