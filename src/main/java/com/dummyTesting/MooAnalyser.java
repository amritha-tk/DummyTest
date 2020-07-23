package com.dummyTesting;

public class MooAnalyser {
    String message;

    public MooAnalyser() {

    }

    public MooAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() {
        try {
            if (message.contains("sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        }catch (NullPointerException e){
            return "HAPPY";
        }
    }
}
