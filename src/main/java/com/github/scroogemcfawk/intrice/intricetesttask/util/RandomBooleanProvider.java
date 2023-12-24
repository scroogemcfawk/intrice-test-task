package com.github.scroogemcfawk.intrice.intricetesttask.util;


/**
 * This class implements RandomBooleanProvider interface.
 * It's made in order to decouple OutcomeService from a class that provides random methods.
 * The reason is that it's supposed to be used with gambling-like system, so pseudo-random
 * might bring vulnerabilities to it, therefore implementation can be easily changed with
 * no need to change the code that depends on it.
 */
public interface RandomBooleanProvider
{
    boolean nextBoolean();
}
