package com.github.scroogemcfawk.intrice.intricetesttask.repo;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.Gambler;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerAlreadyExistsException;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerDoesNotExistException;

public interface GamblerRepo
{
    void add(Gambler gambler) throws GamblerAlreadyExistsException;

    Gambler get(String nickname) throws GamblerDoesNotExistException;

}
