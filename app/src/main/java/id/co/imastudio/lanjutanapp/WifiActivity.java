package id.co.imastudio.lanjutanapp;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WifiActivity extends AppCompatActivity {

    @BindView(R.id.switchWifi)
    Switch switchWifi;

    //TODO 3
    WifiManager wifiManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        ButterKnife.bind(this);

        //TODO 4 INISIALISASI
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        switchWifi.setChecked(wifiManager.isWifiEnabled());

        //TODO 1 action listener dari switch
        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                //TODO 2 untuk check switch itu apa on/off
                if(b == true) {

                    setwifi(b);
//
//                    //TODO 5 check wifi udah aktif apa belum
//                    if (wifiManager.isWifiEnabled()) {
//                        Toast.makeText(WifiActivity.this, "udah aktif kok", Toast.LENGTH_SHORT).show();
//                    } else {
//
//                        //TODO 6  set aktif wifi
//                        wifiManager.setWifiEnabled(true);
//                    }
                }
                else {
                    setwifi(b);

//                    //TODO 5 check wifi udah aktif apa belum
//                    if (wifiManager.isWifiEnabled()) {
//                        wifiManager.setWifiEnabled(false);
//
//                    } else {
//
//                        //TODO 6  set aktif wifi
//                        Toast.makeText(WifiActivity.this, "udah tidak aktif kok", Toast.LENGTH_SHORT).show();
//                    }

                }

            }
        });
    }

    private void setwifi(boolean b) {

        if ( wifiManager.isWifiEnabled() && b == true){
            Toast.makeText(WifiActivity.this, "udah  aktif kok", Toast.LENGTH_SHORT).show();

        }

        else{
            wifiManager.setWifiEnabled(true);
        }
    }
}
