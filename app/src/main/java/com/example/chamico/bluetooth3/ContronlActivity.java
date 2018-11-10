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
import android.util.Log;
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
import static com.example.chamico.bluetooth3.MyFunction.myFunction;

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
    private Button contronlBtnSendDispPause;
    private Button contronlBtnReceiveDispPause;
    //ListViewAdapter
    public static ReceiveMessageAdapter myReceiveMessageAdapter;
    public static SendMessageAdapter mySendMessageAdapter;
    public static List<String> mySendMessageListt = new ArrayList<>();
    public static List<String> myReceiveMessageList = new ArrayList<>();


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
        Log.e("ContronlStatu", "OnCreate");

        //绑定“控制”界面的UI控件ID
        boundContronlUI();
        //初始化“控制”界面UI
        initContronlUI();
        //初始化发送的数据源
        initDate();
        Log.e("SelfDialog", "ContronlSendDisp " + myFunction.SEND_BTN_DISP_1);
        Log.e("SelfDialog", "ContronlSendData " + myFunction.SEND_INFO_1);
        //在“控制”界面，为跳转到不同的界面设置监听器
        setChangeActivityListenerOnContronl();
        //在“控制”界面，为 “说明” 按钮设置监听器
        setExplianListenerOnContronl();
        //在“控制”界面，为“发送信息系列”控件设置监听器
        setSendMessageListenerOnContronl();
        //在“控制”界面，为“清空信息"控件设置监听器
        setCleatListVIewListenerOnContronl();
        //在“控制”，为“暂停显示”控件设置监听器
        setDispPause();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*
   *   @explain: 在“控制”，为“暂停显示”控件设置监听器
   *   @date: 2018/11/10
    */
    private void setDispPause(){

        //发送数据
        contronlBtnSendDispPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(myFunction.CONTRONLSENDDISPPAUSE){
                    contronlBtnSendDispPause.setText("恢复显示");
                    myFunction.CONTRONLSENDDISPPAUSE = false;
                }else{
                    contronlBtnSendDispPause.setText("暂停显示");
                    myFunction.CONTRONLSENDDISPPAUSE = true;
                }

            }
        });

        //接受数据
        contronlBtnReceiveDispPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(myFunction.CONTRONLRECEIVEDISPPAUSE){
                    contronlBtnReceiveDispPause.setText("恢复显示");
                    myFunction.CONTRONLRECEIVEDISPPAUSE = false;
                }else{
                    contronlBtnReceiveDispPause.setText("暂停显示");
                    myFunction.CONTRONLRECEIVEDISPPAUSE = true;
                }
            }
        });
    }
    /*
   *   @explain: 在“控制”界面，为“发送信息系列”控件设置监听器
   *   @date: 2018/06/11
    */
    private void setSendMessageListenerOnContronl() {

        contronlBtnsendBtnMessage_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_1());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_2());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_3());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_4());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_5());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_6());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_7());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_8());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_9());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_10());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_11());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnsendBtnMessage_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(myFunction.getSEND_INFO_12());
                } else {
                    myFunction.showToast("连接错误，请重启APP并重新连接设备再试");
                }

            }
        });

        contronlBtnSendEditTextMessaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ISDEVICECONNECTED) {
                    sendMessage(contronlETSendMessage.getText().toString());
                    contronlBtnSendEditTextMessaga.clearComposingText();
                } else {
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

        contronlBtnSendDispPause = (Button) findViewById(R.id.contronlBtnSendDispPause);
        contronlBtnReceiveDispPause = (Button) findViewById(R.id.contronlBtnReceiveDispPause);
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

    private void initDate() {
        //init the send message date.

        contronlActivity.contronlBtnsendBtnMessage_1.setText(myFunction.SEND_BTN_DISP_1);
        contronlActivity.contronlBtnsendBtnMessage_2.setText(myFunction.SEND_BTN_DISP_2);
        contronlActivity.contronlBtnsendBtnMessage_3.setText(myFunction.SEND_BTN_DISP_3);
        contronlActivity.contronlBtnsendBtnMessage_4.setText(myFunction.SEND_BTN_DISP_4);
        contronlActivity.contronlBtnsendBtnMessage_5.setText(myFunction.SEND_BTN_DISP_5);
        contronlActivity.contronlBtnsendBtnMessage_6.setText(myFunction.SEND_BTN_DISP_6);
        contronlActivity.contronlBtnsendBtnMessage_7.setText(myFunction.SEND_BTN_DISP_7);
        contronlActivity.contronlBtnsendBtnMessage_8.setText(myFunction.SEND_BTN_DISP_8);
        contronlActivity.contronlBtnsendBtnMessage_9.setText(myFunction.SEND_BTN_DISP_9);
        contronlActivity.contronlBtnsendBtnMessage_10.setText(myFunction.SEND_BTN_DISP_10);
        contronlActivity.contronlBtnsendBtnMessage_11.setText(myFunction.SEND_BTN_DISP_11);
        contronlActivity.contronlBtnsendBtnMessage_12.setText(myFunction.SEND_BTN_DISP_12);

        /*
          * @Explain: regester a Broadcast to receive the information that the
          * connected bluetooth deveice was interrupted
         */
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);

        contronlActivity.registerReceiver(changeReceiver, filter);
    }

    private BroadcastReceiver changeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
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
        String[] items = {"断开连接", "使用说明", "配置按钮", "退出"};
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        itemsDialogFragment.disConnect();
                        break;
                    case 1:
                        itemsDialogFragment.directionUse();
                        break;
                    case 2:
                        itemsDialogFragment.setButton();
                        break;
                    case 3:
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

        Log.e("ContronlStatu", "OnStart");
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();

        Log.e("ContronlStatu", "OnStop");
    }

    @Override
    protected void onDestroy() {

        /*
            * @ Explain: unregister the broadcase.
         */
        super.onDestroy();
        unregisterReceiver(changeReceiver);

        Log.e("ContronlStatu", "OnDestory");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e("ContronlStatu", "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ContronlStatu", "OnResume");
    }
}