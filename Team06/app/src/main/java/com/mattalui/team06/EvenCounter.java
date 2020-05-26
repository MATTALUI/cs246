package com.mattalui.team06;

import android.widget.Toast;

import java.lang.ref.WeakReference;

public class EvenCounter implements Runnable {

    WeakReference<StartThreads> context;

    public EvenCounter(StartThreads _context){
        this.context = new WeakReference<StartThreads>(_context);
    }

    public void run(){
        for(int i = 2; i <= 100; i += 2 ){
            try {
                System.out.println(i);
                Thread.sleep(250);
            }catch(Exception e){}
        }

        if(this.context != null){
            final EvenCounter _that = this;
            this.context.get().runOnUiThread(new Runnable(){
                public void run(){
                    Toast.makeText(_that.context.get(), "All done counting in evens!" , Toast.LENGTH_SHORT ).show();
                }
            });
        }

    }
}
