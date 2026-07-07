package com.example.methodspractical;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


    static int y=76;
    static String location;

    static int Add(int a, int b){
        return a+b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        create an o
        student studentobject=new student();

        studentobject.name="James";
        studentobject.IDno=2435;
        studentobject.gender="Female";

        //display the above values on the interface (make sure you use the object)

        Toast.makeText(this,"The name of the student is "+studentobject.Display(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,"The sum is "+Add(9,10),Toast.LENGTH_LONG).show();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}