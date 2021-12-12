package com.example.onetouch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_livingroom:
                //Toast.makeText(this, "Turned to the Livingroom", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, LivingroomActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.menu_bedroom:
                //Toast.makeText(this, "Turned to the Bedroom", Toast.LENGTH_SHORT).show();
                Intent intent_bedroom = new Intent(MainActivity.this, BedroomActivity.class);
                startActivity(intent_bedroom);
                finish();
                break;
            case R.id.menu_kitchen:
                //Toast.makeText(this, "Turned to the Kitchen", Toast.LENGTH_SHORT).show();
                Intent intent_kitchen = new Intent(MainActivity.this, KitchenActivity.class);
                startActivity(intent_kitchen);
                finish();
                break;
            case R.id.menu_logout:
                //Toast.makeText(this, "Turned to the Logout", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
