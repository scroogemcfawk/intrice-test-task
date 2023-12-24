package com.github.scroogemcfawk.intrice.intricetesttask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryRecord
{
    private String nickname;
    private Double amount;
    private Coin bet;
    private Double startBalance;
    private Coin outcome;
    private Verdict verdict;
    private Double endBalance;
    private Double difference;
}
