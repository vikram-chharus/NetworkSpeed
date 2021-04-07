package com.example.networkspeed;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public class NetworkUtils  {
    static int upSpeed, downSpeed;

    public static void setUpSpeed(int upSpeed) {
        NetworkUtils.upSpeed = upSpeed;
    }

    public static int getDownSpeed() {
        return downSpeed;
    }

    public static int getUpSpeed() {
        return upSpeed;
    }

    public static void setDownSpeed(int downSpeed) {
        NetworkUtils.downSpeed = downSpeed;
    }

    public  static  boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        try{
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            NetworkUtils.setDownSpeed(networkCapabilities.getLinkDownstreamBandwidthKbps()/1000);
            NetworkUtils.setUpSpeed(networkCapabilities.getLinkUpstreamBandwidthKbps()/1000);
        }
        catch (Exception e)
        {

        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    
}
