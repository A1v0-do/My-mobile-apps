package com.example.classpractical2;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

public class SendMoney extends AppCompatActivity {
    EditText phoneInput;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_money);

        phoneInput= findViewById(R.id.phoneInput);
        nextButton=findViewById(R.id.nextButton);

        phoneInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        nextButton.setOnClickListener(v ->{
            String phone=phoneInput.getText().toString();

            if (phone.isEmpty()) {
                Toast.makeText(this, "Please enter a Phone Number", Toast.LENGTH_SHORT).show();
            }else if (phone.length()<10){
                    Toast.makeText(this, "Phone Number must be 10 digits", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Proceeding with: " +phone, Toast.LENGTH_SHORT).show();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}