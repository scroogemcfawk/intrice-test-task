package com.github.scroogemcfawk.intrice.intricetesttask.service;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.Coin;
import com.github.scroogemcfawk.intrice.intricetesttask.util.RandomBooleanProvider;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * Flips a coin and tells the result.
 */
@Service
public class CoinService
{

    @Resource(name = "randomBooleanProvider")
    private RandomBooleanProvider random;

    Coin flip() {
        return random.nextBoolean() ? Coin.HEADS : Coin.TAILS;
    }
}
