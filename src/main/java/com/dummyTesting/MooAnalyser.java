package com.dummyTesting;

public class MooAnalyser {
    String message;

    public MooAnalyser() {

    }

    public MooAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() {
        if (message.contains("sad")) {
            return "SAD";
        }
        else {
            return "HAPPY";
        }
    }
}
