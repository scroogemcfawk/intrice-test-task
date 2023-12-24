package com.github.scroogemcfawk.intrice.intricetesttask.service;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.HistoryRecord;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerDoesNotExistException;
import com.github.scroogemcfawk.intrice.intricetesttask.repo.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * Handles HistoryRecord objects.
 */
@Service
public class HistoryService
{

    @Autowired
    private HistoryRepo repo;

    public void add(HistoryRecord record)
    {
        repo.add(record);
    }

    public ArrayList<HistoryRecord> get(String nickname) throws GamblerDoesNotExistException
    {
        return repo.get(nickname);
    }

}
