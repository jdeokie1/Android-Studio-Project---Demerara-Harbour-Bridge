//Created by Eric Deokie
package com.example.eric.demeraraharbourbridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Admission extends AppCompatActivity {

    int numberoftickets;
    double subtotal;
    double totalcost;
    double seniors=20.0;
    double veterans=15.0;
    double minors=10.0;
    double regularadults=25.0;
    double costperticket;
    double TAXES=0.05;
    double membershipdisc=0.20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText numberofticketsselected= (EditText)findViewById(R.id.tickets);
        final Spinner groupselection=(Spinner)findViewById(R.id.admissionchoices);
        final CheckBox membership = (CheckBox)findViewById(R.id.membership);

        Button cost=(Button)findViewById(R.id.btncost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView) findViewById(R.id.result);

            @Override
            public void onClick(View view) {

                String amountofticketsneeded;
                amountofticketsneeded= numberofticketsselected.getText().toString();
                if(amountofticketsneeded.equals("")) amountofticketsneeded = "0";

                numberoftickets = Integer.parseInt(amountofticketsneeded);


                long groupchoice = groupselection.getSelectedItemPosition();

                if (groupchoice == 0) {

                    if(membership.isChecked()) {
                        Toast.makeText(Admission.this, "Thank you for being a valued customer!", Toast.LENGTH_LONG).show();
                        costperticket = seniors - (seniors*membershipdisc);
                    }

                    else {
                        costperticket=seniors;
                    }
                } else if (groupchoice == 1) {


                    if(membership.isChecked()) {
                        Toast.makeText(Admission.this, "Thank you for being a valued customer!", Toast.LENGTH_LONG).show();
                        costperticket = veterans - (veterans*membershipdisc);

                    }

                    else {
                        costperticket = veterans;
                    }

                } else if (groupchoice == 2) {

                    if (membership.isChecked()) {
                        Toast.makeText(Admission.this, "Thank you for being a valued customer!", Toast.LENGTH_LONG).show();
                        costperticket= minors - (minors*membershipdisc);
                    }

                    else {
                        costperticket = minors;
                    }

                } else if (groupchoice == 3) {

                    if (membership.isChecked()) {
                        Toast.makeText(Admission.this, "Thank you for being a valued customer!", Toast.LENGTH_LONG).show();
                        costperticket= regularadults - (regularadults*membershipdisc);
                    }

                    else {
                        costperticket = regularadults;
                    }
                }

                subtotal= (costperticket * numberoftickets * TAXES);
                totalcost = subtotal + (costperticket*numberoftickets);

                DecimalFormat currency = new DecimalFormat("###,##0.00");
                result.setText("The total cost for " + numberoftickets +" tickets is $" + currency.format(totalcost) + ".");
            }
        });
    }
}


