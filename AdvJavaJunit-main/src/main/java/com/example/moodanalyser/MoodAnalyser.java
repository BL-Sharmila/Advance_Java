package com.example.moodanalyser;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() {
        if (message == null || message.isEmpty()) return "HAPPY";
        if (message.toLowerCase().contains("sad")) return "SAD";
        return "HAPPY";
    }
}
