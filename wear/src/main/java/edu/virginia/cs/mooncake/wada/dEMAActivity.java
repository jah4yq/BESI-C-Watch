package edu.virginia.cs.mooncake.wada;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.virginia.cs.mooncake.wada.utils.DateTimeUtil;
import edu.virginia.cs.mooncake.wada.utils.FileUtil;
import edu.virginia.cs.mooncake.wada.utils.ServiceUtil;
import edu.virginia.cs.mooncake.wada.utils.SharedPrefUtil;
import edu.virginia.cs.mooncake.wada.utils.WadaUtils;

import static edu.virginia.cs.mooncake.wada.utils.FileUtil.saveStringToFile;


public class dEMAActivity extends Activity{

    int EMAcount, i;
    String question;
    private TextView questionView, answerView;
    private TextView q,a;
    String[] answer;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memento_ema);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(1000);

        EMAcount = 0;
        i = 10000000;



        //date.format(new Date(System.currentTimeMillis()));


        if (EMAcount == 0) {

            question = "How active were you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very" };

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);


        }
        if (EMAcount == 1) {

            //i=5;

            question = "How busy was your home?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 2) {

            //i=2;

            question = "Time spent outside your home?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 3) {

            //i=2;

            question = "How much time did you spend with other people?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 4){

            question = "How distressed were you overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 5){

            //question = "How much did pain interfere with your life?";
            question = "How did the patient's pain interfere with your life?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 6){

            question = "How was your mood overall?";

            String[] answer = {"Poor", "Fair", "Good", "Excellent"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 7){

            //question = "How distressed was your caregiver overall?";
            question = "How distressed was the patient overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%5]);

        }





    }


    public void incClick(View v) {
        i++;

        if (EMAcount == 0) {

            question = "How active were you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very" };

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);


        }
        if (EMAcount == 1) {

            //i=5;

            question = "How busy was your home?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 2) {

            //i=2;

            question = "Time spent outside your home?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 3) {

            //i=2;

            question = "How much time did you spend with other people?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 4){

            question = "How distressed were you overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 5){

            //question = "How much did pain interfere with your life?";
            question = "How did the patient's pain interfere with your life?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 6){

            question = "How was your mood overall?";

            String[] answer = {"Poor", "Fair", "Good", "Excellent"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 7){

            //question = "How distressed was your caregiver overall?";
            question = "How distressed was the patient overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%5]);

        }


        //setEMA(answer,question,answer[i]);

    }

    public void decClick(View v) {
        i--;

        //setEMA(answer,q,a);

        if (EMAcount == 0) {

            question = "How active were you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very" };

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);


        }
        if (EMAcount == 1) {

            //i=5;

            question = "How busy was your home?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 2) {

            //i=2;

            question = "Time spent outside your home?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 3) {

            //i=2;

            question = "How much time did you spend with other people?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 4){

            question = "How distressed were you overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 5){

            //question = "How much did pain interfere with your life?";
            question = "How did the patient's pain interfere with your life?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 6){

            question = "How was your mood overall?";

            String[] answer = {"Poor", "Fair", "Good", "Excellent"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 7){

            //question = "How distressed was your caregiver overall?";
            question = "How distressed was the patient overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%5]);

        }

    }

    public void nextClick(View v) {



        //Save answer

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        if (EMAcount == 0) {

            String response = a.getText().toString();

            String painText = "DAILY EMA 1, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);

        }
        if (EMAcount == 1) {
            String response = a.getText().toString();
            String painText = "DAILY EMA 2, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);
        }
        if (EMAcount == 2) {
            String response = a.getText().toString();
            String painText = "DAILY EMA 3, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);

        }
        if (EMAcount == 3) {
            String response = a.getText().toString();
            String painText = "DAILY EMA 4, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);

        }
        if (EMAcount == 4){
            String response = a.getText().toString();
            String painText = "DAILY EMA 5, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);

        }
        if (EMAcount == 5){
            String response = a.getText().toString();
            String painText = "DAILY EMA 6, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);

        }
        if (EMAcount == 6){
            String response = a.getText().toString();
            String painText = "DAILY EMA 7, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);

        }
        if (EMAcount == 7){
            String response = a.getText().toString();
            String painText = "DAILY EMA 8, " + response+ ", " + date.format(new Date(System.currentTimeMillis()))+ "\n";
            String fileName = "daily";
            FileOutputStream fos = null;

            saveStringToFile(fileName, painText);

        }

        EMAcount++;

        if (EMAcount == 0) {

            question = "How active were you?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very" };

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);


        }
        if (EMAcount == 1) {

            //i=5;

            question = "How busy was your home?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 2) {

            //i=2;

            question = "Time spent outside your home?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 3) {

            //i=2;

            question = "How much time did you spend with other people?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 4){

            question = "How distressed were you overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 5){

            //question = "How much did pain interfere with your life?";
            question = "How did the patient's pain interfere with your life?";

            String[] answer = {"None", "A little", "Medium", "A lot"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 6){

            question = "How was your mood overall?";

            String[] answer = {"Poor", "Fair", "Good", "Excellent"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%4]);

        }
        if (EMAcount == 7){

            //question = "How distressed was your caregiver overall?";
            question = "How distressed was the patient overall?";

            String[] answer = {"Not at all", "A little", "Moderately", "Very", "Unsure"};

            q = (TextView)findViewById(R.id.questionView);
            q.setText(question);

            a = (TextView)findViewById(R.id.answerView);
            a.setText(answer[i%5]);

        }
        if (EMAcount >= 8){
            //special conditions

            Toast.makeText(this,"Thank you!",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, ClockfaceActivity.class));

        }


    }






}
