package com.dummyTesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MooAnalyserTest {
    @Test
    public void testSadMoodAnalyser() {
        MooAnalyser mooAnalyser = new MooAnalyser("I am in sad mood");
        String mood = mooAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void testHappyMoodAnalyser() {
        MooAnalyser mooAnalyser = new MooAnalyser(null);
        String mood = mooAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);

    }
}
