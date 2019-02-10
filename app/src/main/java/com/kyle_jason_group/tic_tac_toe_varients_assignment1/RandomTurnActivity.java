package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
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

        findViewById(R.id.imageButton_quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedQuit();
            }
        });

        findViewById(R.id.imageButton_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedAbout();
            }
        });
    }

    private void pressedAbout() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.random_about_dialog, null);
        AlertDialog.Builder quitAlert = new AlertDialog.Builder(this);
        quitAlert.setView(alertLayout);
        quitAlert.setCancelable(true);
        final AlertDialog quitDialog = quitAlert.create();
        quitDialog.show();
    }

    private void pressedQuit() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.random_quit_dialog, null);
        AlertDialog.Builder quitAlert = new AlertDialog.Builder(this);
        quitAlert.setView(alertLayout);
        quitAlert.setCancelable(true);
        final AlertDialog quitDialog = quitAlert.create();
        quitDialog.show();
        quitDialog.findViewById(R.id.textView_quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RandomTurnActivity.super.onBackPressed();
            }
        });
        quitDialog.findViewById(R.id.textView_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quitDialog.dismiss();
            }
        });
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
        TextView tv = findViewById(R.id.textView_turn);

       place_piece(view.getId());
       getTurn();
       changeText();
       if(checkWin()){
           if(winner.equals("x")){
               tv.setText("The Winner is Player X!");
           }else{
               tv.setText("The Winner is Player O!");
           }
       }
    }

    private void place_piece(int id) {
        final ImageView imageView = findViewById(id);
        if(who_turn){
            imageView.setImageResource(R.drawable.number1);
            imageView.setEnabled(false);
            imageView.setTag("x");
        }else{
            imageView.setImageResource(R.drawable.number1);
            imageView.setEnabled(false);
            imageView.setTag("o");
        }
    }

    private boolean checkWin() {
        String[][] gameBoard = getGameBoard();

        if(checkHorizontal(gameBoard) || checkVertical(gameBoard) || checkDiagnol(gameBoard)){
            return true;
        }
        return false;
    }

    private boolean checkDiagnol(String[][] gameBoard) {
        boolean xWin;
        boolean oWin;
        oWin = scanDiagnol("o",gameBoard);
        xWin = scanDiagnol("x",gameBoard);

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

    private boolean scanDiagnol(String player, String[][] gameBoard) {
        if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
            return true;
        }else if(gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player){
            return true;
        }else{
            return false;
        }
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
