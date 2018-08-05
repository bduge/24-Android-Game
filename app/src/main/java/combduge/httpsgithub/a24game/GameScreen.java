package combduge.httpsgithub.a24game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

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

        //initializes Calculator
        final Calculator eval = new Calculator();

        final TextView equation = findViewById(R.id.equationBox);

        //sets the buttons on the screen to the generated numbers and also event handlers for each button
        //after each number is pressed, it cannot be pressed again to prevent users from typing the number twice
        //number1
        final Button button1 = findViewById(R.id.numberOne);
        final String valueNumber1 = number1.valueToString();
        button1.setText(valueNumber1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation(valueNumber1);
                equation.setText(eval.getEquation());
                button1.setEnabled(false);
                number1.setNumberUsed(true);
            }
        });


        //number2
        final Button button2 = findViewById(R.id.numberTwo);
        final String valueNumber2 = number2.valueToString();
        button2.setText(valueNumber2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eval.writeToEquation(valueNumber2);
                equation.setText(eval.getEquation());
                button2.setEnabled(false);
                number2.setNumberUsed(true);
            }
        });


        //number3
        final Button button3 = findViewById(R.id.numberThree);
        final String valueNumber3 = number3.valueToString();
        button3.setText(valueNumber3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation(valueNumber3);
                equation.setText(eval.getEquation());
                button3.setEnabled(false);
                number3.setNumberUsed(true);
            }
        });

        //number4
        final Button button4 = findViewById(R.id.numberFour);
        final String valueNumber4 = number4.valueToString();
        button4.setText(valueNumber4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eval.writeToEquation(valueNumber4);
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
                        if(x==true){
                            equation.setText("you win!");
                        }
                        else if(x==false){
                            equation.setText("you failed");
                        }
                    }catch(Exception e){
                        equation.setText("please enter a valid equation");
                    }
                    
                }
            }
        });






 /*while(status = true) {
                try {
                    eval.eval(eval.getEquation());
                } catch (Exception e) {
            (eval.parse(eval.getEquation(),valueNumber1)==0)&&(eval.parse(eval.getEquation(),valueNumber2)==0)
                &&(eval.parse(eval.getEquation(),valueNumber3)==0)&&(eval.parse(eval.getEquation(),valueNumber4)==0)
                && (status==true)
                }
            }*/

    }


}

