package combduge.httpsgithub.a24game;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

//activity for the timed mode
public class timedMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //initializes the new numbers
        final number number1 = new number();
        final number number2 = new number();
        final number number3 = new number();
        final number number4 = new number();

        //initializes boolean status
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //initializes Calculator
        final Calculator eval = new Calculator();

        //initializes shared preferences for high score
        final SharedPreferences prefs = this.getSharedPreferences("HighScoreTracker", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        final TextView highScore = findViewById(R.id.highscore);
        highScore.setText(String.format("High score: %d", prefs.getInt("Highscore",0)));

        //initializes equation
        final TextView equation = findViewById(R.id.equationBox);

        //initializes score counter
        final TextView score = findViewById(R.id.score);
        final scoreCounter count = new scoreCounter();
        score.setText(String.format("Score: %d", count.score));

        //sets the buttons on the screen to the generated numbers and also event handlers for each button
        //after each number is pressed, it cannot be pressed again to prevent users from typing the number twice
        //number1
        final Button button1 = findViewById(R.id.numberOne);
        button1.setText(number1.valueToString());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation(number1.valueToString());
                equation.setText(eval.getEquation());
                button1.setEnabled(false);
                number1.setNumberUsed(true);
            }
        });


        //number2
        final Button button2 = findViewById(R.id.numberTwo);
        button2.setText(number2.valueToString());
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eval.writeToEquation(number2.valueToString());
                equation.setText(eval.getEquation());
                button2.setEnabled(false);
                number2.setNumberUsed(true);
            }
        });


        //number3
        final Button button3 = findViewById(R.id.numberThree);
        button3.setText(number3.valueToString());
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation(number3.valueToString());
                equation.setText(eval.getEquation());
                button3.setEnabled(false);
                number3.setNumberUsed(true);
            }
        });

        //number4
        final Button button4 = findViewById(R.id.numberFour);
        button4.setText(number4.valueToString());
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation(number4.valueToString());
                equation.setText(eval.getEquation());
                button4.setEnabled(false);
                number4.setNumberUsed(true);
            }
        });



        //handlers for the buttons to add to the equation

        //add
        Button addButton = findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation("+");
                equation.setText(eval.getEquation());
            }
        });

        //subtract
        Button subButton = findViewById(R.id.subtract);
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation("-");
                equation.setText(eval.getEquation());
            }
        });

        //multiply
        Button multiButton = findViewById(R.id.multiply);
        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation("*");
                equation.setText(eval.getEquation());
            }
        });

        //divide
        Button divButton = findViewById(R.id.divide);
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation("/");
                equation.setText(eval.getEquation());
            }
        });

        //start bracket
        Button sBracketButton = findViewById(R.id.startBracket);
        sBracketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation("(");
                equation.setText(eval.getEquation());
            }
        });

        //end bracket
        Button eBracketButton = findViewById(R.id.endBracket);
        eBracketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation(")");
                equation.setText(eval.getEquation());
            }
        });

        //clears equation box and makes all numbers clickable again
        Button clearButton = findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.clearEquation();
                equation.setText(eval.getEquation());
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);

                number1.setNumberUsed(false);
                number2.setNumberUsed(false);
                number3.setNumberUsed(false);
                number4.setNumberUsed(false);
            }
        });

        //after all 4 numbers are inputted, user can press enter to finalize their answer

        final Button enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number1.getNumberUsed() && number2.getNumberUsed()
                        && number3.getNumberUsed() && number4.getNumberUsed()){

                    try{
                        boolean x = eval.checkAnswer(eval.getEquation());
                        AlertDialog.Builder builder = new AlertDialog.Builder(timedMode.this);
                        if(x==true){
                            builder.setMessage("correct!")
                                    .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    });
                            AlertDialog winNotification = builder.create();
                            winNotification.setTitle("24 Game");
                            winNotification.show();

                            count.addScore();
                            score.setText(String.format("Score: %d", count.score));
                        }
                        else if(x==false){
                            builder .setMessage("incorrect")
                                    .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    });
                            AlertDialog loseNotification = builder.create();
                            loseNotification.setTitle("24 Game");
                            loseNotification.show();
                        }
                        number1.generateNewValue();
                        number2.generateNewValue();
                        number3.generateNewValue();
                        number4.generateNewValue();

                        button1.setText(number1.valueToString());
                        button2.setText(number2.valueToString());
                        button3.setText(number3.valueToString());
                        button4.setText(number4.valueToString());

                        eval.clearEquation();
                        equation.setText(eval.getEquation());
                        button1.setEnabled(true);
                        button2.setEnabled(true);
                        button3.setEnabled(true);
                        button4.setEnabled(true);

                    }catch(Exception e){
                        equation.setText("please enter a valid equation");
                    }

                }
                else{
                    builder.setMessage("You must use all four numbers")
                            .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                    AlertDialog info = builder.create();
                    info.setTitle("24 Game");
                    info.show();
                }
            }
        });

        //set up skip functionality
        Button skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                number1.generateNewValue();
                number2.generateNewValue();
                number3.generateNewValue();
                number4.generateNewValue();

                button1.setText(number1.valueToString());
                button2.setText(number2.valueToString());
                button3.setText(number3.valueToString());
                button4.setText(number4.valueToString());

                eval.clearEquation();
                equation.setText(eval.getEquation());
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
            }
        });

        //set up timer
        //timer counts down from 120 seconds and displays game over screen
        //different game over screen messages depending on the players performance
        final TextView timeCounter = findViewById(R.id.timer);
        CountDownTimer timer = new CountDownTimer(121000,1000) {
            @Override
            public void onTick(long timeUntilFinished) {
                timeCounter.setText(String.format("Time remaining: %d", timeUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                if(count.score > prefs.getInt("Highscore", 0)){
                    editor.putInt("Highscore", count.score);
                    editor.commit();
                }
                if(count.score >=0 && count.score <2){
                    builder.setMessage(String.format("Better luck next time... \n Your score was: %d", count.score))
                            .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                }
                else if(count.score>=2 && count.score<4) {
                    builder.setMessage(String.format("Not bad. \n Your score was: %d", count.score))
                            .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                }
                else if(count.score>=4) {
                    builder.setMessage(String.format("Amazing! \n Your score was: %d", count.score))
                            .setPositiveButton("okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                }
                AlertDialog gameEnd = builder.create();
                gameEnd.setTitle("24 Game");
                gameEnd.show();

            }
        };
        timer.start();
    }
}
