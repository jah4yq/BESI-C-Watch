

package edu.virginia.cs.mooncake.wada.Commn;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Sharedd {


    public static boolean writeToFile( Date time1, String data){
        boolean flag = true;
        //boolean flag = false;



        //String path = Environment.getExternalStorageDirectory() + "/estim00/data";
        String path = Environment.getExternalStorageDirectory() + "/wada/data";
        //String fileName=  "Data_" + time1;
        String fileName=  "estimote";
        File file = new File(path);

        Log.i("Thread ", "for saving sensor samples" + Environment.getExternalStorageDirectory());
        if (file.exists()==false) {
            file.mkdirs();
            Log.i("Thread ", "for saving sensor " + file.exists());
        }

        String filepath = path + "/" + fileName;
        try {
            //Log.i("Thread ", "for saving sensor samples");
            FileOutputStream fStream = new FileOutputStream(filepath,true);
            //Log.i("Thread ", "for saving sensor samples");
            fStream.write(data.getBytes());
             Log.i("Thread ", "TEST");
            //  fStream.flush();
            // fStream.close();
            //flag=true;
            // return true;
        } catch(Exception ex) {
            flag=false;
            Log.d("File save fail", ex.getMessage());
        }
        return  flag;

    }





}
