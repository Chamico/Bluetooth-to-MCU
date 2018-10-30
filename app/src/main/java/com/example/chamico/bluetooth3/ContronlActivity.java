package com.example.chamico.bluetooth3;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import static com.example.chamico.bluetooth3.MyFunction.ISDEVICECONNECTED;
import static com.example.chamico.bluetooth3.Open.mBluetoothChatService;


/*
*   @explain: This is Contronl Activity
*   @author: Chamcio
*   @connect: ChenTianhai114@163.com
 */
public class ContronlActivity extends Activity {

    public static ContronlActivity contronlActivity;
    //控件
    private Button contronlBtnExplain;
    private Button contronlBtnSendClear;
    private Button contronlBtnReceiveClear;
    private ListView contronlListViewSend;
    private ListView contronlListViewRecieve;
    public Button contronlBtnsendBtnMessage_1;
    public Button contronlBtnsendBtnMessage_2;
    public Button contronlBtnsendBtnMessage_3;
    public Button contronlBtnsendBtnMessage_4;
    public Button contronlBtnsendBtnMessage_5;
    public Button contronlBtnsendBtnMessage_6;
    public Button contronlBtnsendBtnMessage_7;
    public Button contronlBtnsendBtnMessage_8;
    public Button contronlBtnsendBtnMessage_9;
    public Button contronlBtnsendBtnMessage_10;
    public Button contronlBtnsendBtnMessage_11;
    public Button contronlBtnsendBtnMessage_12;
    private EditText contronlETSendMessage;
    private Button contronlBtnSendEditTextMessaga;
    private Button contronlBtnMain;
    private Button contronlBtnContronl;
    //ListViewAdapter
    public static ReceiveMessageAdapter myReceiveMessageAdapter;
    public static SendMessageAdapter mySendMessageAdapter;
    public static List<String> mySendMessageListt = new ArrayList<>();
    public static List<String> myReceiveMessageList = new ArrayList<>();

    private MyFunction myFunction = new MyFunction();

    public ItemsDialogFragment itemsDialogFragment;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contronl);

        //绑定“控制”界面的UI控件ID
        boundContronlUI();
        //初始化“控制”界面UI
        initContronlUI();
        //初始化发送的数据源
        initDate();
        //在“控制”界面，为跳转到不同的界面设置监听器
        setChangeActivityListenerOnContronl();
        //在“控制”界面，为 “说明” 按钮设置监听器
        setExplianListenerOnContronl();
        //在“控制”界面，为“发送信息系列”控件设置监听器
        setSendMessageListenerOnContronl();
        //在“控制”界面，为“清空信息"控件设置监听器
        setCleatListVIewListenerOnContronl();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*
   *   @explain: 在“控制”界面，为“发送信息系列”控件设置监听器
   *   @date: 2018/06/11
    */
    private void setSendMessageListenerOnContronl() {

        contronlBtnsendBtnMessage_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_1);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_2);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_3);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_4);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_5);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_6);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_7);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_8);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_9);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_10);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_11);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(myFunction.SENDMSG_12);
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnSendEditTextMessaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ISDEVICECONNECTED){
                    sendMessage(contronlETSendMessage.getText().toString());
                    contronlBtnSendEditTextMessaga.clearComposingText();
                }else{
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });
    }

    /*
   *   @explain: 在“控制”界面，为“清空信息"控件设置监听器
   *   @date: 2018/06/11
    */
    private void setCleatListVIewListenerOnContronl() {
        contronlBtnSendClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySendMessageListt.clear();
                mySendMessageAdapter.notifyDataSetChanged();
            }
        });

        contronlBtnReceiveClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myReceiveMessageList.clear();
                myReceiveMessageAdapter.notifyDataSetChanged();
            }
        });
    }

    // “更多”按钮的监听器
    private void setExplianListenerOnContronl() {
        contronlBtnExplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showItemsDialogFragment();
            }
        });
    }


    /*
    *   @explain: 绑定“控制”界面的UI控件ID
    *   @date: 2018/05/01
     */
    public void boundContronlUI() {

        MyFunction.contronlActivityFlag = true;
        contronlActivity = ContronlActivity.this;

        contronlBtnSendClear = (Button) findViewById(R.id.contronlBtnSendClear);
        contronlBtnExplain = (Button) findViewById(R.id.contronlBtnExplain);
        contronlBtnReceiveClear = (Button) findViewById(R.id.contronlBtnReceiveClear);
        contronlListViewSend = (ListView) findViewById(R.id.contronlListViewSend);
        contronlListViewRecieve = (ListView) findViewById(R.id.contronlListViewRecieve);
        contronlBtnsendBtnMessage_1 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_1);
        contronlBtnsendBtnMessage_2 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_2);
        contronlBtnsendBtnMessage_3 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_3);
        contronlBtnsendBtnMessage_4 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_4);
        contronlBtnsendBtnMessage_5 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_5);
        contronlBtnsendBtnMessage_6 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_6);
        contronlBtnsendBtnMessage_7 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_7);
        contronlBtnsendBtnMessage_8 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_8);
        contronlBtnsendBtnMessage_9 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_9);
        contronlBtnsendBtnMessage_10 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_10);
        contronlBtnsendBtnMessage_11 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_11);
        contronlBtnsendBtnMessage_12 = (Button) findViewById(R.id.contronlBtnsendBtnMessage_12);
        contronlETSendMessage = (EditText) findViewById(R.id.contronlETSendMessage);
        contronlBtnSendEditTextMessaga = (Button) findViewById(R.id.contronlBtnSendEditTextMessaga);
        contronlBtnMain = (Button) findViewById(R.id.contronlBtnMain);
        contronlBtnContronl = (Button) findViewById(R.id.contronlBtnContronl);
    }

    /*
    *   @explain: 在“控制”界面，为跳转到不同的界面设置监听器
    *   @date: 2018/05/01
     */
    public void setChangeActivityListenerOnContronl() {
        //为点击“连接”按钮设置监听器
        contronlBtnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContronlActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //为点击“控制”按钮设置监听器
        contronlBtnContronl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFunction.showToast("已在‘控制’界面，无需重复操作！");
            }
        });
    }

    /*
    *   @explain: 初始化“控制”界面UI
    *   @date: 2018/05/01
     */
    private void initContronlUI() {
        //结束上一个Activity
        if (MyFunction.mainActivityFlag) {
            //true 执行，表明 MainActivity 已打开
            MainActivity.mainActivity.finish();
            MyFunction.mainActivityFlag = false;   //关闭成功的标志
        }
        //初始化ListView适配器
        myReceiveMessageAdapter = new ReceiveMessageAdapter();
        contronlActivity.contronlListViewRecieve.setAdapter(myReceiveMessageAdapter);

        mySendMessageAdapter = new SendMessageAdapter();
        contronlActivity.contronlListViewSend.setAdapter(mySendMessageAdapter);
        //清空数据列表
        myReceiveMessageList.clear();
        myReceiveMessageAdapter.notifyDataSetChanged();
        mySendMessageListt.clear();
        mySendMessageAdapter.notifyDataSetChanged();

        itemsDialogFragment = new ItemsDialogFragment();
    }

    private void initDate(){
        //init the send message date.
        myFunction.SENDMSG_1 = contronlBtnsendBtnMessage_1.getText().toString();
        myFunction.SENDMSG_2 = contronlBtnsendBtnMessage_2.getText().toString();
        myFunction.SENDMSG_3 = contronlBtnsendBtnMessage_3.getText().toString();
        myFunction.SENDMSG_4 = contronlBtnsendBtnMessage_4.getText().toString();
        myFunction.SENDMSG_5 = contronlBtnsendBtnMessage_5.getText().toString();
        myFunction.SENDMSG_6 = contronlBtnsendBtnMessage_6.getText().toString();
        myFunction.SENDMSG_7 = contronlBtnsendBtnMessage_7.getText().toString();
        myFunction.SENDMSG_8 = contronlBtnsendBtnMessage_8.getText().toString();
        myFunction.SENDMSG_9 = contronlBtnsendBtnMessage_9.getText().toString();
        myFunction.SENDMSG_10 = contronlBtnsendBtnMessage_10.getText().toString();
        myFunction.SENDMSG_11 = contronlBtnsendBtnMessage_11.getText().toString();
        myFunction.SENDMSG_12 = contronlBtnsendBtnMessage_12.getText().toString();

        /*
          * @Explain: regester a Broadcast to receive the information that the
          * connected bluetooth deveice was interrupted
         */
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);

        contronlActivity.registerReceiver(changeReceiver,filter);
    }

    private BroadcastReceiver changeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action){
                case BluetoothDevice.ACTION_ACL_DISCONNECTED:
                    //蓝牙连接被切断
                    ISDEVICECONNECTED = false;
                    myFunction.showToast("Connect break!");
                    break;
            }
        }
    };


    public void sendMessage(String message) {
        // Check that we're actually connected before trying anything

        // Check that there's actually something to send
        if (message.length() > 0) {
            // Get the message bytes and tell the BluetoothChatService to write
            byte[] send = message.getBytes();
            mBluetoothChatService.write(send);
        }
    }

    public void showItemsDialogFragment() {
        String[] items = {"使用说明", "配置按钮", "退出"};
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        itemsDialogFragment.directionUse();
                        break;
                    case 1:
                        itemsDialogFragment.setButton();
                        break;
                    case 2:
                        itemsDialogFragment.exitActivity();
                        break;
                }
            }
        }, getFragmentManager());
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Contronl Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    protected void onDestroy() {

        /*
            * @ Explain: unregister the broadcase.
         */
        super.onDestroy();
        unregisterReceiver(changeReceiver);
    }
}
