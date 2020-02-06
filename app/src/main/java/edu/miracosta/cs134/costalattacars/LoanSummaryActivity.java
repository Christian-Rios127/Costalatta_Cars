package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.costalattacars.model.CarLoan;

public class LoanSummaryActivity extends AppCompatActivity {

    private CarLoan carLoan;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    private TextView carStickerpriceTextView;
    private TextView taxAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // Extract the data from the intent
        double carPrice, downPayment;
        int loanTerm;
        Intent intent = getIntent();
        carPrice = intent.getDoubleExtra("CarPrice",0.0);
        downPayment = intent.getDoubleExtra("DownPayment",0.0);
        loanTerm = intent.getIntExtra("LoanTerm",5);

        //Let's send the data to (CarLoan) calculate the stuff for you
        carLoan = new CarLoan();
        carLoan.setPrice(carPrice);
        carLoan.setDownPayment(downPayment);
        carLoan.setLoanTerm(loanTerm);
        //populate the text views with the data from the carLoan model



    }
    public void returnToMain(View V){
        //Done with LoanSummaryActivity, so "Finish" it
        finish();
    }
}
