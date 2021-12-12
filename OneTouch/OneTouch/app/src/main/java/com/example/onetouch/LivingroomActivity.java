package com.example.onetouch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class LivingroomActivity extends AppCompatActivity {
    ImageButton mlamp_on, mlamp_off, mfan_on, mfan_off;

    public static final String SHARED_PREFS = "sharedPrefs", SHARED_PREFS1 = "sharedPrefs1";
    String STATIC_LAMP = "static_lamp";
    String STATIC_FAN = "static_fan";
    public String static_lamp, static_fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livingroom);

        mlamp_on = (ImageButton) findViewById(R.id.lamp_livingroom_on);
        mlamp_off = (ImageButton) findViewById(R.id.lamp_livingroom_off);
        mfan_off = (ImageButton) findViewById(R.id.fan_off);
        mfan_on = (ImageButton) findViewById(R.id.fan_on);

        mlamp_on.setVisibility(View.INVISIBLE);//ẩn
        mlamp_off.setVisibility(View.VISIBLE);//hiển
        mfan_on.setVisibility(View.INVISIBLE);//ẩn
        mfan_off.setVisibility(View.VISIBLE);//hiển

        loadData();
        updateViews();
    }

    public void click_lamp(View view) {
        switch (view.getId()){
            case R.id.lamp_livingroom_on:
                Toast.makeText(this, "The LAMP is tuned off", Toast.LENGTH_SHORT).show();
                mlamp_on.setVisibility(View.INVISIBLE);//ẩn
                mlamp_off.setVisibility(View.VISIBLE);//hiển
                static_lamp="off";
                saveData();
                break;
            case R.id.lamp_livingroom_off:
                Toast.makeText(this, "The LAMP is tuned on", Toast.LENGTH_SHORT).show();
                mlamp_off.setVisibility(View.INVISIBLE);//ẩn
                mlamp_on.setVisibility(View.VISIBLE);//hiển
                static_lamp="on";
                saveData();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
    public void click_fan(View view) {
        switch (view.getId()){
            case R.id.fan_on:
                Toast.makeText(this, "The FAN is tuned off", Toast.LENGTH_SHORT).show();
                mfan_on.setVisibility(View.INVISIBLE);//ẩn
                mfan_off.setVisibility(View.VISIBLE);//hiển
                static_fan="off";
                saveData();
                break;
            case R.id.fan_off:
                Toast.makeText(this, "The FAN is tuned on", Toast.LENGTH_SHORT).show();
                mfan_off.setVisibility(View.INVISIBLE);//ẩn
                mfan_on.setVisibility(View.VISIBLE);//hiển
                static_fan="on";
                saveData();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STATIC_LAMP, static_lamp);
        editor.apply();

        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS1, MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString(STATIC_FAN, static_fan);
        editor1.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        static_lamp = sharedPreferences.getString(STATIC_LAMP, "");
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS1, MODE_PRIVATE);
        static_fan = sharedPreferences1.getString(STATIC_FAN, "");
    }

    public void updateViews() {
        if(static_lamp.equals("off")){
            mlamp_on.setVisibility(View.INVISIBLE);//ẩn
            mlamp_off.setVisibility(View.VISIBLE);//hiển
        }else if(static_lamp.equals("on")){
            mlamp_off.setVisibility(View.INVISIBLE);//ẩn
            mlamp_on.setVisibility(View.VISIBLE);//hiển
        }
        if(static_fan.equals("off")){
            mfan_on.setVisibility(View.INVISIBLE);//ẩn
            mfan_off.setVisibility(View.VISIBLE);//hiển
        }else if(static_fan.equals("on")){
            mfan_off.setVisibility(View.INVISIBLE);//ẩn
            mfan_on.setVisibility(View.VISIBLE);//hiển
        }
    }
    //code tạo menu
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
                Intent intent = new Intent(LivingroomActivity.this, LivingroomActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.menu_bedroom:
                //Toast.makeText(this, "Turned to the Bedroom", Toast.LENGTH_SHORT).show();
                Intent intent_bedroom = new Intent(LivingroomActivity.this, BedroomActivity.class);
                startActivity(intent_bedroom);
                finish();
                break;
            case R.id.menu_kitchen:
               // Toast.makeText(this, "Turned to the Kitchen", Toast.LENGTH_SHORT).show();
                Intent intent_kitchen = new Intent(LivingroomActivity.this, KitchenActivity.class);
                startActivity(intent_kitchen);
                finish();
                break;
            case R.id.menu_logout:
                //Toast.makeText(this, "Turned to the Logout", Toast.LENGTH_SHORT).show();
                static_fan="on";
                static_lamp="on";
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
