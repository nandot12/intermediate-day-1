package id.co.imastudio.lanjutanapp;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SMSActivity extends AppCompatActivity {

    @BindView(R.id.smsPhone)
    EditText smsPhone;
    @BindView(R.id.smsText)
    EditText smsText;
    @BindView(R.id.btnsms)
    Button btnsms;
    @BindView(R.id.btnIntent)
    Button btnIntent;

    //TODO 7.1  Deklrasi sms
    SmsManager sms ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);

        //TODO 7.2
        sms = SmsManager.getDefault();
    }

    @OnClick({R.id.btnsms, R.id.btnIntent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnsms:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},12);
                }


                break;
            case R.id.btnIntent:

                //todo 7.3 intent sms ke aplikasi sms
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //TODO 7.4 untuk ambil nomor destinations sms
                intent.setData(Uri.parse("smsto :" + smsPhone.getText().toString()));

               // intent.putExtra("address",)
                //TODO 7.5 untuk text message
                intent.putExtra("sms_body",smsText.getText().toString());
                //TODO 7.6 biar ngarhin k aplkasi sms di android
                intent.setType("vnd.android-dir/mms-sms");
                //TODO 7.7 eksekusi dari intent
                startActivity(intent);

                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == 12){
            //TODO 3
            sms.sendTextMessage(smsPhone.getText().toString(),null,smsText.getText().toString(),
                    null,null);
        }
    }
}
