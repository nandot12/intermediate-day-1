package id.co.imastudio.lanjutanapp;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTSActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    @BindView(R.id.etInputText)
    EditText etInputText;
    @BindView(R.id.btnSpeak)
    Button btnSpeak;
    //Todo 4.1 deklrasi class tts
    TextToSpeech tts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);
        ButterKnife.bind(this);

        //TODO 4.2 inisialisasi
        tts = new TextToSpeech(this, this);
    }

    @OnClick(R.id.btnSpeak)
    public void onViewClicked() {

      //TODO 4.5 convert text to audio
            tts.speak(etInputText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

    }

    @Override
    public void onInit(int status) {
        //TODO 4.3 check error tts
        if(status == TextToSpeech.SUCCESS){

            //todo 4.4 setting bahasa
            Locale bahasa = Locale.getDefault();
            tts.setLanguage(bahasa);

        }

    }
}
