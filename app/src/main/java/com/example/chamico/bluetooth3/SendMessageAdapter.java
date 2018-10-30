package com.example.chamico.bluetooth3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static com.example.chamico.bluetooth3.BluetoothChatService.inputDate;
import static com.example.chamico.bluetooth3.ContronlActivity.contronlActivity;
import static com.example.chamico.bluetooth3.ContronlActivity.outputDate;

/**
 * Created by Chamico on 2018/6/11.
 */

public class SendMessageAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return contronlActivity.mySendMessageListt.size();
    }

    @Override
    public Object getItem(int position) {
        return contronlActivity.mySendMessageListt.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String str = (String) getItem(position);

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_message,null);

        TextView myTextView = (TextView) itemView.findViewById(R.id.list_message);

        myTextView.setText(str);
        return itemView;
    }
}