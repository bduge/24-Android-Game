package combduge.httpsgithub.a24game;

/**
 * Created by Bill on 2018-08-03.
 */

public class number {

    //class for the four numbers generated each round
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

    //changes the numberUsed boolean to the input based on the situation
    //used so that each number can only be inputted once
    public void setNumberUsed(boolean x){
        numberUsed = x;
    }

    //returns the state of the boolean numberUsed
    public boolean getNumberUsed(){
        return this.numberUsed;
    }

    //same as number() function, named differently for clarity
    public void generateNewValue(){
        value = (int) (Math.random()*10+1);
    }
}


