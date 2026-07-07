package com.example.textpractical;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTextPersonName, editTextTextPersonName2;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextTextPersonName=findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2=findViewById(R.id.editTextTextPersonName2);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                        SendSMS();;
                    }else{
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }

                }

            }
        });



    }

    private void SendSMS(){
        String number=editTextTextPersonName.getText().toString().trim();
        String message=editTextTextPersonName2.getText().toString().trim();

        try{
            //call manager
            SmsManager smsManager=SmsManager.getDefault();

            //send the message
            smsManager.sendTextMessage(number,null,message,null,null);
            Toast.makeText(this,"Message is sent",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Message is Not Sent", Toast.LENGTH_SHORT).show();
        }
    }
}
