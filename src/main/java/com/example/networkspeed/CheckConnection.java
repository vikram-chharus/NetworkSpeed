package com.example.networkspeed;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

public class CheckConnection extends TimerTask {
    Context context;
    TextView upS, dwnS;

    public CheckConnection(Context context, TextView upS, TextView dwnS) {
        this.context = context;
        this.upS = upS;
        this.dwnS = dwnS;
    }


    @Override
    public void run() {
        if(NetworkUtils.isNetworkAvailable(context))
        {
//            System.out.println("UP"+NetworkUtils.getUpSpeed());
//            System.out.println("DWN"+NetworkUtils.getDownSpeed());
            upS.setText("UP: "+NetworkUtils.getUpSpeed());
            dwnS.setText("DWN: "+NetworkUtils.getDownSpeed());

        }
        else {
            Toast.makeText(context, "No network", Toast.LENGTH_SHORT).show();
        }
    }
}
