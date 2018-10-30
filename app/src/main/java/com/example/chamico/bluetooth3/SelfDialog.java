package com.example.chamico.bluetooth3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.chamico.bluetooth3.ContronlActivity.contronlActivity;


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


    private MyFunction myFunction = new MyFunction();

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
                contronlActivity.contronlBtnsendBtnMessage_1.setText(selfDialogEdtOrign_1.getText());
                contronlActivity.contronlBtnsendBtnMessage_2.setText(selfDialogEdtOrign_2.getText());
                contronlActivity.contronlBtnsendBtnMessage_3.setText(selfDialogEdtOrign_3.getText());
                contronlActivity.contronlBtnsendBtnMessage_4.setText(selfDialogEdtOrign_4.getText());
                contronlActivity.contronlBtnsendBtnMessage_5.setText(selfDialogEdtOrign_5.getText());
                contronlActivity.contronlBtnsendBtnMessage_6.setText(selfDialogEdtOrign_6.getText());
                contronlActivity.contronlBtnsendBtnMessage_7.setText(selfDialogEdtOrign_7.getText());
                contronlActivity.contronlBtnsendBtnMessage_8.setText(selfDialogEdtOrign_8.getText());
                contronlActivity.contronlBtnsendBtnMessage_9.setText(selfDialogEdtOrign_9.getText());
                contronlActivity.contronlBtnsendBtnMessage_10.setText(selfDialogEdtOrign_10.getText());
                contronlActivity.contronlBtnsendBtnMessage_11.setText(selfDialogEdtOrign_11.getText());
                contronlActivity.contronlBtnsendBtnMessage_12.setText(selfDialogEdtOrign_12.getText());

                myFunction.SENDMSG_1 = selfDialogEdtAfter_1.getText().toString();
                myFunction.SENDMSG_2 = selfDialogEdtAfter_2.getText().toString();
                myFunction.SENDMSG_3 = selfDialogEdtAfter_3.getText().toString();
                myFunction.SENDMSG_4 = selfDialogEdtAfter_4.getText().toString();
                myFunction.SENDMSG_5 = selfDialogEdtAfter_5.getText().toString();
                myFunction.SENDMSG_6 = selfDialogEdtAfter_6.getText().toString();
                myFunction.SENDMSG_7 = selfDialogEdtAfter_7.getText().toString();
                myFunction.SENDMSG_8 = selfDialogEdtAfter_8.getText().toString();
                myFunction.SENDMSG_9 = selfDialogEdtAfter_9.getText().toString();
                myFunction.SENDMSG_10 = selfDialogEdtAfter_10.getText().toString();
                myFunction.SENDMSG_11 = selfDialogEdtAfter_11.getText().toString();
                myFunction.SENDMSG_12 = selfDialogEdtAfter_12.getText().toString();

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
        //名称
        selfDialogTVMessage_1.setText(contronlActivity.contronlBtnsendBtnMessage_1.getText());
        selfDialogTVMessage_2.setText(contronlActivity.contronlBtnsendBtnMessage_2.getText());
        selfDialogTVMessage_3.setText(contronlActivity.contronlBtnsendBtnMessage_3.getText());
        selfDialogTVMessage_4.setText(contronlActivity.contronlBtnsendBtnMessage_4.getText());
        selfDialogTVMessage_5.setText(contronlActivity.contronlBtnsendBtnMessage_5.getText());
        selfDialogTVMessage_6.setText(contronlActivity.contronlBtnsendBtnMessage_6.getText());
        selfDialogTVMessage_7.setText(contronlActivity.contronlBtnsendBtnMessage_7.getText());
        selfDialogTVMessage_8.setText(contronlActivity.contronlBtnsendBtnMessage_8.getText());
        selfDialogTVMessage_9.setText(contronlActivity.contronlBtnsendBtnMessage_9.getText());
        selfDialogTVMessage_10.setText(contronlActivity.contronlBtnsendBtnMessage_10.getText());
        selfDialogTVMessage_11.setText(contronlActivity.contronlBtnsendBtnMessage_11.getText());
        selfDialogTVMessage_12.setText(contronlActivity.contronlBtnsendBtnMessage_12.getText());
        //设置名称
        selfDialogEdtOrign_1.setText(selfDialogTVMessage_1.getText());
        selfDialogEdtOrign_2.setText(selfDialogTVMessage_2.getText());
        selfDialogEdtOrign_3.setText(selfDialogTVMessage_3.getText());
        selfDialogEdtOrign_4.setText(selfDialogTVMessage_4.getText());
        selfDialogEdtOrign_5.setText(selfDialogTVMessage_5.getText());
        selfDialogEdtOrign_6.setText(selfDialogTVMessage_6.getText());
        selfDialogEdtOrign_7.setText(selfDialogTVMessage_7.getText());
        selfDialogEdtOrign_8.setText(selfDialogTVMessage_8.getText());
        selfDialogEdtOrign_9.setText(selfDialogTVMessage_9.getText());
        selfDialogEdtOrign_10.setText(selfDialogTVMessage_10.getText());
        selfDialogEdtOrign_11.setText(selfDialogTVMessage_11.getText());
        selfDialogEdtOrign_12.setText(selfDialogTVMessage_12.getText());

        //设置发送数据
        selfDialogEdtAfter_1.setText(myFunction.SENDMSG_1);
        selfDialogEdtAfter_2.setText(myFunction.SENDMSG_2);
        selfDialogEdtAfter_3.setText(myFunction.SENDMSG_3);
        selfDialogEdtAfter_4.setText(myFunction.SENDMSG_4);
        selfDialogEdtAfter_5.setText(myFunction.SENDMSG_5);
        selfDialogEdtAfter_6.setText(myFunction.SENDMSG_6);
        selfDialogEdtAfter_7.setText(myFunction.SENDMSG_7);
        selfDialogEdtAfter_8.setText(myFunction.SENDMSG_8);
        selfDialogEdtAfter_9.setText(myFunction.SENDMSG_9);
        selfDialogEdtAfter_10.setText(myFunction.SENDMSG_10);
        selfDialogEdtAfter_11.setText(myFunction.SENDMSG_11);
        selfDialogEdtAfter_12.setText(myFunction.SENDMSG_12);
    }

}
