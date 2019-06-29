//Created by Eric Deokie
package com.example.eric.demeraraharbourbridge;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Audio extends AppCompatActivity {

    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final MediaPlayer calypsoMediaPlayer = MediaPlayer.create(this, R.raw.mpcalypso);
        final MediaPlayer anthemMediaPlayer = MediaPlayer.create(this, R.raw.mpanthem);


        final Button button1 = (Button) this.findViewById(R.id.playaudio);
        final Button button2 = (Button) this.findViewById(R.id.playaudio2);

        calypsoMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(Audio.this, Audio.class));
            }
        });

        anthemMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                startActivity(new Intent(Audio.this, Audio.class));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (playing) {
                    case 0:
                    calypsoMediaPlayer.start();
                    playing=1;
                    button1.setText("Pause Calypso Audio");
                    button2.setVisibility(View.INVISIBLE);
                    break;

                    case 1:
                        calypsoMediaPlayer.pause();
                        playing=0;
                        button1.setText("Play Calypso Audio");
                        button2.setVisibility(View.VISIBLE);
                        break;
                }

            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (playing) {
                    case 0:
                        anthemMediaPlayer.start();
                        playing=1;
                        button2.setText("Pause National Anthem");
                        button1.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        anthemMediaPlayer.pause();
                        playing=0;
                        button2.setText("Play National Anthem");
                        button1.setVisibility(View.VISIBLE);
                        break;
                }

            }
        });
    }
}