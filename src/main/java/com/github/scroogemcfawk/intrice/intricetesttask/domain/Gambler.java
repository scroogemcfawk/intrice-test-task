package com.github.scroogemcfawk.intrice.intricetesttask.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Gambler
{
    private String nickname;
    private Double balance;

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        balance -= amount;
    }
}
