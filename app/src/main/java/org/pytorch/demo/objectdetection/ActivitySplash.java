package org.pytorch.demo.objectdetection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

public class ActivitySplash extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            splashPlayer();
        } catch (Exception ex) {
            jumpMain();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    public void splashPlayer() {
        VideoView videoHolder = new VideoView(this);
        setContentView(videoHolder);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.sample_training_video3);
        videoHolder.setVideoURI(video);
        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                jumpMain();
            }

        });
        videoHolder.start();
        /*videoHolder.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((VideoView) v).stopPlayback();
                jumpMain();
                return true;
            }
        });*/
    }

    private synchronized void jumpMain() {
        Intent intent = new Intent(ActivitySplash.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
