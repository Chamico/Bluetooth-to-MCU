package com.example.chamico.bluetooth3;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.chamico.bluetooth3.MainActivity.mainActivity;

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

    public String
            APP_NAME = "蓝牙应用程序",
            AUTUOR_INFO = "Chamico",


            SEND_INFO_1 = "1",
            SEND_INFO_2 = "2",
            SEND_INFO_3 = "3",
            SEND_INFO_4 = "4",
            SEND_INFO_5 = "5",
            SEND_INFO_6 = "6",
            SEND_INFO_7 = "7",
            SEND_INFO_8 = "8",
            SEND_INFO_9 = "9",
            SEND_INFO_10 = "10",
            SEND_INFO_11 = "11",
            SEND_INFO_12 = "12",


            SEND_BTN_DISP_1 = "1",
            SEND_BTN_DISP_2 = "2",
            SEND_BTN_DISP_3 = "3",
            SEND_BTN_DISP_4 = "4",
            SEND_BTN_DISP_5 = "5",
            SEND_BTN_DISP_6 = "6",
            SEND_BTN_DISP_7 = "7",
            SEND_BTN_DISP_8 = "8",
            SEND_BTN_DISP_9 = "9",
            SEND_BTN_DISP_10 = "10",
            SEND_BTN_DISP_11 = "11",
            SEND_BTN_DISP_12 = "12";



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
