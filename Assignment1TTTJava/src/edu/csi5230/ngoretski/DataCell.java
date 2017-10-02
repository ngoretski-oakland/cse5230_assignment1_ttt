package edu.csi5230.ngoretski;

import java.util.Observable;

public class DataCell extends Observable {
	
	private Player player;
	
	public String setPlayer (Player player) {
		this.player = player;
		setChanged();
		
		if (player != null) {
			notifyObservers(player.getSymbol());
			return player.getSymbol();
		}
		
		notifyObservers(null);
		return null;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void clear() {
		setPlayer(null);
	}
	
}
