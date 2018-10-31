package com.example.chamico.bluetooth3;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import static android.content.ContentValues.TAG;
import static com.example.chamico.bluetooth3.MainActivity.mainActivity;

/**
 * Created by Chamico on 2018/10/30.
 */



public class Files extends Application {


    public void save()
    {

        //File apkFile = context.getDir("apkDir", Context.MODE_PRIVATE);

        File path = mainActivity.getExternalCacheDir();
        Log.e("path_value",""+ path);
    }

    public void initData() {
        String filePath = "/sdcard/TEST/";
        String fileName = "log.txt";

        writeTxtToFile("txt content", filePath, fileName);
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
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
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
            Log.i("error:", e + "");
        }
    }

    public void readFile(String filePath) {


        //  /storage/emulated/0/Android/data/com.example.chamico.bluetooth3/cache
        if (filePath == null) return;

        File file = new File(filePath);
        if (file.isDirectory()) {
           // Log.d(TAG, filePath + " is directory");
            return;
        } else {
            try {
                InputStream is = new FileInputStream(file);
                if (is != null) {
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    String line;
                    while ((line = br.readLine()) != null) {
                        Log.d(TAG, line);
                    }
                }
            } catch (FileNotFoundException e) {
                Log.d(TAG, filePath + " doesn't found!");
            } catch (IOException e) {
                Log.d(TAG, filePath + " read exception, " + e.getMessage());
            }
        }
    }
}




