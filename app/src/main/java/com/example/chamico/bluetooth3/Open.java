package com.example.chamico.bluetooth3;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.example.chamico.bluetooth3.ContronlActivity.myReceiveMessageAdapter;
import static com.example.chamico.bluetooth3.ContronlActivity.myReceiveMessageList;
import static com.example.chamico.bluetooth3.ContronlActivity.mySendMessageAdapter;
import static com.example.chamico.bluetooth3.ContronlActivity.mySendMessageListt;
import static com.example.chamico.bluetooth3.MainActivity.mainActivity;
import static com.example.chamico.bluetooth3.MyFunction.ISMYBTOPEN;
import static com.example.chamico.bluetooth3.MyFunction.MESSAGE_DEVICE_NAME;
import static com.example.chamico.bluetooth3.MyFunction.MESSAGE_READ;
import static com.example.chamico.bluetooth3.MyFunction.MESSAGE_STATE_CHANGE;
import static com.example.chamico.bluetooth3.MyFunction.MESSAGE_TOAST;
import static com.example.chamico.bluetooth3.MyFunction.MESSAGE_WRITE;


/**
 * Created by Chamico on 2018/5/2.
 */

public class Open {

    public static Open open;

    public static BluetoothDevice remoteDevice;
    public static BluetoothChatService mBluetoothChatService;
    private DeviceAdapter deviceAdapter;
    private BoundedDeviceAdapter mBoundDeviceAdapter;
    private MyFunction myFunction = new MyFunction();
    private BluetoothAdapter myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    public static List<BluetoothDevice> mDeviceList = new ArrayList<>();
    public static List<BluetoothDevice> mBondedDeviceList = new ArrayList<>();
    public static BluetoothDevice device;
    public static int status;

    /*
    *   @Explain: 注册蓝牙广播
    *   @Date: 2018/05/13
     */
    public BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            switch (action){
                //找到设备
                case BluetoothDevice.ACTION_FOUND:
                    //避免重复添加已经绑定过的设备
                    if (device.getBondState() == BluetoothDevice.BOND_BONDED) {
                        //此处的adapter是列表的adapter，不是BluetoothAdapter
                        break;
                    }
                    //myFunction.showToast("找到设备"+device.getName());
                    mDeviceList.add(device);
                    deviceAdapter.notifyDataSetChanged();
                    break;
                //开始扫描
                case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                    mDeviceList.clear();
                    deviceAdapter.notifyDataSetChanged();
                    //myFunction.showToast("开始查找");
                    break;
                //
                case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:
                    //myFunction.showToast("结束查找");
                    break;
                case BluetoothDevice.ACTION_BOND_STATE_CHANGED:
                    BluetoothDevice remoteDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    if( remoteDevice == null ) {
                        myFunction.showToast("no device");
                        return;
                    }
                    status = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE,0);
                    if( status == BluetoothDevice.BOND_BONDED) {
                        // 绑定设备成功，开始连接设备
                        myFunction.showToast("Bonded " + remoteDevice.getName());
                        //添加到绑定列表
                        mBondedDeviceList = myFunction.getBondedDeviceList();
                        mBoundDeviceAdapter.notifyDataSetChanged();
                    }
                    else if( status == BluetoothDevice.BOND_BONDING){
                        myFunction.showToast("Bonding " + remoteDevice.getName());
                    }
                    else if(status == BluetoothDevice.BOND_NONE){
                        myFunction.showToast("Not bond " + remoteDevice.getName());
                    }
                    break;
            }
        }
    };


    /*
    *   @explain: 在“连接”界面，为跳转到不同的界面设置监听器
    *   @date: 2018/05/01
     */
    public void setChangeActivityListenerOnMain(){
        //在“连接”界面，为点击“连接”按钮设置监听器
        mainActivity.mainBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFunction.showToast("已在‘连接’界面，无需重复操作！");
            }
        });
        //在“连接”界面，为点击“控制”按钮设置监听器
        mainActivity.mainBtnContronl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到下一个Activiry
                Intent intent = new Intent(mainActivity,ContronlActivity.class);
                mainActivity.startActivity(intent);
            }
        });
    }

    /*
    *   @explain: 初始化“连接”界面UI  &&  判断蓝牙是够存在
    *   @date: 2018/05/01
     */
    public void initMainUI(){
        //结束上一个Activity
        if(MyFunction.contronlActivityFlag){
            //true 执行，表明 ContronlActivity 已打开
            ContronlActivity.contronlActivity.finish();
            MyFunction.contronlActivityFlag = false;   //关闭成功的标志
        }

        // 判断蓝牙是否存在
        if(myBluetoothAdapter == null){
            //表明此设备不支持蓝牙
            myFunction.showToast("此设备不支持蓝牙");
            return;
        }

        //如果蓝牙已打开
        if(myBluetoothAdapter.isEnabled()){
            //设置Switch开关为打开状态
            mainActivity.mainSwhOpen.setChecked(true);
            //获取本地信息
            mainActivity.mainTVLocalName.setText(myBluetoothAdapter.getName());
            mainActivity.mainTVLocalAddress.setText(myBluetoothAdapter.getAddress());
        }else{
            //设置Switch开关为关闭状态
            mainActivity.mainSwhOpen.setChecked(false);
            //恢复默认本地信息
            mainActivity.mainTVLocalName.setText("None");
            mainActivity.mainTVLocalAddress.setText("None");
            //清除连接设备信息
            mainActivity.mainTVRemoteName.clearComposingText();
            mainActivity.mainTVRemoteAddress.clearComposingText();
        }

        //初始化两个ListView适配器
        mBoundDeviceAdapter = new BoundedDeviceAdapter();
        mainActivity.mainLVDevieceBounded.setAdapter(mBoundDeviceAdapter);
        deviceAdapter = new DeviceAdapter();
        mainActivity.mainLVDevice.setAdapter(deviceAdapter);
        //将已绑定设备列表显示
        mBondedDeviceList = myFunction.getBondedDeviceList();
        mBoundDeviceAdapter.notifyDataSetChanged();
    }

    /*
    *   @explain: 在“连接”界面，为Switch 控件设置监听器
    *   @date: 2018/05/02
     */
    public void setSwitchListenerOnMain(){
        //蓝牙开关
        mainActivity.mainSwhOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //打开蓝牙
                    boolean isOpen = myBluetoothAdapter.enable();
                    //显示本地设备信息
                    mainActivity.mainTVLocalName.setText(myBluetoothAdapter.getName());
                    mainActivity.mainTVLocalAddress.setText(myBluetoothAdapter.getAddress());

                    //判读蓝牙是否成功打开
                    if(isOpen){
                        ISMYBTOPEN = true;
                        mBondedDeviceList = myFunction.getBondedDeviceList();
                        mBoundDeviceAdapter.notifyDataSetChanged();
                    }else {
                        myFunction.showToast("蓝牙打开失败，请重试");
                        mainActivity.mainSwhOpen.setChecked(false);
                    }

                } else{
                    //关闭蓝牙
                    boolean isClose = myBluetoothAdapter.disable();
                    //恢复默认信息
                    mainActivity.mainTVLocalName.setText("None");
                    mainActivity.mainTVLocalAddress.setText("None");
                    //关闭可检测性
                    mainActivity.mainSwhCheck.setChecked(false);
                    if(isClose){
                        //关闭成功
                        ISMYBTOPEN = false;
                        mDeviceList.clear();
                        deviceAdapter.notifyDataSetChanged();

                        mBondedDeviceList.clear();
                        mBoundDeviceAdapter.notifyDataSetChanged();
                    }else{
                        //关闭失败
                        mainActivity.mainSwhOpen.setChecked(true);
                        myFunction.showToast("蓝牙关闭失败，请重试");
                    }
                }
            }
        });
        //可检测性开关
        mainActivity.mainSwhCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if(myBluetoothAdapter.isEnabled()){
                        //蓝牙已打开
                        Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                        bluetoothIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 100);
                        mainActivity.startActivity(bluetoothIntent);
                        myFunction.showToast("蓝牙可检测性开启");
                    }else{
                        myFunction.showToast("蓝牙状态异常，请打开蓝牙重试");
                        mainActivity.mainSwhCheck.setChecked(false);
                    }

                }else {

                    try {
                        Method setDiscoverableTimeout = BluetoothAdapter.class.getMethod("setDiscoverableTimeout", int.class);
                        setDiscoverableTimeout.setAccessible(true);
                        Method setScanMode =BluetoothAdapter.class.getMethod("setScanMode", int.class,int.class);
                        setScanMode.setAccessible(true);

                        setDiscoverableTimeout.invoke(myBluetoothAdapter, 1);
                        setScanMode.invoke(myBluetoothAdapter, BluetoothAdapter.SCAN_MODE_CONNECTABLE,1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    myFunction.showToast("蓝牙可检测性关闭");
                }
            }
        });
    }

    /*
   *   @explain: 在“连接”界面，为 "搜索"按钮设置监听器
   *   @date: 2018/05/02
    */
    public void setSearchListenerOnMain(){
        mainActivity.mainBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISMYBTOPEN){
                    //如果蓝牙处于打开状态
                    IntentFilter filter = new IntentFilter();
                    //开始查找
                    filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
                    //结束查找
                    filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
                    //查找设备
                    filter.addAction(BluetoothDevice.ACTION_FOUND);
                    //设备扫描模式改变
                    filter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
                    //绑定状态
                    filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);

                    mainActivity.registerReceiver(mReceiver,filter);

                    myBluetoothAdapter.startDiscovery();

                    mBondedDeviceList = myFunction.getBondedDeviceList();
                    mBoundDeviceAdapter.notifyDataSetChanged();
                }else{
                    //蓝牙处于关闭状态
                    myFunction.showToast("请先打开蓝牙再执行此操作！");
            }

            }
        });
    }

    /*
  *   @explain: 在“连接”界面，为 "停止搜索"按钮设置监听器
  *   @date: 2018/05/02
   */

    public void setStopSearchListenerOnMain(){
        mainActivity.mainBtnStopSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISMYBTOPEN){
                    //蓝牙处于打开状态
                    myFunction.showToast("结束搜索");
                    myBluetoothAdapter.cancelDiscovery();
                }else {
                    //蓝牙处于关闭状态
                    myFunction.showToast("请先打开蓝牙再执行此操作！");
                }
            }
        });
    }
    /*
    *   @explain: 在“连接”界面，为"关于" 控件设置监听器
    *   @date: 2018/05/02
     */
    public void setTittleListenerOnMain(){

        // “说明”按钮的监听器
        mainActivity.mainBtnExplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mainActivity)
                        .setTitle("说明")
                        .setIcon(R.drawable.main_explain)
                        .setMessage("   1、使用之前需要在Android手机上设置允许打开蓝牙这一权限\n\n    " +
                                "2、打开蓝牙，点击“开始搜索”\n\n    " +
                                "3、选择需要连接的设备，首次连接点击“未绑定设备”列表栏中的设备进行绑定，根据提示进行绑定。待绑定完成，" +
                                "点击“已绑定设备”列表栏中的设备进行连接，连接完成后在“已连接设备”处会显示连接设备信息\n\n    " +
                                "4、点击“控制”进入控制页面\n\n    " +
                                "5、若操作不当，会有相应提示信息\n\n    " +
                                "6、针对极个别手机无法显示搜索到的设备，可以使用手机自带的蓝牙功能，连接到蓝牙设备，然后使用此应用进行控制\n\n")
                        .setNegativeButton("确定", null)
                        .show();
            } 
        });

        //“关于”按钮的监听器
        mainActivity.mainBtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mainActivity)
                        .setTitle("About Us")
                        .setIcon(R.drawable.main_about)
                        .setMessage("    @Explain: 机器人工作室御用蓝牙APP\n\n    @Author: Chamico\n\n    @Connect: ChenTianhai114@163.com\n\n    @More: https://blog.csdn.net/Chamic\n\n")
                        .setNegativeButton("确定", null)
                        .show();
            }
        });
    }
    /*
    *   @explain: 在“连接”界面，为  设备列表 控件设置监听器
    *   @date: 2018/05/02
     */
    public void setDeviceLististenerOnMain(){
        //为已绑定设备设置监听器
        mainActivity.mainLVDevieceBounded.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mBluetoothChatService = new BluetoothChatService(mainActivity, mHandler);
                remoteDevice = mBondedDeviceList.get(position);

                if(mBluetoothChatService.getState() == BluetoothChatService.STATE_NONE) {
                    // Start the Bluetooth chat services
                    mBluetoothChatService.start();
                   // myFunction.showToast("null Object");
                }

                 mBluetoothChatService.connect(remoteDevice);


            }
        });

        //为未绑定设备设置监听器
        mainActivity.mainLVDevice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (myBluetoothAdapter.isDiscovering()) {
                    myBluetoothAdapter.cancelDiscovery();
                }
                BluetoothDevice device = (BluetoothDevice) deviceAdapter.getItem(position);
                device.createBond();
            }
        });

    }

    @SuppressLint("HandlerLeak") private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case MESSAGE_STATE_CHANGE:
                    switch(msg.arg1) {
                        case BluetoothChatService.STATE_CONNECTED:
                            //连接完成
                            //myFunction.showToast("Connected");
                            //显示已连接设备信息
                            mainActivity.mainTVRemoteName.setText(remoteDevice.getName());
                            mainActivity.mainTVRemoteAddress.setText(remoteDevice.getAddress());
                            //表示连接到设备
                            //CONNECTEDFLAG = true;
                            break;
                        case BluetoothChatService.STATE_CONNECTING:
                            //myFunction.showToast("Connecting");
                            break;
                        case BluetoothChatService.STATE_LISTEN:
                        case BluetoothChatService.STATE_NONE:
                            break;
                    }
                    break;
                case MESSAGE_WRITE:
                    if(myFunction.contronlActivityFlag){
                        byte[] writeBuf = (byte[]) msg.obj;
                        String writeMessage = new String(writeBuf);
                        mySendMessageListt.add(writeMessage);
                        mySendMessageAdapter.notifyDataSetChanged();
                    }

                    break;
                case MESSAGE_READ:
                    if(myFunction.contronlActivityFlag){
                        byte[] readBuf = (byte[]) msg.obj;
                        String readMessage = new String(readBuf, 0, msg.arg1);
                        replaceBlank(readMessage);
                        myReceiveMessageList.add(replaceBlank(readMessage));
                        myReceiveMessageAdapter.notifyDataSetChanged();
                    }

                    break;
                case MESSAGE_DEVICE_NAME:
                    break;
                case MESSAGE_TOAST:
                    break;
            }
        }
    };

    public String replaceBlank(String src) {
        String dest = "";
        dest = src.replace("\n","");
        return dest;
    }
}