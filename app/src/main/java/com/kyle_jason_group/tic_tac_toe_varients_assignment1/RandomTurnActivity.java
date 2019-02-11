/*
Authors: Kyle and Jason
Date: 2/13/19
Tested On: Pixel 2
 */
package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.content.Context;
import android.content.SharedPreferences;
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
    private final String RANDOM_PREFS = "randomPrefs";

    private SharedPreferences sharedPreferences;
    private final String BOX_1 = "box1";
    private final String BOX_2 = "box2";
    private final String BOX_3 = "box3";
    private final String BOX_4 = "box4";
    private final String BOX_5 = "box5";
    private final String BOX_6 = "box6";
    private final String BOX_7 = "box7";
    private final String BOX_8 = "box8";
    private final String BOX_9 = "box9";
    private final String TURN = "turn";
    private final String COUNTER = "counter";

    //global variables
    private Random random;
    private Boolean who_turn;
    private String winner;
    private int counter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_turn);

        sharedPreferences = getSharedPreferences(RANDOM_PREFS, Context.MODE_PRIVATE);

        counter = sharedPreferences.getInt(COUNTER, 0);
        getTurn();
        who_turn = sharedPreferences.getBoolean(TURN, who_turn);
        changeText();
        int tag;
        ImageView imageView = findViewById(R.id.imageView_tile_a1);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_1, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_a2);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_2, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_a3);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_3, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_b1);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_4, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_b2);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_5, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_b3);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_6, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_c1);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_7, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_c2);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_8, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView_tile_c3);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_9, 42);
        setGameBoard(tag, imageView);

        //calls pressedQuit when pressed
        findViewById(R.id.imageButton_quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedQuit();
            }
        });

        //calls pressedAbout when pressed
        findViewById(R.id.imageButton_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressedAbout();
            }
        });
    }

    private void setGameBoard(int tag, ImageView imageView) {
        if (tag == 1) {
            imageView.setImageResource(R.drawable.ttt_x);
            imageView.setTag("x");
            imageView.setEnabled(false);
        } else if (tag == 2) {
            imageView.setImageResource(R.drawable.ttt_o);
            imageView.setTag("o");
            imageView.setEnabled(false);
        }
    }

    @Override
    protected void onPause() {
        if (!checkWin() && counter < 9) {
            saveGame();
        }
        super.onPause();
    }

    private void saveGame() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TURN, who_turn);
        editor.putInt(COUNTER, counter);
        ImageView imageView = findViewById(R.id.imageView_tile_a1);
        String textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_1, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_1, 2);
        }
        imageView = findViewById(R.id.imageView_tile_a2);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_2, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_2, 2);
        }
        imageView = findViewById(R.id.imageView_tile_a3);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_3, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_3, 2);
        }
        imageView = findViewById(R.id.imageView_tile_b1);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_4, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_4, 2);
        }
        imageView = findViewById(R.id.imageView_tile_b2);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_5, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_5, 2);
        }
        imageView = findViewById(R.id.imageView_tile_b3);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_6, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_6, 2);
        }
        imageView = findViewById(R.id.imageView_tile_c1);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_7, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_7, 2);
        }
        imageView = findViewById(R.id.imageView_tile_c2);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_8, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_8, 2);
        }
        imageView = findViewById(R.id.imageView_tile_c3);
        textTag = imageView.getTag().toString();
        if (textTag.equals("x")) {
            editor.putInt(BOX_9, 1);
        } else if (textTag.equals("o")) {
            editor.putInt(BOX_9, 2);
        }
        editor.apply();
    }

    //displays dialog box that informs about the game
    private void pressedAbout() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.random_about_dialog, null);
        AlertDialog.Builder quitAlert = new AlertDialog.Builder(this);
        quitAlert.setView(alertLayout);
        quitAlert.setCancelable(true);
        final AlertDialog quitDialog = quitAlert.create();
        quitDialog.show();
    }

    @Override
    public void onBackPressed() {
        if (counter > 0) {
            pressedQuit();
        } else {
            super.onBackPressed();
        }
    }

    //displays quit screen dialog box
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

    //sets text to show winner depending on the winner variable
    private void changeText() {
        TextView tv = findViewById(R.id.textView_turn);

        if(who_turn){
            tv.setText("Player X's Turn!");
        }else{
            tv.setText("Player O's Turn!");
        }
    }

    //gets the current turn
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
       counter++;
       getTurn();
       changeText();
       if(checkWin()){
           lockBoard();
           clearPreferences();
           if(winner.equals("x")){
               tv.setText("The Winner is Player X!");
           }else{
               tv.setText("The Winner is Player O!");
           }
       } else if (counter == 9) {
           lockBoard();
           clearPreferences();
           tv.setText("It's a tie");
       }
    }

    private void lockBoard() {
        ImageView imageView = findViewById(R.id.imageView_tile_a1);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_a2);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_a3);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_b1);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_b2);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_b3);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_c1);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_c2);
        imageView.setEnabled(false);
        imageView = findViewById(R.id.imageView_tile_c3);
        imageView.setEnabled(false);
    }

    private void clearPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(TURN);
        editor.putInt(COUNTER, 0);
        editor.putInt(BOX_1, 42);
        editor.putInt(BOX_2, 42);
        editor.putInt(BOX_3, 42);
        editor.putInt(BOX_4, 42);
        editor.putInt(BOX_5, 42);
        editor.putInt(BOX_6, 42);
        editor.putInt(BOX_7, 42);
        editor.putInt(BOX_8, 42);
        editor.putInt(BOX_9, 42);
        editor.apply();
    }

    //sets the image to x or o depending on the turn
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

    //calls all the check functions to see if there is a winner
    private boolean checkWin() {
        String[][] gameBoard = getGameBoard();

        if(checkHorizontal(gameBoard) || checkVertical(gameBoard) || checkDiagnol(gameBoard)){
            return true;
        }
        return false;
    }

    //checks the diagnol win options
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

    //scans the board for the diagnol runs
    private boolean scanDiagnol(String player, String[][] gameBoard) {
        if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
            return true;
        }else if(gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player){
            return true;
        }else{
            return false;
        }
    }

    //checks for the vertical win options
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

    //scans vertical runs
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

    //checks horizontal win options
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

    //scans for the horizontal runs
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

    //gets the gameboard tags and puts them in a 2d array
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
