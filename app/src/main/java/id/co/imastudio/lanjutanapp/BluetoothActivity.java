package id.co.imastudio.lanjutanapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BluetoothActivity extends AppCompatActivity {

    @BindView(R.id.ivBluetooth)
    ImageView ivBluetooth;
    @BindView(R.id.swBluetooth)
    Switch swBluetooth;
    @BindView(R.id.swDiscoverable)
    Switch swDiscoverable;
    @BindView(R.id.btnFindDevices)
    Button btnFindDevices;
    @BindView(R.id.lsDiscoveredDevices)
    ListView lsDiscoveredDevices;

    //TODO 3.1 bluetooth
    BluetoothAdapter bluetoothAdapter ;

    //TODO 3.9
    Set<BluetoothDevice> paired ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        ButterKnife.bind(this);

        //TODO 3.2 inisialsisasi
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        if(bluetoothAdapter.isEnabled()){
            swBluetooth.setChecked(true);
        }


        //TODO 3.3 listener di swicth on/off dari bluetooth
        swBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    //TODO 3.4 check bluetooth aktif apa enggak
                    if (bluetoothAdapter.isEnabled()){

                        Toast.makeText(BluetoothActivity.this, "sudah aktif", Toast.LENGTH_SHORT).show();

                    }
                    else {
                            //TODO 3.5 CARA MENGAKTIFKAN BLUETOOTH
                        bluetoothAdapter.enable();

                    }

                }
                else{

                    if(!bluetoothAdapter.isEnabled()) {
                        //TODO 3.6
                        bluetoothAdapter.disable();

                    }
                }
            }
        });



        //TODO 3.7
        swDiscoverable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    //TODO 3.8


                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                      startActivity(i);

                }
                else{
                    bluetoothAdapter.cancelDiscovery();
                }

            }
        });


    }

    @OnClick(R.id.btnFindDevices)
    public void onViewClicked() {

        //TODO 3.10 deklrasi array
        ArrayList datadevice = new ArrayList();
//deklrasi paired device
        paired = bluetoothAdapter.getBondedDevices();

        //TODO 3.11 ambil informasi device
        for (BluetoothDevice nm : paired){

            datadevice.add(nm.getName());
        }
        //TODO 3.12 pindahin ke listview
        lsDiscoveredDevices.setAdapter(new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datadevice));

    }


}
