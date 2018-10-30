package com.example.chamico.bluetooth3;

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static com.example.chamico.bluetooth3.Open.open;

/**
 * Created by Chamico on 2018/5/16.
 *   @Explain:  This File have include the unbonuded bluetooth device infomation
 *  @Date: 2018/06/17
 */

public class DeviceAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return open.mDeviceList.size();
    }

    @Override
    public Object getItem(int position) {
        return open.mDeviceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_info,null);

        BluetoothDevice device = (BluetoothDevice) getItem(position);

        TextView textViewName = (TextView) itemView.findViewById(R.id.listName);
        TextView textViewAddress = (TextView) itemView.findViewById(R.id.listAddress);

        textViewName.setText(device.getName());
        textViewAddress.setText(device.getAddress());
        return itemView;
    }
}
