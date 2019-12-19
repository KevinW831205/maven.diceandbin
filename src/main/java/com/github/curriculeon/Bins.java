package com.github.curriculeon;

public class Bins {
    Integer minFaceValue;
    Integer maxFaceValue;
    Bin[] valuesTracking;

    public Bins() {
        this(1,6);
    }

    public Bins(Integer minFaceValue, Integer maxFaceValue) {
        if(maxFaceValue-minFaceValue <0){
            throw new NegativeArraySizeException();
        }
        this.minFaceValue = minFaceValue;
        this.maxFaceValue = maxFaceValue;
        valuesTracking = new Bin[maxFaceValue - minFaceValue + 1];
        for (Integer i = 0; i < maxFaceValue - minFaceValue + 1; i++) {
            valuesTracking[i] = new Bin(minFaceValue + i);
        }
    }

    public void incrementBin(Integer faceValueToIncrement) {
        this.valuesTracking[faceValueToIncrement - minFaceValue].increment();
    }

    public Bin getBin(Integer value) {
        return this.valuesTracking[value - minFaceValue];
    }

    public Bin[] getBins() {
        return this.valuesTracking;
    }
}
