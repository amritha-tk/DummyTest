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
        try {
             mooAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
           Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenEmpty_ShouldThrowException() {
        MooAnalyser mooAnalyser = new MooAnalyser("");
        try {
            mooAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}
