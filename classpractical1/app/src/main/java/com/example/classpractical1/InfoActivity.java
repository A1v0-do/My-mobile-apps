package com.example.classpractical1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfoActivity extends AppCompatActivity {
    TextView titleText;
    TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_infoactivity);

        titleText = findViewById(R.id.titleText);
        infoText = findViewById(R.id.infoText);

        //Receive both course name and level
        String courseName = getIntent().getStringExtra("courseName");
        String level = getIntent().getStringExtra("level");

        //Show title like "Database System-Beginner"
        titleText.setText(courseName + "-" + level);

        //Decide what information to show
        String information =getInfo (courseName, level);
        infoText.setText(information);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //This method return the right information based on course +level
    private String getInfo(String courseName, String level){
        if (courseName.equals("Database Systems")){
            if (level.equals("Beginner")){
                return"Welcome Beginner!\n\n" +
                        "You will learn:\n" +
                        "• What a database is\n" +
                        "• Basic SQL commands\n" +
                        "• Creating simple tables\n" +
                        "• INSERT, SELECT, DELETE";
            }else if (level.equals("Intermediate")){
                return "Welcome Intermediate!\n\n"+
                        "You will learn:\n"+
                        ".Joins and Relationship\n"+
                        ".Normalization\n"+
                        ".Indexes and views\n"+
                        ".Stored Procedures";
            }else if (level.equals("Pro")){
                return "Welcome Pro!\n\n"+
                        "You will learn:\n"+
                        ".Query optimization\n"+
                        ".Database clustering\n"+
                        "Transactions and locks\n"+
                        ".Advanced security";
            }
        }
        return "Information coming soon!";
    }
}