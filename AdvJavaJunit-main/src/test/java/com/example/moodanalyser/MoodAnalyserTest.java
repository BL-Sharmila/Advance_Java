package com.example.moodanalyser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoodAnalyserTest {

    @Test
    public void givenMessage_WhenSad_ShouldReturnSAD() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood");
        assertEquals("SAD", moodAnalyser.analyseMood());
    }

    @Test
    public void givenMessage_WhenHappy_ShouldReturnHAPPY() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy mood");
        assertEquals("HAPPY", moodAnalyser.analyseMood());
    }

    @Test
    public void givenNullMessage_ShouldReturnHAPPY() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        assertEquals("HAPPY", moodAnalyser.analyseMood());
    }
}
