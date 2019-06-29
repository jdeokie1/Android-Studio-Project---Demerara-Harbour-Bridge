//Created by Eric Deokie
package com.example.eric.demeraraharbourbridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Transportation extends AppCompatActivity {

    int numberofferrytickets;
    double subtotal;
    double totalcost;
    double peakcost = 2;
    double nonpeakcost = 1;
    double ticketcost = 23.00;
    double TAXES = 0.05;
    double costoftickets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText numberofticketsselected = (EditText) findViewById(R.id.ferryprompt);
        final RadioButton peakcostselected = (RadioButton) findViewById(R.id.peaktravel);
        final RadioButton nonpeakcostselected = (RadioButton) findViewById(R.id.nonpeaktravel);

        Button cost = (Button) findViewById(R.id.btnferrycost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView) findViewById(R.id.results);

            @Override
            public void onClick(View view) {

                String amountofticketsneeded;
                amountofticketsneeded = numberofticketsselected.getText().toString();
                if (amountofticketsneeded.equals("")) amountofticketsneeded = "0";

                numberofferrytickets = Integer.parseInt(amountofticketsneeded);

                if (peakcostselected.isChecked()) {

                    Toast.makeText(Transportation.this, "Travel off peak to save money!", Toast.LENGTH_LONG).show();
                    costoftickets = ticketcost * numberofferrytickets * peakcost;
                }

                if (nonpeakcostselected.isChecked()) {

                    costoftickets = ticketcost * numberofferrytickets * nonpeakcost;

                }
                subtotal = (costoftickets * TAXES);
                totalcost = subtotal + (costoftickets);

                DecimalFormat currency = new DecimalFormat("###,##0.00");
                result.setText("The total cost for " + numberofferrytickets + " Ferry Ticket(s) is $" + currency.format(totalcost) + ".");
            }

        });
    }
}
