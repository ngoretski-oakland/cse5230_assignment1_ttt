package edu.csi5230.ngoretski.assignment1tttandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edu.csi5230.ngoretski.TttGame;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    TttGame tttGame = new TttGame();
    List<TttButton> buttons = new ArrayList<TttButton>(9);
    TttTextView label = null;
    Button startButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = (TttTextView) findViewById(R.id.textView1);
        tttGame.setMessagingObserver(label);
        label.setText("Game is not started yet!!!");

        buttons.add((TttButton) findViewById(R.id.button0));
        buttons.add((TttButton) findViewById(R.id.button1));
        buttons.add((TttButton) findViewById(R.id.button2));
        buttons.add((TttButton) findViewById(R.id.button3));
        buttons.add((TttButton) findViewById(R.id.button4));
        buttons.add((TttButton) findViewById(R.id.button5));
        buttons.add((TttButton) findViewById(R.id.button6));
        buttons.add((TttButton) findViewById(R.id.button7));
        buttons.add((TttButton) findViewById(R.id.button8));

        for (int i = 0; i < 9 ; i++) {
            final TttButton button = buttons.get(i);

            tttGame.setButtonObserver(buttons.get(i), i);

            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tttGame.actionOnCell(buttons.indexOf(button));
                }
            });

        }

        startButton = (Button) findViewById(R.id.startbutton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tttGame.startGame();
            }
        });


    }
}
