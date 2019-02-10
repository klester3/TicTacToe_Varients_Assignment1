package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kyle Test Button
        findViewById(R.id.imageButton_random).setOnClickListener(this);

        //Jason's Button
        findViewById(R.id.imageButton_numerical).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageButton_random) {
            Intent intent = new Intent(getApplicationContext(),
                    RandomTurnActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.imageButton_numerical) {
            Intent intent = new Intent(getApplicationContext(), NumericalActivity.class);
            startActivity(intent);
        }
    }
}
