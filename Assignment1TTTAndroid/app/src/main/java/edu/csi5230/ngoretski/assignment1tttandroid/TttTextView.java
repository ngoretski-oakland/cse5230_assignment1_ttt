package edu.csi5230.ngoretski.assignment1tttandroid;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Android Observer TextView
 * Created by nathan on 01/10/17.
 */
public class TttTextView extends TextView implements Observer {

    public TttTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void update(Observable observable, Object o) {
        String message = o.toString();

        this.setText(message);
    }
}
