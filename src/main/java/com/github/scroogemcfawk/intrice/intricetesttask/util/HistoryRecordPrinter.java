package com.github.scroogemcfawk.intrice.intricetesttask.util;

import com.github.scroogemcfawk.intrice.intricetesttask.domain.HistoryRecord;


/**
 * Utility class that converts HistoryRecord to String
 */
public class HistoryRecordPrinter
{
    static public String getTableHeader() {
        return "Bet | Amount | Outcome | Verdict | Diff | StartBalance | EndBalance";
    }

    static public String getTableRecord(HistoryRecord record) {
        var sep = " | ";
        return record.getBet()
               + sep
               + String.format("%.2f", record.getAmount())
               + sep
               + record.getOutcome()
               + sep
               + record.getVerdict()
               + sep
               + String.format("%.2f", record.getDifference())
               + sep
               + String.format("%.2f", record.getStartBalance())
               + sep
               + String.format("%.2f", record.getEndBalance());
    }
}
