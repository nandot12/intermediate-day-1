package id.co.imastudio.lanjutanapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmailActivity extends AppCompatActivity {

    @BindView(R.id.textEmail)
    EditText textEmail;
    @BindView(R.id.textSubject)
    EditText textSubject;
    @BindView(R.id.textCc)
    EditText textCc;
    @BindView(R.id.textMessage)
    EditText textMessage;
    @BindView(R.id.btnSend)
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSend)
    public void onViewClicked() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        //TODO 8.1 menentukan type data yang kirim sesuai dengan type mime

        //intent.setData(Uri.parse("emailto:"));

        intent.setType("text/plain");
        //TODO  8.2 MENENTUKAN EMAIL TUJUAN
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{textEmail.getText().toString()});
        //todo 8.3 MENENTUKAN CC EMAIL
        intent.putExtra(Intent.EXTRA_CC,new String[]{textCc.getText().toString()});
        intent.putExtra(Intent.EXTRA_TEXT,textMessage.getText().toString());

        intent.putExtra(Intent.EXTRA_SUBJECT,textSubject.getText().toString());

        //TODO 8.4
        startActivity(Intent.createChooser(intent,"silahkan pilih"));


    }
}
