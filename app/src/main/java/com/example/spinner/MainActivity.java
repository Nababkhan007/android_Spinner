package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView showSpinnerValueTv;
    private List<String> flowerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        addFlower();

        setSpinner();
    }

    private void addFlower() {
        flowerList.add("~~Select favorite flower~~");
        flowerList.add("Rose");
        flowerList.add("Lotus");
        flowerList.add("Tulip");
        flowerList.add("Sunflower");
    }

    private void setSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, flowerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Toast.makeText(MainActivity.this, "" + spinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                    showSpinnerValueTv.setVisibility(View.VISIBLE);
                    showSpinnerValueTv.setText(spinner.getSelectedItem().toString());
                } else {
                    showSpinnerValueTv.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initialization() {
        spinner = findViewById(R.id.spinnerId);
        showSpinnerValueTv = findViewById(R.id.showSpinnerValueTvId);
        flowerList = new ArrayList<>();
    }
}
