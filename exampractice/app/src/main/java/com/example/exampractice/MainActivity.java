package com.example.exampractice;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edttxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//getting user input
        edttxt=findViewById(R.id.editexttext1);
        String name=edttxt.getText().toString();
        edttxt.setText(name);

        @Override
                protected void onResume(){
            super.onResume();
            Log.d("State","OnResume");
        }
//        button click events
        btn=findViewById(R.id.button1);
        btn.setOnClickListener(v->{
            String name=edttxt.getText().toString();
            Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();

        });

//create an intent
        Intent intent=new Intent(MainActivity.this, SecondActivity.class);
//        passing data between activities
        intent.putExtra("name", "Alvin");
        startActivity(intent);
        String name=getIntent().getStringExtra("name");

//        Toast
        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}