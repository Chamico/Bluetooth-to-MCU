package com.example.chamico.bluetooth3;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.security.KeyStore;
import java.util.logging.SocketHandler;

import static com.example.chamico.bluetooth3.MyFunction.ISDEVICECONNECTED;
import static com.example.chamico.bluetooth3.Open.open;
import static com.example.chamico.bluetooth3.Open.remoteDevice;

/*
*   @explain: This is Connect Activity
*   @author: Chamcio
*   @connect: ChenTianhai114@163.com
 */
public class MainActivity extends Activity {

    private Open myOpen = new Open();
    private MyFunction myFunction = new MyFunction();

    public BluetoothProfile bluetoothProfile;

    public static MainActivity mainActivity;

    public static BluetoothAdapter myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    public Button mainBtnMain;
    public Button mainBtnContronl;
    public Switch mainSwhCheck;
    public Switch mainSwhOpen;
    public TextView mainTVLocalName;
    public TextView mainTVLocalAddress;
    public TextView mainTVRemoteName;
    public TextView mainTVRemoteAddress;
    public Button mainBtnSearch;
    public Button mainBtnStopSearch;
    public Button mainBtnAbout;
    public Button mainBtnExplain;
    public ListView mainLVDevice;
    public ListView mainLVDevieceBounded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定“连接”界面UI控件的ID
        boundMainUI();
        //初始化“连接”界面UI  &&  判断蓝牙是够存在
        myOpen.initMainUI();
        //在“连接”界面为跳转到不同的界面设置监听器
        myOpen.setChangeActivityListenerOnMain();
        //在“连接”界面，为Switch 控件设置监听器
        myOpen.setSwitchListenerOnMain();
        //在“连接”界面，为 "搜索"按钮设置监听器
        myOpen.setSearchListenerOnMain();
        //在“连接”界面，为 "停止搜索"按钮设置监听器
        myOpen.setStopSearchListenerOnMain();
        //在“连接”界面，为 "标题"按钮设置监听器
        myOpen.setTittleListenerOnMain();
        //在“连接”界面，为 "标题"按钮设置监听器
        myOpen.setDeviceLististenerOnMain();
        Log.e("TAG","onCreate");
    }

    /*
    *   @explain: 绑定“连接”界面的UI控件的ID
    *   @date: 2018/05/01
     */
    public void boundMainUI(){

        MyFunction.mainActivityFlag = true;

        //绑定ID
        mainBtnMain = (Button) findViewById(R.id.mainBtnMain);
        mainBtnContronl = (Button) findViewById(R.id.mainBtnContronl);
        mainSwhOpen = (Switch) findViewById(R.id.mainSwhOpen);
        mainSwhCheck = (Switch) findViewById(R.id.mainSwhCheck);
        mainTVLocalName = (TextView) findViewById(R.id.mainTVLocalName);
        mainTVLocalAddress = (TextView) findViewById(R.id.mainTVLocalAddress);
        mainTVRemoteName = (TextView) findViewById(R.id.mainTVRemoteName);
        mainTVRemoteAddress = (TextView) findViewById(R.id.mainTVRemoteAddress);
        mainBtnSearch = (Button) findViewById(R.id.mainBtnSearch);
        mainBtnStopSearch = (Button) findViewById(R.id.mainBtnStopSearch);
        mainBtnAbout = (Button) findViewById(R.id.mainBtnAbout);
        mainBtnExplain = (Button) findViewById(R.id.mainBtnExplain);

        mainLVDevice = (ListView) findViewById(R.id.mainLVDevice);
        mainLVDevieceBounded = (ListView) findViewById(R.id.mainLVDevieceBounded);

        mainActivity = MainActivity.this;
    }

    /*
    *   @explain: 当用户离开应用后再次回到应用，重新加载UI
    *   @date: 2018/05/02
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG","onResume");

        // 判断蓝牙是否存在
        if(myBluetoothAdapter == null){
            //表明此设备不支持蓝牙
            myFunction.showToast("此设备不支持蓝牙");
            return;
        }

        //如果蓝牙已打开
        if(myBluetoothAdapter.isEnabled()){
            //设置Switch开关为打开状态
            mainSwhOpen.setChecked(true);
            //获取本地信息
            mainTVLocalName.setText(myBluetoothAdapter.getName());
            mainTVLocalAddress.setText(myBluetoothAdapter.getAddress());
            //设置蓝牙状态标志位
            myFunction.ISMYBTOPEN = true;
        }else{
            //设置Switch开关为关闭状态
            mainSwhOpen.setChecked(false);
            //恢复默认本地信息
            mainTVLocalName.setText("None");
            mainTVLocalAddress.setText("None");
            //设置蓝牙状态标志位
            myFunction.ISMYBTOPEN = false;
        }

        //如果蓝牙设备连接，显示信息
        if(ISDEVICECONNECTED){
            mainActivity.mainTVRemoteName.setText(remoteDevice.getName());
            mainActivity.mainTVRemoteAddress.setText(remoteDevice.getAddress());
        }else {
            mainActivity.mainTVRemoteName.clearComposingText();
            mainActivity.mainTVRemoteAddress.clearComposingText();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //如果蓝牙设备连接，显示信息
        if(ISDEVICECONNECTED){
            mainActivity.mainTVRemoteName.setText(remoteDevice.getName());
            mainActivity.mainTVRemoteAddress.setText(remoteDevice.getAddress());
        }else {
            mainActivity.mainTVRemoteName.clearComposingText();
            mainActivity.mainTVRemoteAddress.clearComposingText();
        }
        Log.e("TAG","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG","onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG","onPuase");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG","onStart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //程序结束时注销广播
        //unregisterReceiver(open.mReceiver);
    }
}


