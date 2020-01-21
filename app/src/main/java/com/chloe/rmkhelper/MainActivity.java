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
    private int cash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void checkRadioButton(View view){
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();

        if(id == -1){
            Toast toast = Toast.makeText(getApplicationContext(), R.string.choose_one, Toast.LENGTH_SHORT);
            toast.show();
        }else{
            switch (id){
                case R.id.until_fifth_day:
                    LocalDate final_date = LocalDate.now();
                    final_date = final_date.plusMonths(1);
                    final_date = LocalDate.of(final_date.getYear(), final_date.getMonth(),5);
                    cash = CostCounter.sum(final_date);
                    break;
                case R.id.until_last_day:
                    cash = CostCounter.sum(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
                    break;
            }
        }
    }

    public void onClickButton(View view){
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        checkRadioButton(radioGroup);
        TextView textView = findViewById(R.id.cost);
        textView.setText(String.valueOf(cash));
    }
}
