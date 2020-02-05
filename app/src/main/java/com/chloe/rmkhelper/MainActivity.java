package com.chloe.rmkhelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(CostCounter costCounter) {
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == -1) {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.choose_one, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            LocalDate finalDate = LocalDate.now();
            switch (id) {
                case R.id.until_fifth_day:
                    int nextMonth = finalDate.getMonthValue() + 1;
                    finalDate = LocalDate.of(finalDate.getYear(), nextMonth, 5);
                    costCounter.calculateSum(finalDate);
                    break;
                case R.id.until_fifth_day_of_this:
                    finalDate = LocalDate.of(finalDate.getYear(), finalDate.getMonth(), 5);
                    costCounter.calculateSum(finalDate);
                    break;
                case R.id.until_last_day:
                    costCounter.calculateSum(finalDate.with(TemporalAdjusters.lastDayOfMonth()));
                    break;
            }
        }
    }

    public void onClickButton(View view) {
        CostCounter costCounter = new CostCounter(0, 0);
        onRadioButtonClicked(costCounter);

        TextView cash = findViewById(R.id.pay_by_cash);
        TextView card = findViewById(R.id.pay_by_card);

        cash.setText(String.valueOf(costCounter.getCash()));
        card.setText(String.valueOf(costCounter.getCard()));
    }
}
