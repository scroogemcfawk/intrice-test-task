package com.github.scroogemcfawk.intrice.intricetesttask.util;


import java.util.Random;


/**
 * RandomBooleanProvider implementation based on java.util.Random
 */
public class UtilRandomBooleanProvider implements RandomBooleanProvider
{
    private final Random random = new Random();
    @Override
    public boolean nextBoolean()
    {
        return random.nextBoolean();
    }
}
