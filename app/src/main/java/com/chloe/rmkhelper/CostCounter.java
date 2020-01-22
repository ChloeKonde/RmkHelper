package com.chloe.rmkhelper;

import java.time.DayOfWeek;
import java.time.LocalDate;

class CostCounter {
    private int cash;
    private int card;

    CostCounter(int cash, int card){
        this.cash = cash;
        this.card = card;
    }

    int getCash() {
        return this.cash;
    }

    int getCard() {
        return this.card;
    }

    private void setCash(int cash) {
        this.cash = cash;
    }

    private void setCard(int card) {
        this.card = card;
    }

    public void calculateSum(LocalDate finalDate) {
        LocalDate now = LocalDate.now();
        int cash = 0;
        int card = 0;

        while (now.compareTo(finalDate) < 1) {
            DayOfWeek dayOfWeek = now.getDayOfWeek();

            if (dayOfWeek.compareTo(DayOfWeek.MONDAY) == 0) {
                card += 1200;
            } else if (dayOfWeek.compareTo(DayOfWeek.WEDNESDAY) == 0 || dayOfWeek.compareTo(DayOfWeek.SATURDAY) == 0) {
                cash += 1000;
            }

            now = now.plusDays(1);
        }

        this.setCash(cash);
        this.setCard(card);
    }
}
