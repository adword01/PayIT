package com.example.payit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.payit.R;
import com.google.android.material.textfield.TextInputEditText;

public class SplitBillActivity extends AppCompatActivity {
    private TextInputEditText amountEdt, peopleEdt, tipEdt;
    private TextView amtTV;
    private Button resetBtn, amtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_bill);

        // initializing variables with ids.
        amountEdt = findViewById(R.id.idEdtAMount);
        peopleEdt = findViewById(R.id.idEdtPeople);
        tipEdt = findViewById(R.id.idEdtTip);
        amtBtn = findViewById(R.id.idBtnGetAmount);
        resetBtn = findViewById(R.id.idBtnReset);
        amtTV = findViewById(R.id.idTVIndividualAmount);

        // adding click listener for amount button.
        amtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if edit text is not empty
                if (amountEdt.getText().toString() != null && peopleEdt.getText().toString() != null && tipEdt.getText().toString() != null) {
                    // adding number from amount and tip
                    // and dividing it by number of people.
                    Integer individualAmt =
                            (Integer.parseInt(amountEdt.getText().toString()) + Integer.parseInt(tipEdt.getText().toString())) / Integer.parseInt(
                                    peopleEdt.getText().toString()
                            );
                    amtTV.setVisibility(View.VISIBLE);
                    // setting amount to text view.
                    amtTV.setText("Individual Amount : \n\n" + individualAmt.toString());
                }
            }
        });

        // adding click listener for reset button.
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setting empty text for edit text.
                amountEdt.setText("");
                peopleEdt.setText("");
                tipEdt.setText("");
                amtTV.setText("");
            }
        });
    }
}
