package com.example.classpractical2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listview =findViewById(R.id.listview);


        String [] menu=new String[] {"Send Money", "Withdraw Cash", "Buy Airtime","Lipa na Mpesa","Loans and Savings","My Account"};


       //create an adapter
        ArrayAdapter<String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,menu);

        //display the data on the listview
        listview.setAdapter(adapter);

        listview.setOnItemClickListener((parent, view, position, id)->{
            if (position==0){
                startActivity(new Intent(MainActivity.this, SendMoney.class));

            }
        }

    );



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}