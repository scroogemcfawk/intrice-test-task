package com.github.scroogemcfawk.intrice.intricetesttask.repo;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.HistoryRecord;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerDoesNotExistException;

import java.util.ArrayList;


public interface HistoryRepo
{
    void add(HistoryRecord record);

    ArrayList<HistoryRecord> get(String nickname)  throws GamblerDoesNotExistException;

}
