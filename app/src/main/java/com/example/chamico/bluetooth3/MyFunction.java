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
    public static MyFunction myFunction = new MyFunction();

    private BluetoothAdapter mAapter = BluetoothAdapter.getDefaultAdapter();

    public static boolean mainActivityFlag = false;
    public static boolean contronlActivityFlag = false;
    public static boolean ISDEVICECONNECTED = false;
    public static boolean ISMYBTOPEN = false;
    public static boolean ISBONDING = false;
    public static boolean CONTRONLSENDDISPPAUSE = true;
    public static boolean CONTRONLRECEIVEDISPPAUSE = true;


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
            APP_NAME = "基于MCU的球动式平衡机器人",
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


    SEND_BTN_DISP_1 = "天",
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


    public static void setSEND_BTN_DISP_1(String a){
        MyFunction.SEND_BTN_DISP_1 = a;
    }

    public static void setSEND_BTN_DISP_2(String a){
        MyFunction.SEND_BTN_DISP_2 = a;
    }

    public static void setSEND_BTN_DISP_3(String a){
        MyFunction.SEND_BTN_DISP_3 = a;
    }

    public static void setSEND_BTN_DISP_4(String a){
        MyFunction.SEND_BTN_DISP_4 = a;
    }

    public static void setSEND_BTN_DISP_5(String a){
        MyFunction.SEND_BTN_DISP_5 = a;
    }

    public static void setSEND_BTN_DISP_6(String a){
        MyFunction.SEND_BTN_DISP_6 = a;
    }

    public static void setSEND_BTN_DISP_7(String a){
        MyFunction.SEND_BTN_DISP_7 = a;
    }

    public static void setSEND_BTN_DISP_8(String a){
        MyFunction.SEND_BTN_DISP_8 = a;
    }

    public static void setSEND_BTN_DISP_9(String a){
        MyFunction.SEND_BTN_DISP_9 = a;
    }

    public static void setSEND_BTN_DISP_10(String a){
        MyFunction.SEND_BTN_DISP_10 = a;
    }

    public static void setSEND_BTN_DISP_11(String a){
        MyFunction.SEND_BTN_DISP_11 = a;
    }

    public static void setSEND_BTN_DISP_12(String a){
        MyFunction.SEND_BTN_DISP_12 = a;
    }

    public static void setAPP_NAME(String a){
        MyFunction.APP_NAME = a;
    }

    public static void setAUTUOR_INFO(String a){
        MyFunction.AUTUOR_INFO = a;
    }

    public static void setSEND_INFO_1(String a){
        MyFunction.SEND_INFO_1 = a;
    }

    public static void setSEND_INFO_2(String a){
        MyFunction.SEND_INFO_2 = a;
    }

    public static void setSEND_INFO_3(String a){
        MyFunction.SEND_INFO_3 = a;
    }

    public static void setSEND_INFO_4(String a){
        MyFunction.SEND_INFO_4 = a;
    }

    public static void setSEND_INFO_5(String a){
        MyFunction.SEND_INFO_5 = a;
    }

    public static void setSEND_INFO_6(String a){
        MyFunction.SEND_INFO_6 = a;
    }

    public static void setSEND_INFO_7(String a){
        MyFunction.SEND_INFO_7 = a;
    }

    public static void setSEND_INFO_8(String a){
        MyFunction.SEND_INFO_8 = a;
    }

    public static void setSEND_INFO_9(String a){
        MyFunction.SEND_INFO_9 = a;
    }

    public static void setSEND_INFO_10(String a){
        MyFunction.SEND_INFO_10 = a;
    }

    public static void setSEND_INFO_11(String a){
        MyFunction.SEND_INFO_11 = a;
    }

    public static void setSEND_INFO_12(String a){
        MyFunction.SEND_INFO_12 = a;
    }

    public static String getAPP_NAME(){
        return APP_NAME;
    }

    public static String getAUTUOR_INFO(){
        return AUTUOR_INFO;
    }

    public static String getSEND_INFO_1(){
        return SEND_INFO_1;
    }

    public static String getSEND_INFO_2(){
        return SEND_INFO_2;
    }

    public static String getSEND_INFO_3(){
        return SEND_INFO_3;
    }

    public static String getSEND_INFO_4(){
        return SEND_INFO_4;
    }

    public static String getSEND_INFO_5(){
        return SEND_INFO_5;
    }

    public static String getSEND_INFO_6(){
        return SEND_INFO_6;
    }

    public static String getSEND_INFO_7(){
        return SEND_INFO_7;
    }

    public static String getSEND_INFO_8(){
        return SEND_INFO_8;
    }

    public static String getSEND_INFO_9(){
        return SEND_INFO_9;
    }

    public static String getSEND_INFO_10(){
        return SEND_INFO_10;
    }

    public static String getSEND_INFO_11(){
        return SEND_INFO_11;
    }

    public static String getSEND_INFO_12(){
        return SEND_INFO_12;
    }

    public static String getSEND_BTN_DISP_1(){
        return SEND_BTN_DISP_1;
    }

    public static String getSEND_BTN_DISP_2(){
        return SEND_BTN_DISP_2;
    }

    public static String getSEND_BTN_DISP_3(){
        return SEND_BTN_DISP_3;
    }

    public static String getSEND_BTN_DISP_4(){
        return SEND_BTN_DISP_4;
    }

    public static String getSEND_BTN_DISP_5(){
        return SEND_BTN_DISP_5;
    }

    public static String getSEND_BTN_DISP_6(){
        return SEND_BTN_DISP_6;
    }

    public static String getSEND_BTN_DISP_7(){
        return SEND_BTN_DISP_7;
    }

    public static String getSEND_BTN_DISP_8(){
        return SEND_BTN_DISP_8;
    }

    public static String getSEND_BTN_DISP_9(){
        return SEND_BTN_DISP_9;
    }

    public static String getSEND_BTN_DISP_10(){
        return SEND_BTN_DISP_10;
    }

    public static String getSEND_BTN_DISP_11(){
        return SEND_BTN_DISP_11;
    }

    public static String getSEND_BTN_DISP_12(){
        return SEND_BTN_DISP_12;
    }


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
