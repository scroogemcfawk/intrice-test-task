package com.github.scroogemcfawk.intrice.intricetesttask.service;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.Gambler;
import com.github.scroogemcfawk.intrice.intricetesttask.domain.Coin;
import com.github.scroogemcfawk.intrice.intricetesttask.domain.HistoryRecord;
import com.github.scroogemcfawk.intrice.intricetesttask.domain.Verdict;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerAlreadyExistsException;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerDoesNotExistException;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.InsufficientFundsException;
import com.github.scroogemcfawk.intrice.intricetesttask.repo.GamblerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Handles Gambler objects.
 */
@Service
public class GamblerService
{
    @Autowired
    private CoinService coinService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private GamblerRepo repo;


    public void register(String nickname) throws GamblerAlreadyExistsException
    {
        repo.add(new Gambler(nickname, 100D));
    }

    public Double getBalance(String nickname) throws GamblerDoesNotExistException
    {
        return repo.get(nickname).getBalance();
    }

    public Verdict play(String nickname, Double amount, Coin bet) throws InsufficientFundsException, GamblerDoesNotExistException
    {
        // get or throw
        var gambler = repo.get(nickname);

        if (gambler.getBalance() < amount)
        {
            throw new InsufficientFundsException();
        }

        var record = new HistoryRecord();
        record.setNickname(gambler.getNickname());
        record.setAmount(amount);
        record.setBet(bet);
        record.setStartBalance(gambler.getBalance());

        gambler.withdraw(amount);

        var outcome = coinService.flip();
        var verdict = Verdict.LOSE;

        record.setOutcome(outcome);

        if (outcome.equals(bet))
        {
            verdict = Verdict.WIN;
            gambler.deposit(amount * 1.9D);
        }

        record.setEndBalance(gambler.getBalance());
        record.setDifference(record.getEndBalance() - record.getStartBalance());
        record.setVerdict(verdict);

        historyService.add(record);

        return verdict;
    }

}
