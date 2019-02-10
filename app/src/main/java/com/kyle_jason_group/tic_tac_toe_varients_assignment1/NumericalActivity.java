package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NumericalActivity extends AppCompatActivity implements View.OnClickListener {

    private final String NUMERICAL_PREFS = "numericalPrefs";

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
    private final String ONE = "one";
    private final String TWO = "two";
    private final String THREE = "three";
    private final String FOUR = "four";
    private final String FIVE = "five";
    private final String SIX = "six";
    private final String SEVEN = "seven";
    private final String EIGHT = "eight";
    private final String NINE = "nine";


    private boolean turn;
    private boolean clicked;
    private int counter;
    private boolean one;
    private boolean two;
    private boolean three;
    private boolean four;
    private boolean five;
    private boolean six;
    private boolean seven;
    private boolean eight;
    private boolean nine;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical);

        sharedPreferences = getSharedPreferences(NUMERICAL_PREFS, Context.MODE_PRIVATE);

        turn = sharedPreferences.getBoolean(TURN, true);
        clicked = false;
        counter = sharedPreferences.getInt(COUNTER, 0);
        one = sharedPreferences.getBoolean(ONE, false);
        two = sharedPreferences.getBoolean(TWO, false);
        three = sharedPreferences.getBoolean(THREE, false);
        four = sharedPreferences.getBoolean(FOUR, false);
        five = sharedPreferences.getBoolean(FIVE, false);
        six = sharedPreferences.getBoolean(SIX, false);
        seven = sharedPreferences.getBoolean(SEVEN, false);
        eight = sharedPreferences.getBoolean(EIGHT, false);
        nine = sharedPreferences.getBoolean(NINE, false);

        ImageView imageView;
        int tag;

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_1, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_2, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView3);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_3, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView4);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_4, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView5);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_5, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView6);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_6, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView7);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_7, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView8);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_8, 42);
        setGameBoard(tag, imageView);
        imageView = findViewById(R.id.imageView9);
        imageView.setOnClickListener(this);
        tag = sharedPreferences.getInt(BOX_9, 42);
        setGameBoard(tag, imageView);
    }

    private void setGameBoard(int tag, ImageView imageView) {
        if (tag == 1) {
            imageView.setImageResource(R.drawable.ttt_1);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 2) {
            imageView.setImageResource(R.drawable.ttt_2);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 3) {
            imageView.setImageResource(R.drawable.ttt_3);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 4) {
            imageView.setImageResource(R.drawable.ttt_4);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 5) {
            imageView.setImageResource(R.drawable.ttt_5);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 6) {
            imageView.setImageResource(R.drawable.ttt_6);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 7) {
            imageView.setImageResource(R.drawable.ttt_7);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 8) {
            imageView.setImageResource(R.drawable.ttt_8);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        } else if (tag == 9) {
            imageView.setImageResource(R.drawable.ttt_9);
            imageView.setTag(tag);
            imageView.setEnabled(false);
        }
    }

    @Override
    public void onClick(View view) {
        if (clicked) {
            return;
        } else {
            clicked = true;
            getMove(view.getId());
            clicked = false;
        }
    }

    @Override
    protected void onPause() {
        int[][] gameBoard = getGameBoard();
        if (!checkHorizontal(gameBoard) && !checkVertical(gameBoard) && !checkDiagonal(gameBoard)
        && counter < 9) {
            saveGame();
        }
        super.onPause();
    }

    private void saveGame() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TURN, turn);
        editor.putInt(COUNTER, counter);
        editor.putBoolean(ONE, one);
        editor.putBoolean(TWO, two);
        editor.putBoolean(THREE, three);
        editor.putBoolean(FOUR, four);
        editor.putBoolean(FIVE, five);
        editor.putBoolean(SIX, six);
        editor.putBoolean(SEVEN, seven);
        editor.putBoolean(EIGHT, eight);
        editor.putBoolean(NINE, nine);
        editor.putInt(BOX_1, Integer.valueOf(findViewById(R.id.imageView).getTag().toString()));
        editor.putInt(BOX_2, Integer.valueOf(findViewById(R.id.imageView2).getTag().toString()));
        editor.putInt(BOX_3, Integer.valueOf(findViewById(R.id.imageView3).getTag().toString()));
        editor.putInt(BOX_4, Integer.valueOf(findViewById(R.id.imageView4).getTag().toString()));
        editor.putInt(BOX_5, Integer.valueOf(findViewById(R.id.imageView5).getTag().toString()));
        editor.putInt(BOX_6, Integer.valueOf(findViewById(R.id.imageView6).getTag().toString()));
        editor.putInt(BOX_7, Integer.valueOf(findViewById(R.id.imageView7).getTag().toString()));
        editor.putInt(BOX_8, Integer.valueOf(findViewById(R.id.imageView8).getTag().toString()));
        editor.putInt(BOX_9, Integer.valueOf(findViewById(R.id.imageView9).getTag().toString()));
        editor.apply();
    }

    private void checkForWin() {
        int[][] gameBoard = getGameBoard();
        if (checkHorizontal(gameBoard) || checkVertical(gameBoard) || checkDiagonal(gameBoard)) {
            clearPreferences();
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.win_dialog, null);
            AlertDialog.Builder winAlert = new AlertDialog.Builder(this);
            winAlert.setView(alertLayout);
            winAlert.setCancelable(false);
            AlertDialog winDialog = winAlert.create();
            winDialog.show();
            TextView winTextView = winDialog.findViewById(R.id.winTextView);
            if (turn) {
                winTextView.setText(R.string.odd_wins);
            } else {
                winTextView.setText(R.string.even_wins);
            }
            winDialog.findViewById(R.id.quitTextView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            winDialog.findViewById(R.id.playTextView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), NumericalActivity.class);
                    startActivity(intent);
                }
            });
        } else if (counter >= 9) {
            clearPreferences();
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.win_dialog, null);
            AlertDialog.Builder winAlert = new AlertDialog.Builder(this);
            winAlert.setView(alertLayout);
            winAlert.setCancelable(false);
            AlertDialog winDialog = winAlert.create();
            winDialog.show();
            TextView winTextView = winDialog.findViewById(R.id.winTextView);
            winTextView.setText(R.string.tie);
            winDialog.findViewById(R.id.quitTextView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            winDialog.findViewById(R.id.playTextView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), NumericalActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    private void clearPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TURN, true);
        editor.putInt(COUNTER, 0);
        editor.putBoolean(ONE, false);
        editor.putBoolean(TWO, false);
        editor.putBoolean(THREE, false);
        editor.putBoolean(FOUR, false);
        editor.putBoolean(FIVE, false);
        editor.putBoolean(SIX, false);
        editor.putBoolean(SEVEN, false);
        editor.putBoolean(EIGHT, false);
        editor.putBoolean(NINE, false);
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

    private void getMove(int view) {
        final ImageView imageView = findViewById(view);
        if (turn) {
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.true_moves, null);
            AlertDialog.Builder moveAlert = new AlertDialog.Builder(this);
            moveAlert.setView(alertLayout);
            moveAlert.setCancelable(true);
            final AlertDialog moveDialog = moveAlert.create();
            moveDialog.show();

            final ImageView oneImageView = moveDialog.findViewById(R.id.oneImageView);
            if (one) {
                oneImageView.setVisibility(View.GONE);
            } else {
                oneImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        one = true;
                        imageView.setImageResource(R.drawable.ttt_1);
                        imageView.setEnabled(false);
                        imageView.setTag("1");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }

            ImageView threeImageView = moveDialog.findViewById(R.id.threeImageView);
            if (three) {
                threeImageView.setVisibility(View.GONE);
            } else {
                threeImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        three = true;
                        imageView.setImageResource(R.drawable.ttt_3);
                        imageView.setEnabled(false);
                        imageView.setTag("3");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }

            ImageView fiveImageView = moveDialog.findViewById(R.id.fiveImageView);
            if (five) {
                fiveImageView.setVisibility(View.GONE);
            } else {
                fiveImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        five = true;
                        imageView.setImageResource(R.drawable.ttt_5);
                        imageView.setEnabled(false);
                        imageView.setTag("5");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }

            ImageView sevenImageView = moveDialog.findViewById(R.id.sevenImageView);
            if (seven) {
                sevenImageView.setVisibility(View.GONE);
            } else {
                sevenImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        seven = true;
                        imageView.setImageResource(R.drawable.ttt_7);
                        imageView.setEnabled(false);
                        imageView.setTag("7");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }

            ImageView nineImageView = moveDialog.findViewById(R.id.nineImageView);
            if (nine) {
                nineImageView.setVisibility(View.GONE);
            } else {
                nineImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nine = true;
                        imageView.setImageResource(R.drawable.ttt_9);
                        imageView.setEnabled(false);
                        imageView.setTag("9");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }
        } else {
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.false_moves, null);
            AlertDialog.Builder moveAlert = new AlertDialog.Builder(this);
            moveAlert.setView(alertLayout);
            moveAlert.setCancelable(true);
            final AlertDialog moveDialog = moveAlert.create();
            moveDialog.show();

            ImageView twoImageView = moveDialog.findViewById(R.id.twoImageView);
            if (two) {
                twoImageView.setVisibility(View.GONE);
            } else {
                twoImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        two = true;
                        imageView.setImageResource(R.drawable.ttt_2);
                        imageView.setEnabled(false);
                        imageView.setTag("2");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }

            ImageView fourImageView = moveDialog.findViewById(R.id.fourImageView);
            if (four) {
                fourImageView.setVisibility(View.GONE);
            } else {
                fourImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        four = true;
                        imageView.setImageResource(R.drawable.ttt_4);
                        imageView.setEnabled(false);
                        imageView.setTag("4");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }

            ImageView sixImageView = moveDialog.findViewById(R.id.sixImageView);
            if (six) {
                sixImageView.setVisibility(View.GONE);
            } else {
                sixImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        six = true;
                        imageView.setImageResource(R.drawable.ttt_6);
                        imageView.setEnabled(false);
                        imageView.setTag("6");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }

            ImageView eightImageView = moveDialog.findViewById(R.id.eightImageView);
            if (eight) {
                eightImageView.setVisibility(View.GONE);
            } else {
                eightImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eight = true;
                        imageView.setImageResource(R.drawable.ttt_8);
                        imageView.setEnabled(false);
                        imageView.setTag("8");
                        counter++;
                        checkForWin();
                        turn = !turn;
                        moveDialog.dismiss();
                    }
                });
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (counter >= 1) {
            LayoutInflater inflater = getLayoutInflater();
            View alertLayout = inflater.inflate(R.layout.quit_dialog, null);
            AlertDialog.Builder quitAlert = new AlertDialog.Builder(this);
            quitAlert.setView(alertLayout);
            quitAlert.setCancelable(true);
            final AlertDialog quitDialog = quitAlert.create();
            quitDialog.show();
            quitDialog.findViewById(R.id.quitTextView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NumericalActivity.super.onBackPressed();
                }
            });
            quitDialog.findViewById(R.id.cancelTextView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    quitDialog.dismiss();
                }
            });
        } else {
            super.onBackPressed();
        }
    }
}
