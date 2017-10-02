package edu.csi5230.ngoretski.assignment1tttandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

/**
 * Android Observer button
 * Created by nathan on 01/10/17.
 */
public class TttButton extends Button implements Observer {

    int index = -1;

    @Override
    public void update(Observable observable, Object arg) {
        String symbol = null;

        if (arg != null) {
            symbol = arg.toString();
        }

        this.setText(symbol);

    }

    public TttButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        String packageName = "http://schemas.android.com/apk/res-auto";
        index = attrs.getAttributeIntValue(packageName, "index", 0);
    }

    public int getPosition() {
        return index;
    }
}
