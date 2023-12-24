package com.github.scroogemcfawk.intrice.intricetesttask.repo;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.Gambler;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerAlreadyExistsException;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class HashMapGamblerRepo implements GamblerRepo
{
    private final HashMap<String, Gambler> map = new HashMap<>();

    @Override
    public void add(Gambler gambler) throws GamblerAlreadyExistsException
    {
        var nickname = gambler.getNickname();
        if (map.containsKey(nickname))
        {
            throw new GamblerAlreadyExistsException();
        }
        map.put(gambler.getNickname(), gambler);
    }

    @Override
    public Gambler get(String nickname) throws GamblerDoesNotExistException
    {
        if (!map.containsKey(nickname)) throw new GamblerDoesNotExistException();
        return map.get(nickname);
    }

}
