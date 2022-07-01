package com.matrix_maeny.xylophone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AppCompatButton tune1,tune2,tune3,tune4,tune5,tune6,tune7;

    private final int SIM_SOUND = 7;
    private final float LEFT_VOL = 0.1f;

    private final float RIGHT_VOL = 1.0f;
    private final int LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    private SoundPool soundPool;

    private int sound1,sound2,sound3,sound4,sound5,sound6,sound7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        tune1 = findViewById(R.id.tune1);
        tune2 = findViewById(R.id.tune2);
        tune3 = findViewById(R.id.tune3);
        tune4 = findViewById(R.id.tune4);
        tune5 = findViewById(R.id.tune5);
        tune6 = findViewById(R.id.tune6);
        tune7 = findViewById(R.id.tune7);

        soundPool = new SoundPool(SIM_SOUND, AudioManager.STREAM_MUSIC,0);

        sound1 = soundPool.load(getApplicationContext(),R.raw.note1_c,1);
        sound2 = soundPool.load(getApplicationContext(),R.raw.note2_d,1);
        sound3 = soundPool.load(getApplicationContext(),R.raw.note3_e,1);
        sound4 = soundPool.load(getApplicationContext(),R.raw.note4_f,1);
        sound5 = soundPool.load(getApplicationContext(),R.raw.note5_g,1);
        sound6 = soundPool.load(getApplicationContext(),R.raw.note6_a,1);
        sound7 = soundPool.load(getApplicationContext(),R.raw.note7_b,1);


        tune1.setOnClickListener(sound1Listener);
        tune2.setOnClickListener(sound2Listener);
        tune3.setOnClickListener(sound3Listener);
        tune4.setOnClickListener(sound4Listener);
        tune5.setOnClickListener(sound5Listener);
        tune6.setOnClickListener(sound6Listener);
        tune7.setOnClickListener(sound7Listener);
    }

    View.OnClickListener sound1Listener = v-> soundPool.play(sound1,LEFT_VOL,RIGHT_VOL,PRIORITY,LOOP,NORMAL_PLAY_RATE);
    View.OnClickListener sound2Listener = v-> soundPool.play(sound2,LEFT_VOL,RIGHT_VOL,PRIORITY,LOOP,NORMAL_PLAY_RATE);
    View.OnClickListener sound3Listener = v-> soundPool.play(sound3,LEFT_VOL,RIGHT_VOL,PRIORITY,LOOP,NORMAL_PLAY_RATE);
    View.OnClickListener sound4Listener = v-> soundPool.play(sound4,LEFT_VOL,RIGHT_VOL,PRIORITY,LOOP,NORMAL_PLAY_RATE);
    View.OnClickListener sound5Listener = v-> soundPool.play(sound5,LEFT_VOL,RIGHT_VOL,PRIORITY,LOOP,NORMAL_PLAY_RATE);
    View.OnClickListener sound6Listener = v-> soundPool.play(sound6,LEFT_VOL,RIGHT_VOL,PRIORITY,LOOP,NORMAL_PLAY_RATE);
    View.OnClickListener sound7Listener = v-> soundPool.play(sound7,LEFT_VOL,RIGHT_VOL,PRIORITY,LOOP,NORMAL_PLAY_RATE);


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        startActivity(new Intent(MainActivity.this,AboutActivity.class));
        return super.onOptionsItemSelected(item);
    }
}