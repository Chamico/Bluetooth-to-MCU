package com.example.chamico.bluetooth3;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;


import static android.R.attr.direction;
import static android.R.attr.factor;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.chamico.bluetooth3.ContronlActivity.contronlActivity;
import static com.example.chamico.bluetooth3.MainActivity.mainActivity;

/**
 * Created by Chamico on 2018/6/12.
 *  @Explain:  This File have include the listView when you clicked the "更多" button
 *  @Date: 2018/06/17
 */

public class ItemsDialogFragment extends DialogFragment {

    public Button selfDialogBtnSaveDate;

    private MyFunction myFunction = new MyFunction();

    private String title;

    private String[] items;

    private DialogInterface.OnClickListener onClickListener;

    private SelfDialog selfDialog = new SelfDialog(contronlActivity);

    public void show(String title, String[] items, DialogInterface.OnClickListener onClickListener,
                     FragmentManager fragmentManager) {
        this.title = title;
        this.items = items;
        this.onClickListener = onClickListener;
        show(fragmentManager, "ItemsDialogFragment");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title).setItems(items, onClickListener);
        return builder.create();

    }

    /*
    #系列自定义函数
     */

    public void directionUse(){
        new AlertDialog.Builder(contronlActivity)
                .setTitle("说明")
                .setIcon(R.drawable.contronl_explain)
                .setMessage(
                        "1、控制页默认发送信息和按钮显示的信息一致\n\n    " +
                        "2、若需要修改按钮显示内容，点击“更多”-> “配置按钮”，根据显示的提示信息对按钮显示信息和发送信息进行修改，最下面有“保存”和“退出”\n\n    " +
                                "3、点击相依的按钮可将信息发送到已连接的蓝牙设备上\n\n    " +
                                "4、同时显示发送的信息和接收的信息到屏幕\n\n    " +
                                "5、点击“连接”可返回连接目录" )
                .setNegativeButton("确定", null)
                .show();
    }

    public void setButton(){

        SelfDialog selfDialog = new SelfDialog(getActivity(),R.style.Dialog);
        selfDialog.show();

    }

    public void exitActivity(){
        new AlertDialog.Builder(contronlActivity)
                .setIcon(R.drawable.contronl_exit)
                .setTitle("退出")
                .setMessage("请确定是否退出此应用")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        contronlActivity.finish();
                        mainActivity.finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .show();
    }

}
