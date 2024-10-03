package com.example.menuprieto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the fragment is already added to avoid adding it multiple times
        if (savedInstanceState == null) {
            MyFirstFragment firstFragment = new MyFirstFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment)
                    .commit();
        }

        // Set title and subtitle for the Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My App Title");
            getSupportActionBar().setSubtitle("My App Subtitle");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d("MainActivity", "Menu created");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        // Handle menu item clicks here...
        return super.onOptionsItemSelected(item);
    }
}
