package com.example.assignment1; // ← change to match your package

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment1.R;

public class MainActivity extends AppCompatActivity {

    // Prices per item
    final double PRICE_BREAD  = 65;
    final double PRICE_MILK   = 60;
    final double PRICE_PENS   = 20;
    final double PRICE_BREAD2 = 100;

    EditText etQtyBread, etTotalBread;
    EditText etQtyMilk,  etTotalMilk;
    EditText etQtyPens,  etTotalPens;
    EditText etQtyBread2, etTotalBread2;
    EditText etGrandTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link views
        etQtyBread    = findViewById(R.id.etQtyBread);
        etTotalBread  = findViewById(R.id.etTotalBread);
        etQtyMilk     = findViewById(R.id.etQtyMilk);
        etTotalMilk   = findViewById(R.id.etTotalMilk);
        etQtyPens     = findViewById(R.id.etQtyPens);
        etTotalPens   = findViewById(R.id.etTotalPens);
        etQtyBread2   = findViewById(R.id.etQtyBread2);
        etTotalBread2 = findViewById(R.id.etTotalBread2);
        etGrandTotal  = findViewById(R.id.etGrandTotal);

        // Each item button calculates its row total
        findViewById(R.id.btnBread).setOnClickListener(v ->
                etTotalBread.setText(calcRow(etQtyBread, PRICE_BREAD)));

        findViewById(R.id.btnMilk).setOnClickListener(v ->
                etTotalMilk.setText(calcRow(etQtyMilk, PRICE_MILK)));

        findViewById(R.id.btnPens).setOnClickListener(v ->
                etTotalPens.setText(calcRow(etQtyPens, PRICE_PENS)));

        findViewById(R.id.btnBread2).setOnClickListener(v ->
                etTotalBread2.setText(calcRow(etQtyBread2, PRICE_BREAD2)));

        // Total Cost button sums all rows
        findViewById(R.id.btnTotalCost).setOnClickListener(v -> {
            double grand = parseDouble(etTotalBread.getText().toString())
                    + parseDouble(etTotalMilk.getText().toString())
                    + parseDouble(etTotalPens.getText().toString())
                    + parseDouble(etTotalBread2.getText().toString());
            etGrandTotal.setText(String.format("%.2f", grand));
        });
    }

    String calcRow(EditText qtyField, double price) {
        int qty = 0;
        try { qty = Integer.parseInt(qtyField.getText().toString()); } catch (Exception ignored) {}
        return String.format("%.2f", qty * price);
    }

    double parseDouble(String s) {
        try { return Double.parseDouble(s); } catch (Exception e) { return 0; }
    }
}