package com.mattalui.autologpocclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mattalui.autologpocclient.models.AutoLog;
import com.mattalui.autologpocclient.services.AutologsServices;

import java.util.List;

public class ViewDashboard extends AppCompatActivity {
    List<AutoLog> logs;
    Button logButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dashboard);
        logButton = (Button) findViewById(R.id.logButton);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                logs = AutologsServices.getLogs();
                logButton.setEnabled(true);
            }
        });

        thread.start();
    }

    public void logLogs(View v) {
        if (logs == null) return;
        System.out.println("================================");
        for (AutoLog log : logs) log.display();
        System.out.println("================================");
    }
}
