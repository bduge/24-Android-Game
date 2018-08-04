package combduge.httpsgithub.a24game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

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

        //sets the buttons on the screen to the generated numbers
        Button button1 = findViewById(R.id.numberOne);
        button1.setText(number1.valueToString());
        Button button2 = findViewById(R.id.numberTwo);
        button2.setText(number2.valueToString());
        Button button3 = findViewById(R.id.numberThree);
        button3.setText(number3.valueToString());
        Button button4 = findViewById(R.id.numberFour);
        button4.setText(number4.valueToString());

    }
}
