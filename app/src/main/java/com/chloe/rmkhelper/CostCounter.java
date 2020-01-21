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

    int getCash(){
        return this.cash;
    }

    int getCard(){
        return this.card;
    }

    private void setCash(int cash){
        this.cash = cash;
    }

    private void setCard(int card){
        this.card = card;
    }

    static CostCounter sum(CostCounter costCounter, LocalDate final_date){
        LocalDate now = LocalDate.now();
        int cash = 0;
        int card = 0;

        while (now.compareTo(final_date) < 1){
            DayOfWeek dayOfWeek = now.getDayOfWeek();

            if(dayOfWeek.compareTo(DayOfWeek.MONDAY) == 0){
                card += 1200;
            }
            if(dayOfWeek.compareTo(DayOfWeek.WEDNESDAY) == 0){
                cash += 1000;
            }
            if(dayOfWeek.compareTo(DayOfWeek.SATURDAY) == 0){
                cash += 1000;
            }
            now = now.plusDays(1);
        }

        costCounter.setCash(cash);
        costCounter.setCard(card);

        return costCounter;
    }
}
