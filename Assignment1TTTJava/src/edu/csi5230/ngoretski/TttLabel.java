package edu.csi5230.ngoretski;

import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

public class TttLabel extends Label implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		String message = arg1.toString();
		
		this.setText(message);
	}

}
