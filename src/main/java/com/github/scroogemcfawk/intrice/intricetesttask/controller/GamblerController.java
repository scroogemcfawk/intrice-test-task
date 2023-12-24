package com.github.scroogemcfawk.intrice.intricetesttask.controller;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.Coin;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerAlreadyExistsException;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.GamblerDoesNotExistException;
import com.github.scroogemcfawk.intrice.intricetesttask.exception.InsufficientFundsException;
import com.github.scroogemcfawk.intrice.intricetesttask.service.GamblerService;
import com.github.scroogemcfawk.intrice.intricetesttask.service.HistoryService;
import com.github.scroogemcfawk.intrice.intricetesttask.util.HistoryRecordPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

/**
 * An interface for gambling services.
 */
@RestController
@RequestMapping("/gambler")
public class GamblerController
{

    @Autowired
    GamblerService gamblerService;

    @Autowired
    HistoryService historyService;

    @PostMapping("/register")
//    @RequestMapping("")
    String register(@RequestParam String nickname) {
        try {
            gamblerService.register(nickname);
            return "You have been registered!";
        } catch (GamblerAlreadyExistsException e) {
            return MessageFormat.format("Gambler with nickname {0} already exists. Try another nickname.", nickname);
        }
    }

//    @RequestMapping("/balance")
    @GetMapping("/balance")
    String getBalance(@RequestParam String nickname) {
        try {
            return gamblerService.getBalance(nickname).toString();
        }
        catch (GamblerDoesNotExistException e)
        {
            return MessageFormat.format("Gambler with nickname {0} does not exist.", nickname);
        }
    }

//    @RequestMapping("/history")
    @GetMapping("/history")
    String getHistory(@RequestParam String nickname) {
        try {
            var result = new StringBuilder();
            result.append(HistoryRecordPrinter.getTableHeader()).append("\n");
            historyService.get(nickname).forEach( record -> result.append(HistoryRecordPrinter.getTableRecord(record)).append("\n")
            );
            return result.toString();
        }
        catch (GamblerDoesNotExistException e)
        {
            return MessageFormat.format("Gambler with nickname {0} has no game history.", nickname);
        }
    }

//    @RequestMapping("/bet")
    @PostMapping("/bet")
    String bet(
            @RequestParam String nickname,
            @RequestParam Double amount,
            @RequestParam Coin bet
    ) {
        try {
            return gamblerService.play(nickname, amount, bet).toString();
        }
        catch (GamblerDoesNotExistException e)
        {
            return MessageFormat.format("Gambler with nickname {0} does not exist.", nickname);
        }
        catch (InsufficientFundsException e)
        {
            return MessageFormat.format("Gambler with nickname {0} has insufficient balance.", nickname);
        }

    }

}
