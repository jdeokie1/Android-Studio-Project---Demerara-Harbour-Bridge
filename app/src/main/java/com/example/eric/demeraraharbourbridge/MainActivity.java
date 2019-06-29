//Created by Eric Deokie
package com.example.eric.demeraraharbourbridge;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] attraction={"Description", "Web Information","Admissions", "Transportation", "Audio"};
        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.activity_main, R.id.details, attraction));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {

        switch (position) {

            case 0:
                startActivity(new Intent(MainActivity.this, Description.class));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://harbourbridge.gov.gy/" )));
                break;

            case 2:
                startActivity(new Intent(MainActivity.this, Admission.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, Transportation.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, Audio.class));
                break;
        }
    }
}

