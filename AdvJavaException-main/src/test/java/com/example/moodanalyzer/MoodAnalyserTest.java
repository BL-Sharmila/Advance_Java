package com.example.moodanalyzer;


import org.junit.Test;
import static org.junit.Assert.*;

public class MoodAnalyserTest {
	
	@Test
	public void givenSadMood_ShouldReturnSad() throws Exception {
	    MoodAnalyzer analyser = new MoodAnalyzer();
	    assertEquals("SAD", analyser.analyseMood("I am in Sad Mood"));
	}

	@Test(expected = MoodAnalysisException.class)
	public void givenNullMood_ShouldThrowException() throws Exception {
	    MoodAnalyzer analyser = new MoodAnalyzer();
	    analyser.analyseMood(null);
	}

}
