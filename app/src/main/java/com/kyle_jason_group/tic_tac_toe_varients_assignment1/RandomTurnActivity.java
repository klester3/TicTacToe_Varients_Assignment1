package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class RandomTurnActivity extends AppCompatActivity implements View.OnClickListener {
    private Random random;
    private Boolean who_turn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_turn);

        getTurn();

        findViewById(R.id.imageView_tile_a1).setOnClickListener(this);
        findViewById(R.id.imageView_tile_a2).setOnClickListener(this);
        findViewById(R.id.imageView_tile_a3).setOnClickListener(this);
        findViewById(R.id.imageView_tile_b1).setOnClickListener(this);
        findViewById(R.id.imageView_tile_b2).setOnClickListener(this);
        findViewById(R.id.imageView_tile_b3).setOnClickListener(this);
        findViewById(R.id.imageView_tile_c1).setOnClickListener(this);
        findViewById(R.id.imageView_tile_c2).setOnClickListener(this);
        findViewById(R.id.imageView_tile_c3).setOnClickListener(this);
    }

    private void getTurn() {
        random = new Random();
        int num = random.nextInt();

        if(num % 2 == 0){
            who_turn = true;
        }
        else{
            who_turn = false;
        }
    }

    @Override
    public void onClick(View view) {
       place_piece(view.getId());
       getTurn();
    }

    private void place_piece(int id) {
        final ImageView imageView = findViewById(id);
        if(who_turn){
            imageView.setImageResource(R.drawable.ttt_x);
            imageView.setEnabled(false);
            imageView.setTag("x");
        }else{
            imageView.setImageResource(R.drawable.ttt_o);
            imageView.setEnabled(false);
            imageView.setTag("o");
        }
    }
}
