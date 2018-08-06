package combduge.httpsgithub.a24game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //event handling for start button, sends user to game screen
        Button startCasualButton = findViewById(R.id.casualMode);
        startCasualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, casualMode.class));
            }
        });

        Button startTimedButton = findViewById(R.id.timedMode);
        startTimedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, timedMode.class));
            }
        });

    }
}
