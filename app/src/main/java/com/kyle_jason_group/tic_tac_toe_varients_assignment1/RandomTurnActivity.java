package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class RandomTurnActivity extends AppCompatActivity implements View.OnClickListener {
    private Random random;
    private Boolean who_turn;
    private String winner;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_turn);

        getTurn();
        changeText();
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

    private void changeText() {
        TextView tv = findViewById(R.id.textView_turn);

        if(who_turn){
            tv.setText("Player X's Turn!");
        }else{
            tv.setText("Player O's Turn!");
        }
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
       changeText();
       if(checkWin()){

       }
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

    private boolean checkWin() {
        String[][] gameBoard = getGameBoard();
        TextView tv = findViewById(R.id.textView_turn);

        if(checkHorizontal(gameBoard) || checkVertical(gameBoard) || checkDiagnol(gameBoard)){
            return true;
        }
        return false;
    }

    private boolean checkDiagnol(String[][] gameBoard) {
        return false;
    }

    private boolean checkVertical(String[][] gameBoard) {
        boolean xWin;
        boolean oWin;
        oWin = scanVertical("o",gameBoard);
        xWin = scanVertical("x",gameBoard);

        if(oWin){
            winner = "o";
            return true;
        }else if(xWin) {
            winner = "x";
            return true;
        }else{
            return false;
        }

    }

    private Boolean scanVertical(String player, String[][] gameBoard) {
        if (gameBoard[0][0] == player && gameBoard[1][0] == player && gameBoard[2][0] == player) {
            return true;
        } else if (gameBoard[0][1] == player && gameBoard[1][1] == player && gameBoard[2][1] == player) {
            return true;
        } else if (gameBoard[0][2] == player && gameBoard[1][2] == player && gameBoard[2][2] == player) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHorizontal(String[][] gameBoard) {
        boolean xWin;
        boolean oWin;
        oWin = scanHorizontal("o",gameBoard);
        xWin = scanHorizontal("x",gameBoard);

        if(oWin){
            winner = "o";
            return true;
        }else if(xWin) {
            winner = "x";
            return true;
        }else{
            return false;
        }
    }

    private boolean scanHorizontal(String player, String[][] gameBoard) {
        if (gameBoard[0][0] == player && gameBoard[0][1] == player && gameBoard[0][2] == player) {
            return true;
        } else if (gameBoard[1][0] == player && gameBoard[1][1] == player && gameBoard[1][2] == player) {
            return true;
        } else if (gameBoard[2][0] == player && gameBoard[2][1] == player && gameBoard[2][2] == player) {
            return true;
        } else {
            return false;
        }
    }

    private String[][] getGameBoard() {
        String[][] gameBoard = new String[][]{
                {findViewById(R.id.imageView_tile_a1).getTag().toString(),
                        findViewById(R.id.imageView_tile_a2).getTag().toString(),
                        findViewById(R.id.imageView_tile_a3).getTag().toString()},
                {findViewById(R.id.imageView_tile_b1).getTag().toString(),
                        findViewById(R.id.imageView_tile_b2).getTag().toString(),
                        findViewById(R.id.imageView_tile_b3).getTag().toString()},
                {findViewById(R.id.imageView_tile_c1).getTag().toString(),
                        findViewById(R.id.imageView_tile_c2).getTag().toString(),
                        findViewById(R.id.imageView_tile_c3).getTag().toString()}
                };

        return gameBoard;
    }
}
