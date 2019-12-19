package com.github.curriculeon;

public class Die {
    Integer numberOfFaces;
    Integer currentFaceValue;

    public Die() {
        this(6);
    }

    public Die(Integer numberOfFaces) {
        if(numberOfFaces!=null && numberOfFaces <= 1){
            throw new IllegalArgumentException();
        }
        this.numberOfFaces = numberOfFaces;
    }

    public void roll() {
        this.currentFaceValue = (int)Math.random()*numberOfFaces +1;
    }

    public Integer getCurrentFaceValue() {
        return this.currentFaceValue;
    }

    public Integer getNumberOfFaces() {
        return this.numberOfFaces;
    }
}
