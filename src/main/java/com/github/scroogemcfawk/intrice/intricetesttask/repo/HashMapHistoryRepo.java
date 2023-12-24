package com.github.scroogemcfawk.intrice.intricetesttask.repo;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.HistoryRecord;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;


@Repository
public class HashMapHistoryRepo implements HistoryRepo
{
    private final HashMap<String, ArrayList<HistoryRecord>> map = new HashMap<>();

    @Override
    public void add(HistoryRecord record)
    {
        var nickname = record.getNickname();
        if (!map.containsKey(nickname))
        {
            map.put(nickname, new ArrayList<>());
        }
        map.get(nickname).add(record);
    }

    @Override
    public ArrayList<HistoryRecord> get(String nickname) throws GamblerDoesNotExistException
    {
        if (!map.containsKey(nickname)) throw new GamblerDoesNotExistException();
        return map.get(nickname);
    }

}
