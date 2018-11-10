package com.example.chamico.bluetooth3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.chamico.bluetooth3.ContronlActivity.contronlActivity;
import static com.example.chamico.bluetooth3.MyFunction.myFunction;
import static com.example.chamico.bluetooth3.Files.myFiles;
/**
 * Created by Chamico on 2018/6/13.
 */

public class SelfDialog extends Dialog {

    private Context context;
    private Button selfDialogBtnSaveDate;
    private Button selfDialogBtnExit;
    private EditText selfDialogEdtOrign_1;
    private EditText selfDialogEdtOrign_2;
    private EditText selfDialogEdtOrign_3;
    private EditText selfDialogEdtOrign_4;
    private EditText selfDialogEdtOrign_5;
    private EditText selfDialogEdtOrign_6;
    private EditText selfDialogEdtOrign_7;
    private EditText selfDialogEdtOrign_8;
    private EditText selfDialogEdtOrign_9;
    private EditText selfDialogEdtOrign_10;
    private EditText selfDialogEdtOrign_11;
    private EditText selfDialogEdtOrign_12;

    private EditText selfDialogEdtAfter_1;
    private EditText selfDialogEdtAfter_2;
    private EditText selfDialogEdtAfter_3;
    private EditText selfDialogEdtAfter_4;
    private EditText selfDialogEdtAfter_5;
    private EditText selfDialogEdtAfter_6;
    private EditText selfDialogEdtAfter_7;
    private EditText selfDialogEdtAfter_8;
    private EditText selfDialogEdtAfter_9;
    private EditText selfDialogEdtAfter_10;
    private EditText selfDialogEdtAfter_11;
    private EditText selfDialogEdtAfter_12;

    private TextView
            selfDialogTVMessage_1,
            selfDialogTVMessage_2,
            selfDialogTVMessage_3,
            selfDialogTVMessage_4,
            selfDialogTVMessage_5,
            selfDialogTVMessage_6,
            selfDialogTVMessage_7,
            selfDialogTVMessage_8,
            selfDialogTVMessage_9,
            selfDialogTVMessage_10,
            selfDialogTVMessage_11,
            selfDialogTVMessage_12;




    public SelfDialog(Context context) {
        super(context);
        this.context = context;

    }

    public SelfDialog(Context context,int theme) {
        super(context, theme);
        this.context = context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(context).inflate(R.layout.self_dialog, null);
        setContentView(view);

        boundSelfDialogID();
        initSelfDialogUI();
        saveChangeMessage();
        extiDiaog();

    }

    private void boundSelfDialogID(){

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.self_dialog, null);
        setContentView(view);

        selfDialogBtnSaveDate = (Button) findViewById(R.id.selfDialogBtnSaveDate);
        selfDialogBtnExit = (Button) findViewById(R.id.selfDialogBtnExit);

        selfDialogEdtOrign_1 = (EditText) findViewById(R.id.selfDialogEdtOrign_1);
        selfDialogEdtOrign_2 = (EditText) findViewById(R.id.selfDialogEdtOrign_2);
        selfDialogEdtOrign_3 = (EditText) findViewById(R.id.selfDialogEdtOrign_3);
        selfDialogEdtOrign_4 = (EditText) findViewById(R.id.selfDialogEdtOrign_4);
        selfDialogEdtOrign_5 = (EditText) findViewById(R.id.selfDialogEdtOrign_5);
        selfDialogEdtOrign_6 = (EditText) findViewById(R.id.selfDialogEdtOrign_6);
        selfDialogEdtOrign_7 = (EditText) findViewById(R.id.selfDialogEdtOrign_7);
        selfDialogEdtOrign_8 = (EditText) findViewById(R.id.selfDialogEdtOrign_8);
        selfDialogEdtOrign_9 = (EditText) findViewById(R.id.selfDialogEdtOrign_9);
        selfDialogEdtOrign_10 = (EditText) findViewById(R.id.selfDialogEdtOrign_10);
        selfDialogEdtOrign_11 = (EditText) findViewById(R.id.selfDialogEdtOrign_11);
        selfDialogEdtOrign_12 = (EditText) findViewById(R.id.selfDialogEdtOrign_12);

        selfDialogEdtAfter_1 = (EditText) findViewById(R.id.selfDialogEdtAfter_1);
        selfDialogEdtAfter_2 = (EditText) findViewById(R.id.selfDialogEdtAfter_2);
        selfDialogEdtAfter_3 = (EditText) findViewById(R.id.selfDialogEdtAfter_3);
        selfDialogEdtAfter_4 = (EditText) findViewById(R.id.selfDialogEdtAfter_4);
        selfDialogEdtAfter_5 = (EditText) findViewById(R.id.selfDialogEdtAfter_5);
        selfDialogEdtAfter_6 = (EditText) findViewById(R.id.selfDialogEdtAfter_6);
        selfDialogEdtAfter_7 = (EditText) findViewById(R.id.selfDialogEdtAfter_7);
        selfDialogEdtAfter_8 = (EditText) findViewById(R.id.selfDialogEdtAfter_8);
        selfDialogEdtAfter_9 = (EditText) findViewById(R.id.selfDialogEdtAfter_9);
        selfDialogEdtAfter_10 = (EditText) findViewById(R.id.selfDialogEdtAfter_10);
        selfDialogEdtAfter_11 = (EditText) findViewById(R.id.selfDialogEdtAfter_11);
        selfDialogEdtAfter_12 = (EditText) findViewById(R.id.selfDialogEdtAfter_12);

        selfDialogTVMessage_1 = (TextView)findViewById(R.id.selfDialogTVMessage_1);
        selfDialogTVMessage_2 = (TextView)findViewById(R.id.selfDialogTVMessage_2);
        selfDialogTVMessage_3 = (TextView)findViewById(R.id.selfDialogTVMessage_3);
        selfDialogTVMessage_4 = (TextView)findViewById(R.id.selfDialogTVMessage_4);
        selfDialogTVMessage_5 = (TextView)findViewById(R.id.selfDialogTVMessage_5);
        selfDialogTVMessage_6 = (TextView)findViewById(R.id.selfDialogTVMessage_6);
        selfDialogTVMessage_7 = (TextView)findViewById(R.id.selfDialogTVMessage_7);
        selfDialogTVMessage_8 = (TextView)findViewById(R.id.selfDialogTVMessage_8);
        selfDialogTVMessage_9 = (TextView)findViewById(R.id.selfDialogTVMessage_9);
        selfDialogTVMessage_10 = (TextView)findViewById(R.id.selfDialogTVMessage_10);
        selfDialogTVMessage_11 = (TextView)findViewById(R.id.selfDialogTVMessage_11);
        selfDialogTVMessage_12 = (TextView)findViewById(R.id.selfDialogTVMessage_12);
    }

    private void saveChangeMessage(){
        selfDialogBtnSaveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存文件到本地
                myFunction.setSEND_INFO_1(selfDialogEdtAfter_1.getText().toString());
                myFunction.setSEND_INFO_2(selfDialogEdtAfter_2.getText().toString());
                myFunction.setSEND_INFO_3(selfDialogEdtAfter_3.getText().toString());
                myFunction.setSEND_INFO_4(selfDialogEdtAfter_4.getText().toString());
                myFunction.setSEND_INFO_5(selfDialogEdtAfter_5.getText().toString());
                myFunction.setSEND_INFO_6(selfDialogEdtAfter_6.getText().toString());
                myFunction.setSEND_INFO_7(selfDialogEdtAfter_7.getText().toString());
                myFunction.setSEND_INFO_8(selfDialogEdtAfter_8.getText().toString());
                myFunction.setSEND_INFO_9(selfDialogEdtAfter_9.getText().toString());
                myFunction.setSEND_INFO_10(selfDialogEdtAfter_10.getText().toString());
                myFunction.setSEND_INFO_11(selfDialogEdtAfter_11.getText().toString());
                myFunction.setSEND_INFO_12(selfDialogEdtAfter_12.getText().toString());


                myFunction.setSEND_BTN_DISP_1(selfDialogEdtOrign_1.getText().toString());
                myFunction.setSEND_BTN_DISP_2(selfDialogEdtOrign_2.getText().toString());
                myFunction.setSEND_BTN_DISP_3(selfDialogEdtOrign_3.getText().toString());
                myFunction.setSEND_BTN_DISP_4(selfDialogEdtOrign_4.getText().toString());
                myFunction.setSEND_BTN_DISP_5(selfDialogEdtOrign_5.getText().toString());
                myFunction.setSEND_BTN_DISP_6(selfDialogEdtOrign_6.getText().toString());
                myFunction.setSEND_BTN_DISP_7(selfDialogEdtOrign_7.getText().toString());
                myFunction.setSEND_BTN_DISP_8(selfDialogEdtOrign_8.getText().toString());
                myFunction.setSEND_BTN_DISP_9(selfDialogEdtOrign_9.getText().toString());
                myFunction.setSEND_BTN_DISP_10(selfDialogEdtOrign_10.getText().toString());
                myFunction.setSEND_BTN_DISP_11(selfDialogEdtOrign_11.getText().toString());
                myFunction.setSEND_BTN_DISP_12(selfDialogEdtOrign_12.getText().toString());

                Log.e("SelfDialog","SelfDialogSendDisp " + myFunction.SEND_BTN_DISP_1);
                Log.e("SelfDialog","SelfDialogSendData " + myFunction.SEND_INFO_1);

                //设置显示
                contronlActivity.contronlBtnsendBtnMessage_1.setText(myFunction.getSEND_BTN_DISP_1());
                contronlActivity.contronlBtnsendBtnMessage_2.setText(myFunction.getSEND_BTN_DISP_2());
                contronlActivity.contronlBtnsendBtnMessage_3.setText(myFunction.getSEND_BTN_DISP_3());
                contronlActivity.contronlBtnsendBtnMessage_4.setText(myFunction.getSEND_BTN_DISP_4());
                contronlActivity.contronlBtnsendBtnMessage_5.setText(myFunction.getSEND_BTN_DISP_5());
                contronlActivity.contronlBtnsendBtnMessage_6.setText(myFunction.getSEND_BTN_DISP_6());
                contronlActivity.contronlBtnsendBtnMessage_7.setText(myFunction.getSEND_BTN_DISP_7());
                contronlActivity.contronlBtnsendBtnMessage_8.setText(myFunction.getSEND_BTN_DISP_8());
                contronlActivity.contronlBtnsendBtnMessage_9.setText(myFunction.getSEND_BTN_DISP_9());
                contronlActivity.contronlBtnsendBtnMessage_10.setText(myFunction.getSEND_BTN_DISP_10());
                contronlActivity.contronlBtnsendBtnMessage_11.setText(myFunction.getSEND_BTN_DISP_11());
                contronlActivity.contronlBtnsendBtnMessage_12.setText(myFunction.getSEND_BTN_DISP_12());


                //名称
                selfDialogTVMessage_1.setText(myFunction.getSEND_BTN_DISP_1());
                selfDialogTVMessage_2.setText(myFunction.getSEND_BTN_DISP_2());
                selfDialogTVMessage_3.setText(myFunction.getSEND_BTN_DISP_3());
                selfDialogTVMessage_4.setText(myFunction.getSEND_BTN_DISP_4());
                selfDialogTVMessage_5.setText(myFunction.getSEND_BTN_DISP_5());
                selfDialogTVMessage_6.setText(myFunction.getSEND_BTN_DISP_6());
                selfDialogTVMessage_7.setText(myFunction.getSEND_BTN_DISP_7());
                selfDialogTVMessage_8.setText(myFunction.getSEND_BTN_DISP_8());
                selfDialogTVMessage_9.setText(myFunction.getSEND_BTN_DISP_9());
                selfDialogTVMessage_10.setText(myFunction.getSEND_BTN_DISP_10());
                selfDialogTVMessage_11.setText(myFunction.getSEND_BTN_DISP_11());
                selfDialogTVMessage_12.setText(myFunction.getSEND_BTN_DISP_12());
                //设置名称
                selfDialogEdtOrign_1.setText(myFunction.getSEND_BTN_DISP_1());
                selfDialogEdtOrign_2.setText(myFunction.getSEND_BTN_DISP_2());
                selfDialogEdtOrign_3.setText(myFunction.getSEND_BTN_DISP_3());
                selfDialogEdtOrign_4.setText(myFunction.getSEND_BTN_DISP_4());
                selfDialogEdtOrign_5.setText(myFunction.getSEND_BTN_DISP_5());
                selfDialogEdtOrign_6.setText(myFunction.getSEND_BTN_DISP_6());
                selfDialogEdtOrign_7.setText(myFunction.getSEND_BTN_DISP_7());
                selfDialogEdtOrign_8.setText(myFunction.getSEND_BTN_DISP_8());
                selfDialogEdtOrign_9.setText(myFunction.getSEND_BTN_DISP_9());
                selfDialogEdtOrign_10.setText(myFunction.getSEND_BTN_DISP_10());
                selfDialogEdtOrign_11.setText(myFunction.getSEND_BTN_DISP_11());
                selfDialogEdtOrign_12.setText(myFunction.getSEND_BTN_DISP_12());

                //设置发送数据
                selfDialogEdtAfter_1.setText(myFunction.getSEND_INFO_1());
                selfDialogEdtAfter_2.setText(myFunction.getSEND_INFO_2());
                selfDialogEdtAfter_3.setText(myFunction.getSEND_INFO_3());
                selfDialogEdtAfter_4.setText(myFunction.getSEND_INFO_4());
                selfDialogEdtAfter_5.setText(myFunction.getSEND_INFO_5());
                selfDialogEdtAfter_6.setText(myFunction.getSEND_INFO_6());
                selfDialogEdtAfter_7.setText(myFunction.getSEND_INFO_7());
                selfDialogEdtAfter_8.setText(myFunction.getSEND_INFO_8());
                selfDialogEdtAfter_9.setText(myFunction.getSEND_INFO_9());
                selfDialogEdtAfter_10.setText(myFunction.getSEND_INFO_10());
                selfDialogEdtAfter_11.setText(myFunction.getSEND_INFO_11());
                selfDialogEdtAfter_12.setText(myFunction.getSEND_INFO_12());

                myFiles.createFileSendData();
                //退出自定义Dialog
                dismiss();
            }
        });
    }

    private void extiDiaog(){
        selfDialogBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void initSelfDialogUI(){

        Log.e("SelfDialog","SelfDialogSendDisp " + myFunction.SEND_BTN_DISP_1);
        Log.e("SelfDialog","SelfDialogSendData " + myFunction.SEND_INFO_1);
        //名称
        selfDialogTVMessage_1.setText(myFunction.getSEND_BTN_DISP_1());
        selfDialogTVMessage_2.setText(myFunction.getSEND_BTN_DISP_2());
        selfDialogTVMessage_3.setText(myFunction.getSEND_BTN_DISP_3());
        selfDialogTVMessage_4.setText(myFunction.getSEND_BTN_DISP_4());
        selfDialogTVMessage_5.setText(myFunction.getSEND_BTN_DISP_5());
        selfDialogTVMessage_6.setText(myFunction.getSEND_BTN_DISP_6());
        selfDialogTVMessage_7.setText(myFunction.getSEND_BTN_DISP_7());
        selfDialogTVMessage_8.setText(myFunction.getSEND_BTN_DISP_8());
        selfDialogTVMessage_9.setText(myFunction.getSEND_BTN_DISP_9());
        selfDialogTVMessage_10.setText(myFunction.getSEND_BTN_DISP_10());
        selfDialogTVMessage_11.setText(myFunction.getSEND_BTN_DISP_11());
        selfDialogTVMessage_12.setText(myFunction.getSEND_BTN_DISP_12());
        //设置名称
        selfDialogEdtOrign_1.setText(selfDialogTVMessage_1.getText().toString());
        selfDialogEdtOrign_2.setText(selfDialogTVMessage_2.getText().toString());
        selfDialogEdtOrign_3.setText(selfDialogTVMessage_3.getText().toString());
        selfDialogEdtOrign_4.setText(selfDialogTVMessage_4.getText().toString());
        selfDialogEdtOrign_5.setText(selfDialogTVMessage_5.getText().toString());
        selfDialogEdtOrign_6.setText(selfDialogTVMessage_6.getText().toString());
        selfDialogEdtOrign_7.setText(selfDialogTVMessage_7.getText().toString());
        selfDialogEdtOrign_8.setText(selfDialogTVMessage_8.getText().toString());
        selfDialogEdtOrign_9.setText(selfDialogTVMessage_9.getText().toString());
        selfDialogEdtOrign_10.setText(selfDialogTVMessage_10.getText().toString());
        selfDialogEdtOrign_11.setText(selfDialogTVMessage_11.getText().toString());
        selfDialogEdtOrign_12.setText(selfDialogTVMessage_12.getText().toString());

        //设置发送数据
        selfDialogEdtAfter_1.setText(myFunction.getSEND_INFO_1().toString());
        selfDialogEdtAfter_2.setText(myFunction.getSEND_INFO_2().toString());
        selfDialogEdtAfter_3.setText(myFunction.getSEND_INFO_3().toString());
        selfDialogEdtAfter_4.setText(myFunction.getSEND_INFO_4().toString());
        selfDialogEdtAfter_5.setText(myFunction.getSEND_INFO_5().toString());
        selfDialogEdtAfter_6.setText(myFunction.getSEND_INFO_6().toString());
        selfDialogEdtAfter_7.setText(myFunction.getSEND_INFO_7().toString());
        selfDialogEdtAfter_8.setText(myFunction.getSEND_INFO_8().toString());
        selfDialogEdtAfter_9.setText(myFunction.getSEND_INFO_9().toString());
        selfDialogEdtAfter_10.setText(myFunction.getSEND_INFO_10().toString());
        selfDialogEdtAfter_11.setText(myFunction.getSEND_INFO_11().toString());
        selfDialogEdtAfter_12.setText(myFunction.getSEND_INFO_12().toString());
    }
}
