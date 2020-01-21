package com.chloe.rmkhelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import static com.chloe.rmkhelper.CostCounter.sum;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public CostCounter checkRadioButton(){
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        int cash = 0;
        int card = 0;
        CostCounter cc = new CostCounter(cash,card);

        if(id == -1){
            Toast toast = Toast.makeText(getApplicationContext(), R.string.choose_one, Toast.LENGTH_SHORT);
            toast.show();
        }else{
            switch (id){
                case R.id.until_fifth_day:
                    LocalDate final_date = LocalDate.now();
                    final_date = final_date.plusMonths(1);
                    final_date = LocalDate.of(final_date.getYear(), final_date.getMonth(),5);
                    cc = sum(cc, final_date);
                    break;
                case R.id.until_last_day:
                    cc = sum(cc, LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
                    break;
            }
        }
        return cc;
    }

    public void onClickButton(View view){
        CostCounter cc = checkRadioButton();
        TextView cash = findViewById(R.id.pay_by_cash);
        TextView card = findViewById(R.id.pay_by_card);

        cash.setText(String.valueOf(cc.getCash()));
        card.setText(String.valueOf(cc.getCard()));
    }
}
