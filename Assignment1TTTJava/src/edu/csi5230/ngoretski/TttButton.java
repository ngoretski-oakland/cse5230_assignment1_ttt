package edu.csi5230.ngoretski;

import java.awt.Button;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class TttButton extends Button implements Observer {

	private int index = -1;

	public TttButton(int index) {
		this.index = index;
	}

	@Override
	public void update(Observable o, Object arg) {
		String symbol = null;
		
		if (arg != null) {
			symbol = arg.toString();
		}
		
		this.setLabel(symbol);
		
	}

	public int getIndex() {
		return index;
	}
	
}
