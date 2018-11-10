package com.example.chamico.bluetooth3;


import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import static android.os.Environment.MEDIA_MOUNTED;
import static com.example.chamico.bluetooth3.MainActivity.mainActivity;
import static com.example.chamico.bluetooth3.MyFunction.myFunction;



/**
 * Created by Chamico on 2018/10/30.
 */



public class Files {

    public static Files myFiles = new Files();

    public String localFolderAddress = "/storage/emulated/0/Android/data/com.example.chamico.bluetooth3/files/BlueTooth_Chamico";

    public File folderAppInfo = new File(localFolderAddress + "/appInfo.txt");
    public File folderSenData = new File(localFolderAddress + "/sendData.txt");
    public void initFile(){

        createFolder();

        if(!folderAppInfo.exists()){
            createFileAppInfo();
        }else {
            Log.d("File.e.print","appInfo.txt exists");
            readFileAppInfo();
        }

        if(!folderSenData.exists()){
            createFileSendData();
        }else {
            Log.d("File.e.print","sendData.txt exists");
            readFileSendData();
        }

    }

    public void createFileAppInfo(){

        String[] contextAppInfo = {"APP_NAME@" + myFunction.getAPP_NAME(), "AUTHOR_INFO@" + myFunction.getAUTUOR_INFO()};

        if(folderAppInfo.exists()){
            folderAppInfo.delete();
        }

        for(int i = 0; i < 2; i++){
            writeTxtToFile(contextAppInfo[i],localFolderAddress, "/appInfo.txt");
        }
    }

    public void readFileAppInfo(){
        String[] contextAppInfo = {"APP_NAME@" + myFunction.getAPP_NAME(), "AUTHOR_INFO@" + myFunction.getAUTUOR_INFO()};

        String temp = null;
        String array[] = {};
        String arr[] = {};
        array = readFile(localFolderAddress + "/appInfo.txt");

        //Log.d("File.e.print",array.length + "");
        //读取文件信息
        for(int i = 0; i < array.length; i++)
        {
            contextAppInfo[i] = array[i];
            arr = contextAppInfo[i].split("\\@");
            temp = arr[1];
            //Log.d("File.e.print",temp);
            //对读取的内容分开保存
            if(i == 0){
                myFunction.setAPP_NAME(temp);
            }else if(i == 1){
                myFunction.setAUTUOR_INFO(temp);
            }

        }
    }

    public void createFileSendData(){

        String[] contextSendData = {
                myFunction.getSEND_BTN_DISP_1() + "@" + myFunction.getSEND_INFO_1(),
                myFunction.getSEND_BTN_DISP_2() + "@" + myFunction.getSEND_INFO_2(),
                myFunction.getSEND_BTN_DISP_3() + "@" + myFunction.getSEND_INFO_3(),
                myFunction.getSEND_BTN_DISP_4() + "@" + myFunction.getSEND_INFO_4(),
                myFunction.getSEND_BTN_DISP_5() + "@" + myFunction.getSEND_INFO_5(),
                myFunction.getSEND_BTN_DISP_6() + "@" + myFunction.getSEND_INFO_6(),
                myFunction.getSEND_BTN_DISP_7() + "@" + myFunction.getSEND_INFO_7(),
                myFunction.getSEND_BTN_DISP_8() + "@" + myFunction.getSEND_INFO_8(),
                myFunction.getSEND_BTN_DISP_9() + "@" + myFunction.getSEND_INFO_9(),
                myFunction.getSEND_BTN_DISP_10() + "@" + myFunction.getSEND_INFO_10(),
                myFunction.getSEND_BTN_DISP_12() + "@" + myFunction.getSEND_INFO_11(),
                myFunction.getSEND_BTN_DISP_12() + "@" + myFunction.getSEND_INFO_12(),
        };

        if(folderSenData.exists()){
            boolean b = folderSenData.delete();

            if(b){
                Log.e("CreateFile","Yes");
            }else {
                Log.e("CreateFile","No");
            }
        }

        Log.e("CreateFile55",myFunction.getSEND_BTN_DISP_1()+ "   9");
        Log.e("CreateFile55",myFunction.getSEND_INFO_1()+ "   9");

        for(int i = 0; i < 12; i++){
            writeTxtToFile(contextSendData[i],localFolderAddress, "/sendData.txt");

            Log.e("CreateFile55",contextSendData[i]+ "   9");
        }

    }

    public void readFileSendData(){

        String[] contextSendData = {
                myFunction.getSEND_BTN_DISP_1() + "@" + myFunction.getSEND_INFO_1(),
                myFunction.getSEND_BTN_DISP_2() + "@" + myFunction.getSEND_INFO_2(),
                myFunction.getSEND_BTN_DISP_3() + "@" + myFunction.getSEND_INFO_3(),
                myFunction.getSEND_BTN_DISP_4() + "@" + myFunction.getSEND_INFO_4(),
                myFunction.getSEND_BTN_DISP_5() + "@" + myFunction.getSEND_INFO_5(),
                myFunction.getSEND_BTN_DISP_6() + "@" + myFunction.getSEND_INFO_6(),
                myFunction.getSEND_BTN_DISP_7() + "@" + myFunction.getSEND_INFO_7(),
                myFunction.getSEND_BTN_DISP_8() + "@" + myFunction.getSEND_INFO_8(),
                myFunction.getSEND_BTN_DISP_9() + "@" + myFunction.getSEND_INFO_9(),
                myFunction.getSEND_BTN_DISP_10() + "@" + myFunction.getSEND_INFO_10(),
                myFunction.getSEND_BTN_DISP_12() + "@" + myFunction.getSEND_INFO_11(),
                myFunction.getSEND_BTN_DISP_12() + "@" + myFunction.getSEND_INFO_12(),
        };

        String tempDisp = null;
        String tempData = null;
        String array[] = {};
        String arr[] = {};
        array = readFile(localFolderAddress + "/sendData.txt");

        Log.d("File.e.print","SendData.Length    " + array.length );
        //读取文件信息
        for(int i = 0; i < array.length; i++) {
            contextSendData[i] = array[i];

            arr = contextSendData[i].split("\\@");
            tempDisp = arr[0];
            tempData = arr[1];
            Log.d("File.e.print1", tempDisp + "@" + tempData);


            //对读取的内容分开保存
            switch (i){
                case 0:
                    myFunction.setSEND_BTN_DISP_1(tempDisp);
                    myFunction.setSEND_INFO_1(tempData);
                    break;
                case 1:
                    myFunction.SEND_BTN_DISP_2 = tempDisp;
                    myFunction.SEND_INFO_2 = tempData;
                    break;
                case 2:
                    myFunction.SEND_BTN_DISP_3 = tempDisp;
                    myFunction.SEND_INFO_3 = tempData;
                    break;
                case 3:
                    myFunction.SEND_BTN_DISP_4 = tempDisp;
                    myFunction.SEND_INFO_4 = tempData;
                    break;
                case 4:
                    myFunction.SEND_BTN_DISP_5 = tempDisp;
                    myFunction.SEND_INFO_5 = tempData;
                    break;
                case 5:
                    myFunction.SEND_BTN_DISP_6 = tempDisp;
                    myFunction.SEND_INFO_6 = tempData;
                    break;
                case 6:
                    myFunction.SEND_BTN_DISP_7 = tempDisp;
                    myFunction.SEND_INFO_7 = tempData;
                    break;
                case 7:
                    myFunction.SEND_BTN_DISP_8 = tempDisp;
                    myFunction.SEND_INFO_8 = tempData;
                    break;
                case 8:
                    myFunction.SEND_BTN_DISP_9 = tempDisp;
                    myFunction.SEND_INFO_9 = tempData;
                    break;
                case 9:
                    myFunction.SEND_BTN_DISP_10 = tempDisp;
                    myFunction.SEND_INFO_10 = tempData;
                    break;
                case 10:
                    myFunction.SEND_BTN_DISP_11 = tempDisp;
                    myFunction.SEND_INFO_11 = tempData;
                    break;
                case 11:
                    myFunction.SEND_BTN_DISP_12 = tempDisp;
                    myFunction.SEND_INFO_12 = tempData;
                    break;
            }
        }

    }

    //打印手机外部存储信息
    public void printExternalFilesInfo(){
        File[] files;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            files = mainActivity.getExternalFilesDirs(MEDIA_MOUNTED);
            for(File file:files){
                Log.d("File.e.print","Test print Log.e");
                Log.d("File.e.print",file.toString());
            }
        }
    }

    public void createFolder() {

        //Floder location: /storage/emulated/0/Android/data/com.example.chamico.bluetooth3/files/Bluetooth_Chamico

        String directoryPath="";
        if (MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ) {//判断外部存储是否可用
            mainActivity.getExternalFilesDir("BlueTooth_Chamico").getAbsolutePath();
            Log.d("File.e.print","External storage can be use");
        }else{//没外部存储就使用内部存储
            Log.d("File.e.print","External storage can't be use");
            //directoryPath=mainActivity.getFilesDir()+File.separator+"BlueTooth_Chamico";
        }
        File file = new File(localFolderAddress);
        if(!file.exists()){//判断文件目录是否存在
            boolean bool = file.mkdirs();
            if(bool){
                Log.d("File.e.print","Create folder successfully");
            }else {
                Log.d("File.e.print","Create folder failed");
            }
        }else{
            Log.d("File.e.print","The folder exists");
        }
    }



    // 将字符串写入到文本文件中
    public void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        makeFilePath(filePath, fileName);

        String strFilePath = filePath + fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("File.e.print", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.d("File.e.print", "Error on write File:" + e);
        }
    }

    // 生成文件
    public File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    // 生成文件夹
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.d("File.e.print", e + "");
        }
    }

    public String[] readFile(String filePath) {

        String[] returnString= {};
        if (filePath == null)
            Log.d("File.e.print","File path empty");

        File file = new File(filePath);
        if (file.isDirectory()) {
            Log.d("File.e.print","File path is directory");;
        } else {
            try {
                InputStream is = new FileInputStream(file);
                if (is != null) {
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line;
                    while ((line = br.readLine()) != null) {

                        returnString = insert(returnString,line);
                        //Log.d("File.e.print",line);
                    }
                }
            } catch (FileNotFoundException e) {
                Log.d("File.e.print", filePath + " doesn't found!");
            } catch (IOException e) {
                Log.d("File.e.print", filePath + " read exception, " + e.getMessage());
            }
        }


        return returnString;
    }

    private static String[] insert(String[] arr, String str) {
        int size = arr.length;  //获取数组长度
        String[] tmp = new String[size + 1];  //新建临时字符串数组，在原来基础上长度加一
        for (int i = 0; i < size; i++){  //先遍历将原来的字符串数组数据添加到临时字符串数组
            tmp[i] = arr[i];
        }
        tmp[size] = str;  //在最后添加上需要追加的数据
        return tmp;  //返回拼接完成的字符串数组
    }
}
