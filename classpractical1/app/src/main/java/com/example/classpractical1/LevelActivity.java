package com.example.classpractical1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LevelActivity extends AppCompatActivity {
    ListView levellistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_level);

        levellistview = findViewById(R.id.levellistView);

        //Receive Course name from Main Activity
        String courseName = getIntent().getStringExtra("courseName");
        setTitle(courseName);//shows "Database Systems" as screeen title

        String[] levels = new String[]{
                "Beginner",
                "Intermedeiate",
                "Pro"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                levels
        );
        levellistview.setAdapter(adapter);
        levellistview.setOnItemClickListener((parent, view, position, id) -> {
            String selectedLevel = levels[position];
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtra("courseName", courseName);//forward course name
            intent.putExtra("level", selectedLevel);//send level chosen
            startActivity(intent);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}