package com.example.chamico.bluetooth3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.chamico.bluetooth3.MainActivity.mainActivity;
import static com.example.chamico.bluetooth3.MainActivity.myBluetoothAdapter;

/**
 * Created by Chamico on 2018/5/1
 *  @Explain:  This File have include some infomation which used in all project
 *  @Date: 2018/06/17
 */

public class MyFunction {

    private BluetoothAdapter mAapter = BluetoothAdapter.getDefaultAdapter();

    public static boolean mainActivityFlag = false;
    public static boolean contronlActivityFlag = false;
    public static boolean ISDEVICECONNECTED = false;
    public static boolean ISMYBTOPEN = false;


    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";


    public static String
            SENDMSG_1 = null,
            SENDMSG_2 = null,
            SENDMSG_3 = null,
            SENDMSG_4 = null,
            SENDMSG_5 = null,
            SENDMSG_6 = null,
            SENDMSG_7 = null,
            SENDMSG_8 = null,
            SENDMSG_9 = null,
            SENDMSG_10 = null,
            SENDMSG_11 = null,
            SENDMSG_12 = null;


    /*
    *   @explain: show a Toast View
    *   @date: 2018/05/01
     */
    public void showToast(String string){
        Toast.makeText(mainActivity, string, Toast.LENGTH_SHORT).show();
    }

    public List<BluetoothDevice> getBondedDeviceList() {
        return new ArrayList<>(mAapter.getBondedDevices());
    }

}
