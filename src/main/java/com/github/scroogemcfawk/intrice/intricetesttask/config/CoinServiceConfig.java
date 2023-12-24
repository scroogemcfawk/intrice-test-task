package com.github.scroogemcfawk.intrice.intricetesttask.config;

import com.github.scroogemcfawk.intrice.intricetesttask.util.RandomBooleanProvider;
import com.github.scroogemcfawk.intrice.intricetesttask.util.UtilRandomBooleanProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoinServiceConfig
{
    @Bean("randomBooleanProvider")
    RandomBooleanProvider getRandomBooleanProvider() {
        return new UtilRandomBooleanProvider();
    }
}
