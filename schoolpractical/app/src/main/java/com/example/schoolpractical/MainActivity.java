package com.example.schoolpractical;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//    instance variable- for every object created, a copy of the instance variable is made
    
    Integer x =30;
    Double Salary=10000.0;
    String myname="Alvin";
    boolean tall= true;
    char ch;
    
    
//    static variables - irrespective of the number of objects, only one copy of the class
//    variable exists for the whole class
    static int y= 76;
    static String location;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
//        create an object for the Student class
        Student studentobject = new Student();
        studentobject.name="Jane";
        studentobject.IDNo=23456;
        studentobject.gender="Female";
        
//        display the above values on the interface(make sure you use the object)

        Toast.makeText(this, "The name of the student is "+studentobject.Display(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "The sun is "+Add(9, 10), Toast.LENGTH_LONG).show();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//    add method here
    public int Add(int x,int y){
        int sum=x+y;
        return sum;
    }
}