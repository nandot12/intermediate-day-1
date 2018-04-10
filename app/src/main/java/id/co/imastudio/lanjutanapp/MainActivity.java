package id.co.imastudio.lanjutanapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnWifi)
    Button btnWifi;
    @BindView(R.id.btnAudio)
    Button btnAudio;
    @BindView(R.id.btnBluetooth)
    Button btnBluetooth;
    @BindView(R.id.btnTTS)
    Button btnTTS;
    @BindView(R.id.btnstt)
    Button btnstt;
    @BindView(R.id.btnNotif)
    Button btnNotif;
    @BindView(R.id.btnSms)
    Button btnSms;
    @BindView(R.id.btnEmail)
    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnWifi, R.id.btnAudio, R.id.btnBluetooth, R.id.btnTTS, R.id.btnstt, R.id.btnNotif, R.id.btnSms, R.id.btnEmail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnWifi:
                startActivity(new Intent(this,WifiActivity.class));

                break;
            case R.id.btnAudio:
                startActivity(new Intent(this,AudioActivity.class));

                break;
            case R.id.btnBluetooth:
                startActivity(new Intent(this,BluetoothActivity.class));

                break;
            case R.id.btnTTS:
                startActivity(new Intent(this,TTSActivity.class));

                break;
            case R.id.btnstt:

                startActivity(new Intent(this,STTActivity.class));
                break;
            case R.id.btnNotif:

                startActivity(new Intent(this,NotifActivity.class));
                break;
            case R.id.btnSms:
                startActivity(new Intent(this,SMSActivity.class));
                break;
            case R.id.btnEmail:
                startActivity(new Intent(this,EmailActivity.class));
                break;
        }
    }
}
