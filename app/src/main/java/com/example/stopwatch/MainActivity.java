package com.example.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int second=0;
    private boolean running;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void onClickStart(View view)
    {
        running=true;
    }
    public void onClickStop(View view)
    {
        running=false;
    }
    public void onClickReset(View view)
    {
        running=false;
        second=0;
    }

    private void runTimer()
    {
        final TextView timeView=(TextView)findViewById(R.id.time_view);
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=second/3600;
                int minute=(second%3600)/60;
                int sec=second%60;
                String time = String.format("%d:%02d:%02d",hours,minute,sec);
                timeView.setText(time);
                if(running)
                {
                    ++second;
                }
                handler.postDelayed(this,1000);
            }
        });



    }



}
