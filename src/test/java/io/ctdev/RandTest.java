package io.ctdev;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RandTest {
    @Test
    public void testRandom() {
        int maxRange = 10;
        Random rand = new Random();
        int randomInt = rand.nextInt(maxRange);
        Assert.assertTrue(randomInt >= 0);
        Assert.assertTrue(randomInt <= maxRange);
    }
}