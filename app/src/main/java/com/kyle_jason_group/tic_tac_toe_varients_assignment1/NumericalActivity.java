package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NumericalActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean turn;
    private boolean clicked;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical);

        turn = true;
        clicked = false;

        findViewById(R.id.imageView).setOnClickListener(this);
        findViewById(R.id.imageView2).setOnClickListener(this);
        findViewById(R.id.imageView3).setOnClickListener(this);
        findViewById(R.id.imageView4).setOnClickListener(this);
        findViewById(R.id.imageView5).setOnClickListener(this);
        findViewById(R.id.imageView6).setOnClickListener(this);
        findViewById(R.id.imageView7).setOnClickListener(this);
        findViewById(R.id.imageView8).setOnClickListener(this);
        findViewById(R.id.imageView9).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (clicked) {
            return;
        } else {
            clicked = true;
            getMove(turn);
            checkForWin();
            turn = !turn;
            clicked = false;
        }
    }

    private void checkForWin() {

    }

    private void getMove(boolean turn) {
        if (turn) {

        } else {

        }
    }
}
