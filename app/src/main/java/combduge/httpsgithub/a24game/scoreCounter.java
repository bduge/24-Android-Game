package combduge.httpsgithub.a24game;

/**
 * Created by Bill on 2018-08-06.
 */

import android.content.SharedPreferences;

public class scoreCounter {

    int score = 0;

    public void addScore(){
        score++;
    }

    public void clearScore(){
        score = 0;
    }
}
