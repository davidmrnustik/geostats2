package com.geo.geostats;

import android.content.Intent;
import android.os.Bundle;

import com.ubikod.capptain.android.sdk.activity.CapptainActivity;


public class Intro extends CapptainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        Thread logo = new Thread(){
            public void run(){
                try{

                    int time = 0;

                    while(time<3500){
                        sleep(100);
                        time = time + 100;
                    }

                    Intent i = new Intent("com.geo.geostats.MAIN");
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    finish();
                }
            }
        };

        logo.start();
    }
}
