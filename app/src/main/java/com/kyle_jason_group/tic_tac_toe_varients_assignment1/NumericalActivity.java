package com.kyle_jason_group.tic_tac_toe_varients_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NumericalActivity extends AppCompatActivity implements View.OnClickListener {

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

        String[] savedGame = readFile();

        turn = true;
        clicked = false;
        counter = 0;
        one = false;
        two = false;
        three = false;
        four = false;
        five = false;
        six = false;
        seven = false;
        eight = false;
        nine = false;

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
            getMove(view.getId());
            clicked = false;
        }
    }

    private void checkForWin() {
        int[][] gameBoard = getGameBoard();
        final String COMPLETE_STRING = "complete";
        final String IN_PROGRESS_STRING = "in progress";
        if (checkHorizontal(gameBoard) || checkVertical(gameBoard) || checkDiagonal(gameBoard)) {
            writeToFile(COMPLETE_STRING);
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
            writeToFile(COMPLETE_STRING);
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
        } else {
            writeToFile(IN_PROGRESS_STRING);
        }
    }

    private void writeToFile(String string) {
        //write to file
    }

    private String[] readFile() {
        //read file
        String[] savedGame = {"complete"};
        return savedGame;
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
                        imageView.setImageResource(R.drawable.number1);
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
                        imageView.setImageResource(R.drawable.number3);
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
                        imageView.setImageResource(R.drawable.number5);
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
                        imageView.setImageResource(R.drawable.number7);
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
                        imageView.setImageResource(R.drawable.number9);
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
                        imageView.setImageResource(R.drawable.number2);
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
                        imageView.setImageResource(R.drawable.number4);
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
                        imageView.setImageResource(R.drawable.number6);
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
                        imageView.setImageResource(R.drawable.number8);
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
