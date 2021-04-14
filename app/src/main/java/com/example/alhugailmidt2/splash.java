package com.example.alhugailmidt2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

public class splash extends Activity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            TimerTask task=new TimerTask() {
                @Override
                public void run() {
                    // do something here
                    finish();
                    startActivity(new Intent(splash.this,MainActivity.class));
                    new CountDownTimer( 50000, 1000 ) {
                        public void onTick(long millisUntilFinished) {
                            // Used for formatting digit to be in 2 digits only
                            NumberFormat f = new DecimalFormat( "00" );
                            long hour = (millisUntilFinished / 3600000) % 24;
                            long min = (millisUntilFinished / 60000) % 60;
                            long sec = (millisUntilFinished / 1000) % 60;
                            textView.setText ( f.format ( hour ) + ":" + f.format ( min ) + ":" + f.format ( sec ) );
                        }

                        // When the task is over it will print 00:00:00 there
                        public void onFinish() {
                            textView.setText ( "00:00:00" );
                        }
                    }.start ();

                }
            };
            Timer opening=new Timer();
            opening.schedule(task,6000);
        }
    }
}