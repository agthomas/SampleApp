package com.example.thomas.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout rootLayout = findViewById(R.id.root_layout);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ConstraintLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));

        TextView dynamicTextView = new TextView(this);
        dynamicTextView.setLayoutParams(new ConstraintLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        dynamicTextView.setTextSize(20);
        dynamicTextView.setPadding(16,0,0,0);
        String[] song = SampleSong.getSong();
        for ( String line: song) {
            dynamicTextView.append(line+"\n");
        }
        scrollView.addView(dynamicTextView);
        rootLayout.addView(scrollView);

        BottomNavigationView navigation = findViewById(R.id.botNav);

        //Add MenuItem with icon to Menu
        navigation.getMenu().add(Menu.NONE, 1, Menu.NONE, "Music").setIcon(R.drawable.ic_music_video);
        navigation.getMenu().add(Menu.NONE, 2, Menu.NONE, "Video").setIcon(R.drawable.ic_videocam);
        navigation.getMenu().add(Menu.NONE, 3, Menu.NONE, "Note").setIcon(R.drawable.ic_music_note);
        navigation.getMenu().add(Menu.NONE, 4, Menu.NONE, "Settings").setIcon(R.drawable.ic_settings);
        //navigation.getMenu().add(Menu.NONE, 5, Menu.NONE, "Home").setIcon(R.drawable.ic_home_black_24dp);

    }
}
