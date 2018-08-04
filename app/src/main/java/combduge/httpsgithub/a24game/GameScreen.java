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
        number number1 = new number();
        number number2 = new number();
        number number3 = new number();
        number number4 = new number();

        //initializes Calculator
        final Calculator eval = new Calculator();

        final TextView equation = findViewById(R.id.equationBox);

        //ensures each number can only be typed once
        boolean status = true;
        /*while(status == true){
            eval.parse(number1.valueToString());
            eval.parse(number2.valueToString());
            eval.parse(number3.valueToString());
            eval.parse(number4.valueToString());
        }*/
        //sets the buttons on the screen to the generated numbers and also event handlers for each button

        //number1
        final Button button1 = findViewById(R.id.numberOne);
        final String valueNumber1 = number1.valueToString();
        button1.setText(valueNumber1);
        if (eval.parse(eval.getEquation(), number1.valueToString()) < 0) {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    eval.writeToEquation(valueNumber1);
                    equation.setText(eval.getEquation());
                }
            });
        }

        //number2
        final Button button2 = findViewById(R.id.numberTwo);
        final String valueNumber2 = number2.valueToString();
        button2.setText(valueNumber2);
        if (eval.parse(eval.getEquation(), number2.valueToString()) < 0) {
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    eval.writeToEquation(valueNumber2);
                    equation.setText(eval.getEquation());
                }
            });
        }

        //number3
        Button button3 = findViewById(R.id.numberThree);
        final String valueNumber3 = number3.valueToString();
        button3.setText(valueNumber3);
        if (eval.parse(eval.getEquation(), number3.valueToString()) < 0) {
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    eval.writeToEquation(valueNumber3);
                    equation.setText(eval.getEquation());
                }
            });

            //number4
            Button button4 = findViewById(R.id.numberFour);
            final String valueNumber4 = number4.valueToString();
            button4.setText(valueNumber4);
            if (eval.parse(eval.getEquation(), number4.valueToString()) < 0) {
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        eval.writeToEquation(valueNumber4);
                        equation.setText(eval.getEquation());
                    }
                });
            }


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

            Button clearButton = findViewById(R.id.clear);
            clearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    eval.clearEquation();
                    equation.setText(eval.getEquation());
                }
            });

            //displays the equation to the textbox

            //creates enter button to finalize equation
        /*if((eval.parse(number1.valueToString())<0) && (eval.parse(number2.valueToString())<0)&&
                (eval.parse(number3.valueToString())<0) && (eval.parse(number4.valueToString())<0)){

        }   */

        }


    }
}
