package com.dummyTesting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MooAnalyserTest {
    @Test
    public void testMoodAnalyser() {
        MooAnalyser mooAnalyser = new MooAnalyser();
        String mood = mooAnalyser.analyseMood("This is a sad message");
        Assert.assertEquals("SAD",mood);
    }

}
