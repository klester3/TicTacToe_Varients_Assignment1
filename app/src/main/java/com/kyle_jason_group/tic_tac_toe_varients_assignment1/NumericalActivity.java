package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

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
            getMove(turn, view.getId());
            checkForWin();
            turn = !turn;
            clicked = false;
        }
    }

    private void checkForWin() {
        int[][] gameBoard = getGameBoard();
        if (checkHorizontal(gameBoard) || checkVertical(gameBoard) || checkDiagonal(gameBoard)) {
            //display winner dialog
        }
    }

    private boolean checkDiagonal(int[][] gameBoard) {
        if (gameBoard[0][0] + gameBoard[1][1] + gameBoard[2][2] == 15) {
            return true;
        } else if (gameBoard[2][0] + gameBoard[1][1] + gameBoard[0][2] == 15) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkVertical(int[][] gameBoard) {
        if (gameBoard[0][0] + gameBoard[1][0] + gameBoard[2][0] == 15) {
            return true;
        } else if (gameBoard[0][1] + gameBoard[1][1] + gameBoard[2][1] == 15) {
            return true;
        } else if (gameBoard[0][2] + gameBoard[1][2] + gameBoard[2][2] == 15) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHorizontal(int[][] gameBoard) {
        if (gameBoard[0][0] + gameBoard[0][1] + gameBoard[0][2] == 15) {
            return true;
        } else if (gameBoard[1][0] + gameBoard[1][1] + gameBoard[1][2] == 15) {
            return true;
        } else if (gameBoard[2][0] + gameBoard[2][1] + gameBoard[2][2] == 15) {
            return true;
        } else {
            return false;
        }
    }

    private int[][] getGameBoard() {
        int[][] gameBoard = new int[][]{
                {Integer.valueOf(findViewById(R.id.imageView).getTag().toString()),
                Integer.valueOf(findViewById(R.id.imageView2).getTag().toString()),
                Integer.valueOf(findViewById(R.id.imageView3).getTag().toString())},
                {Integer.valueOf(findViewById(R.id.imageView4).getTag().toString()),
                Integer.valueOf(findViewById(R.id.imageView5).getTag().toString()),
                Integer.valueOf(findViewById(R.id.imageView6).getTag().toString())},
                {Integer.valueOf(findViewById(R.id.imageView7).getTag().toString()),
                Integer.valueOf(findViewById(R.id.imageView8).getTag().toString()),
                Integer.valueOf(findViewById(R.id.imageView9).getTag().toString())}
        };
        return gameBoard;
    }

    private void getMove(boolean turn, int view) {
        final ImageView imageView = findViewById(view);
        if (turn) {
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.true_moves, null);
            AlertDialog.Builder moveAlert = new AlertDialog.Builder(this);
            moveAlert.setView(alertLayout);
            moveAlert.setCancelable(true);
            AlertDialog moveDialog = moveAlert.create();
            moveDialog.show();

            ImageView oneImageView = moveDialog.findViewById(R.id.oneImageView);
            oneImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number1);
                    imageView.setEnabled(false);
                }
            });

            ImageView threeImageView = moveDialog.findViewById(R.id.threeImageView);
            threeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number3);
                    imageView.setEnabled(false);
                }
            });

            ImageView fiveImageView = moveDialog.findViewById(R.id.fiveImageView);
            fiveImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number5);
                    imageView.setEnabled(false);
                }
            });

            ImageView sevenImageView = moveDialog.findViewById(R.id.sevenImageView);
            sevenImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number7);
                    imageView.setEnabled(false);
                }
            });

            ImageView nineImageView = moveDialog.findViewById(R.id.nineImageView);
            nineImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number9);
                    imageView.setEnabled(false);
                }
            });
        } else {
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.false_moves, null);
            AlertDialog.Builder moveAlert = new AlertDialog.Builder(this);
            moveAlert.setView(alertLayout);
            moveAlert.setCancelable(true);
            AlertDialog moveDialog = moveAlert.create();
            moveDialog.show();

            ImageView twoImageView = moveDialog.findViewById(R.id.twoImageView);
            twoImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number2);
                    imageView.setEnabled(false);
                }
            });

            ImageView fourImageView = moveDialog.findViewById(R.id.fourImageView);
            fourImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number4);
                    imageView.setEnabled(false);
                }
            });

            ImageView sixImageView = moveDialog.findViewById(R.id.sixImageView);
            sixImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number6);
                    imageView.setEnabled(false);
                }
            });

            ImageView eightImageView = moveDialog.findViewById(R.id.eightImageView);
            eightImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //set image resource, set tint, set enabled
                    imageView.setImageResource(R.drawable.number6);
                    imageView.setEnabled(false);
                }
            });
        }
    }
}
