package com.mattalui.team06;

import android.widget.Toast;

import java.lang.ref.WeakReference;

public class OddCounter implements Runnable {
    WeakReference<StartThreads> context;

    public OddCounter(StartThreads _context){
        this.context =  new WeakReference<StartThreads>(_context);
    }

    public void run(){
        for(int i = 1; i < 100; i += 2 ){
            try {
                System.out.println(i);
                Thread.sleep(250);
            }catch(Exception e){}
        }

        if(this.context != null){
            final OddCounter _that = this;
            this.context.get().runOnUiThread(new Runnable(){
                public void run(){
                    Toast.makeText(_that.context.get(), "All done counting in odds!" , Toast.LENGTH_SHORT ).show();
                }
            });
        }
    }
}
