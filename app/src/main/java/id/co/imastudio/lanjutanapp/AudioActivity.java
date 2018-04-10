package id.co.imastudio.lanjutanapp;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class
AudioActivity extends AppCompatActivity {

    @BindView(R.id.btnRing)
    Button btnRing;
    @BindView(R.id.btnMute)
    Button btnMute;
    @BindView(R.id.btnVibrate)
    Button btnVibrate;
    @BindView(R.id.btnSilent)
    Button btnSilent;
    @BindView(R.id.btnMode)
    Button btnMode;
    //TODO 7
    AudioManager audioManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        ButterKnife.bind(this);

        //TODO 8
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
    }

    @OnClick({R.id.btnRing, R.id.btnMute, R.id.btnVibrate, R.id.btnSilent, R.id.btnMode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnRing:

                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                break;
            case R.id.btnMute:
                audioManager.setRingerMode(AudioManager.ADJUST_MUTE);
                break;
            case R.id.btnVibrate:
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                break;
            case R.id.btnSilent:
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                break;
            case R.id.btnMode:

            int status =  audioManager.getRingerMode() ;

           switch (status){

               case 0 :
                   Toast.makeText(this, "silent", Toast.LENGTH_SHORT).show();
                   break;
               case  1 :
                   Toast.makeText(this, "vibrate", Toast.LENGTH_SHORT).show();
                   break;
                    case  2 :
                   Toast.makeText(this, "ring", Toast.LENGTH_SHORT).show();

                   break;
                   case  -100 :
                   Toast.makeText(this, "mute", Toast.LENGTH_SHORT).show();

                   break;

                   default:
                       break;
           }

        }
    }
}
