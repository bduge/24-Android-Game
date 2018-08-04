package combduge.httpsgithub.a24game;

/**
 * Created by Bill on 2018-08-03.
 */

public class number {

    public int value;
    public boolean numberUsed = false;

    //generates random number between 1 and 10
    public number(){
        value = (int) (Math.random()*10+1);
    }

    //returns the randomly generated number
    public int getValue(){
        return this.value;
    }

    //returns the number as a string so it can be displayed on the buttons as text
    public String valueToString(){
        return Integer.toString(this.value);
    }

    public boolean getNumberUsed(){
        return numberUsed;
    }
}
