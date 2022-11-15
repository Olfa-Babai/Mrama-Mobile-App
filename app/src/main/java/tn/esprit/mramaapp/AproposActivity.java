package tn.esprit.mramaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class AproposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
        final MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.song);
        mediaPlayer.start();
    }

}