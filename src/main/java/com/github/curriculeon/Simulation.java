package com.github.curriculeon;

public class Simulation {
    Integer numberOfDie;
    Integer numberOfTosses;
    Bins bins;
    Dice dice;

    public Simulation(Integer numberOfDie, Integer numberOfTosses) {
        this.numberOfDie = numberOfDie;
        this.numberOfTosses=numberOfTosses;
    }

    public void run() {
        this.dice = new Dice(numberOfDie);
        this.bins = new Bins(dice.getRollMin(), dice.getRollMax());
        for(int i=0; i< numberOfTosses; i++){
            bins.incrementBin(dice.rollAndSum());
        }
    }

    public Double getPercentageOfOccurrences(Integer faceValueToCheck) {

        int occurrenceOfValue = bins.getBin(faceValueToCheck).getNumberOfOccurrences();
        int totalOccurrence=0;
        for(Bin b: bins.getBins()){
            totalOccurrence += b.getNumberOfOccurrences();
        }
        return (double)occurrenceOfValue/(double)totalOccurrence;
    }

    @Override
    public String toString() {

        String output ="";
        for(Bin bin :bins.getBins()){
            output += String.format("%3s" , bin.getFaceValueToTrack())+ " : ";
            output += String.format( "%8s",bin.getNumberOfOccurrences() ) + " : ";
            output += getPercentageOfOccurrences(bin.getFaceValueToTrack())+"\n";
        }
        return output;
    }

    public Bins getBins() {
        return this.bins;
    }
}
