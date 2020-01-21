package com.chloe.rmkhelper;

import java.time.DayOfWeek;
import java.time.LocalDate;

class CostCounter {
    static int sum(LocalDate final_date){
        LocalDate now = LocalDate.now();
        int cash = 0;

        while (now.compareTo(final_date) < 1){
            DayOfWeek dayOfWeek = now.getDayOfWeek();

            if(dayOfWeek.compareTo(DayOfWeek.MONDAY) == 0){
                cash += 1200;
            }
            if(dayOfWeek.compareTo(DayOfWeek.WEDNESDAY) == 0){
                cash += 1000;
            }
            if(dayOfWeek.compareTo(DayOfWeek.SATURDAY) == 0){
                cash += 1000;
            }
            now = now.plusDays(1);
        }
        return cash;
    }
}
