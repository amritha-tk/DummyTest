package com.dummyTesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MooAnalyserTest {
    @Test
    public void testSadMoodAnalyser() throws MoodAnalysisException {
        MooAnalyser mooAnalyser = new MooAnalyser("I am in sad mood");
        String mood = mooAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void testHappyMoodAnalyser() throws MoodAnalysisException {
        MooAnalyser mooAnalyser = new MooAnalyser("This is a happy message");
        String mood = mooAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);

    }
    @Test
    public void givenNullMood_ShouldThrowException() {
        MooAnalyser mooAnalyser = new MooAnalyser(null);
        String mood = null;
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalysisException.class);
            mood = mooAnalyser.analyseMood();
         //   Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysisException e) {

            Assert.assertEquals("Please enter proper message",e.getMessage());
        }

    }
}
