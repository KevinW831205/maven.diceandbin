package com.github.curriculeon;

public class Dice {
    Die[] dice;
    Integer numberOfDie;
    Integer numberOfFaces;

    /**
     * @param numberOfDie - number of die-objects to be contained
     */
    public Dice(Integer numberOfDie) {
        this(numberOfDie, 6);
    }

    /**
     * @param numberOfDie   - number of die-objects to be contained
     * @param numberOfFaces - number of faces on a single die-object
     */
    public Dice(Integer numberOfDie, Integer numberOfFaces) {
        if(numberOfDie <1 || numberOfFaces <=1){
            throw new IllegalArgumentException();
        }

        Die[] temp = new Die[numberOfDie];
        for(int i=0; i<numberOfDie; i++){
            temp[i] = new Die(numberOfFaces);
        }
        this.dice = temp;
        this.numberOfDie = numberOfDie;
        this.numberOfFaces = numberOfFaces;
    }

    /**
     * Create a random number from 1 to 6 for each dice you roll
     * sum all of the random numbers up and that equals total for that roll
     */
    public Integer rollAndSum() {
        int sum =0;
        for(Die d : dice){
            d.roll();
            sum += d.getCurrentFaceValue();
        }
        return sum;
    }

    /**
     * @return the absolute minimum value that can be rolled by this set of die
     */
    public Integer getRollMin() {
        return numberOfDie;
    }

    /**
     * @return the absolute maximum value that can be rolled by this set of die
     */
    public Integer getRollMax() {
        return numberOfDie * numberOfFaces;
    }
}
