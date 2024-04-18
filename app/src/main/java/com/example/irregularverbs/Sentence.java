package com.example.irregularverbs;

public class Sentence {
    private String firstPart;
    private String solution;
    private String secondPart;
    private String word;
    public Sentence(String firstPart,String solution,String secondPart,String word){
        this.word=word;
        this.solution=solution;
        this.secondPart=secondPart;
        this.firstPart=firstPart;

    }
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
    }
    public String getFirstPart() {
        return firstPart;
    }
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
