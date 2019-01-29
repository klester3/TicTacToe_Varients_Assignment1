package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class RandomTurnActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_turn);
    }

    @Override
    public void onClick(View view) {

    }
}
