package com.vijayjaidewan01vivekrai.telephoneservice_github;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button dial;
    Button call;
    TelephonyManager telephonyManager;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dial = findViewById(R.id.dial);
        call = findViewById(R.id.call);
        textView = findViewById(R.id.textView);
        telephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        textView.setText(telephonyManager.getNetworkOperatorName());



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9999999999"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 20);
                    return;
                }
                startActivity(intent);
            }
        });

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8076283795"));
                startActivity(intent);
            }
        });

    }
}
