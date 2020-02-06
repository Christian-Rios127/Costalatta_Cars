package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //Declare a couple instance variables connect controller to the view
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wire up the views
        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);

    }

    public void generateReport(View V){
        //when switching views it will save the user data into it
        double carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        double downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        // Let's make a decision to see which RadioButton is selected
        int loanTerm;
        switch (loanTermRadioGroup.getCheckedRadioButtonId()){
            case R.id.threeYearsRadioButton:
                loanTerm = 3;
            case R.id.fourYearsRadioButton:
                loanTerm = 4;
            default:
                loanTerm = 5;
        }
        //instantiate the Intent and navigate to LoanSummaryActivity
        Intent intent = new Intent(this,LoanSummaryActivity.class);
        intent.putExtra("CarPrice",carPrice);
        intent.putExtra("DownPayment",downPayment);
        intent.putExtra("LoanTerm",loanTerm);
        //Fire off the intent
        startActivity(intent);
    }
}
